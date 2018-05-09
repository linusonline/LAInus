package se.lolektivet.nono;

import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.*;
import java.util.stream.Collectors;

public class ChainedDeductor {
   public static class Streak {
      private final int _startIndex;
      private final int _length;

      public Streak(int start, int length) {
         _startIndex = start;
         _length = length;
      }

      public int getLength() {
         return _length;
      }

      public int getStart() {
         return _startIndex;
      }

      public int getEnd() {
         return _startIndex + _length;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Streak streak = (Streak) o;
         return _startIndex == streak._startIndex &&
               _length == streak._length;
      }

      @Override
      public int hashCode() {

         return Objects.hash(_startIndex, _length);
      }
   }

   public static List<Clue> createClues(List<Integer> numberClues, int lineLength) {
      List<Clue> clues = new ArrayList<>();
      int minimum = numberClues.stream().mapToInt(Integer::intValue).sum() + numberClues.size() - 1;
      int slack = lineLength - minimum;

      int nextEarliestStart = 0;
      for (Integer numberClue : numberClues) {
         clues.add(new Clue(numberClue, nextEarliestStart, nextEarliestStart + slack));
         nextEarliestStart += (numberClue + 1);
      }
      return clues;
   }

   public static List<Clue> fitCluesToGapsOnce(List<SquareState> existing, List<Clue> clues) {

      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {
         int gapStart = clues.get(clueNr).earliestStart;
         int firstFit = findFirstFit(clues.get(clueNr).value, existing, gapStart);
         int offset = firstFit - gapStart;

         pushClueToRight(clues, clueNr, offset);

         if (clues.get(clueNr).earliestEnd < existing.size() && existing.get(clues.get(clueNr).earliestEnd).isFilled()) {
            pushClueToRight(clues, clueNr, 1);
         }
      }

      return clues;
   }

   public static List<Clue> fitCluesRightToStreaksOnce(List<SquareState> line, List<Clue> clues) {
      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {

         int earliestEnd = clues.get(clueNr).earliestEnd;
         while (earliestEnd < line.size() && line.get(earliestEnd).isFilled()) {
            earliestEnd++;
         }
         int push = earliestEnd - clues.get(clueNr).earliestEnd;
         pushClueToRight(clues, clueNr, push);
      }
      return clues;
   }

   public static List<Clue> fitCluesToStreaks(List<SquareState> line, List<Clue> clues) {
      List<Streak> streaks = listStreaks(line);
      Map<Streak, List<Integer>> possibleCluesForStreaks = new HashMap<>(streaks.size());
      for (Streak streak : streaks) {
         List<Integer> possibleClues = new ArrayList<>();
         possibleCluesForStreaks.put(streak, possibleClues);
         for (int clue = 0; clue < clues.size(); clue++) {
            if (streakFitsClue(streak, clues.get(clue))) {
               possibleClues.add(clue);
            }
         }
         if (possibleClues.size() < 1) {
            throw new ContradictionException();
         }
         if (possibleClues.size() == 1) {
            fitClueToStreak(streak, clues, possibleClues.get(0));
         }
         // Take the shortest of the possible clues.
         // Create a new clue with that size, and limits that just fit the streak
         // Fit that clue to the gap where the streak is.
         // Reapply the clue to the line (fill in overlap btw earliest and latest.
         //    5, 3 [     . X       ] -> [     . XX      ]
      }

      return clues;
   }

   private static void fitClueToStreak(Streak streak, List<Clue> clues, int clueIndex) {
      Clue clue = clues.get(clueIndex);
      int offsetRight = Math.max(0, streak._startIndex + streak._length - clue.earliestEnd);
      pushClueToRight(clues, clueIndex, offsetRight);
      int offsetLeft = Math.max(0, clue.latestStart - streak._startIndex);
      pullCluesToLeft(clues, clueIndex, offsetLeft);
   }

   public static boolean streakFitsClue(Streak streak, Clue clue) {
      return streak._length <= clue.value &&
            clue.earliestStart <= streak._startIndex &&
            streak._startIndex + streak._length <= clue.latestEnd;
   }

   // TODO: Look for streaks that can only fit to a single clue (fit: earliest start < streak start, streak end < latest end, streak length <= length)
   // TODO: When considering whether a clue fits a streak, need also combine the streak in question with all other streaks that are known to ONLY fit the clue in question.
   //    3, 3 [  X XX    ] -> [XXX.XXX....]
   // TODO: How to solve this?
   //    3, 3 [     XX XX     ] -> [....XXX.XXX....]
   //    3, 3 [     XX  XX    ] -> [.... XX  XX ...]
   //    5, 5 [         XX  XX  X      ] -> [...... XXXX  XXXXX......]
   // Could possibly iterate over streaks and for each pair of streaks, consider them as one streak and see if it would
   // fit any clue. Kind of backward from above to-do ideas.

   public static List<SquareState> sillyDeduction(List<SquareState> line, List<Integer> clueNumbers) {
      List<Clue> clues = ChainedDeductor.createClues(clueNumbers, line.size());

      List<ChainedDeduction> chain = new ArrayList<>(2);
      chain.add(ChainedDeductor::fitCluesToGapsOnce);
      chain.add(ChainedDeductor::fitCluesRightToStreaksOnce);

      applyDeductionChain(chain, line, clues);
      applyDeductionChainRightToLeft(chain, line, clues);

      return Deductor.cluesToAnswer(clues, line).get();
   }

   private static List<Clue> applyDeductionChainRightToLeft(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      // Reverse line
      List<SquareState> reverseLine = new ArrayList<>(line);
      Collections.reverse(reverseLine);

      // Reverse clues
      List<Clue> reverseClues = getReverseClues(clues, line.size());

      // Apply deduction chain right to left
      applyDeductionChain(chain, reverseLine, reverseClues);

      // To fulfill contract, "clues" needs to be modified with final answer
      List<Clue> finalClues = getReverseClues(reverseClues, line.size());
      Collections.copy(clues, finalClues);

      return clues;
   }

   private static List<Clue> applyDeductionInBothDirections(ChainedDeduction deduction, List<SquareState> line, List<Clue> clues) {
      // First deduction, applied left to right
      deduction.apply(line, clues);

      // Reverse line
      List<SquareState> reverseLine = new ArrayList<>(line);
      Collections.reverse(reverseLine);

      // Reverse clues
      List<Clue> reverseClues = getReverseClues(clues, line.size());

      // Second deduction, applied right to left
      deduction.apply(reverseLine, reverseClues);

      // To fulfill contract, "clues" needs to be modified with final answer
      List<Clue> finalClues = getReverseClues(reverseClues, line.size());
      Collections.copy(clues, finalClues);

      return clues;
   }

   private static List<Clue> getReverseClues(List<Clue> clues, final int lineLength) {
      List<Clue> reverseClues = clues.stream().map((clue) -> getReverseClue(clue, lineLength)).collect(Collectors.toList());
      Collections.reverse(reverseClues);
      return reverseClues;
   }

   public static Clue getReverseClue(Clue clue, int lineLength) {
      return new Clue(clue.value, lineLength - clue.latestEnd, lineLength - clue.earliestEnd);
   }

   static int findFirstFit(int clue, List<SquareState> existing, int start) {
      for (int i = start; i < start + clue; i++) {
         if (i >= existing.size()) {
            throw new ContradictionException();
         }
         if (existing.get(i).isCrossed()) {
            start = i + 1;
         }
      }
      return start;
   }

   static void offsetCluesToRight(List<Clue> clues, int firstClueFromLeft, int offset) {
      for (int i = firstClueFromLeft; i < clues.size(); i++) {
         clues.get(i).earliestStart += offset;
         clues.get(i).earliestEnd += offset;
      }
   }

   private static void pushClueToRight(List<Clue> clues, int clueIndex, int push) {
      clues.get(clueIndex).earliestStart += push;
      clues.get(clueIndex).earliestEnd += push;
      if (clueIndex + 1 < clues.size()) {
         int separation = clues.get(clueIndex + 1).earliestStart - clues.get(clueIndex).earliestEnd;
         if (separation < 1) {
            pushClueToRight(clues, clueIndex + 1, 1 - separation);
         }
      }
   }

   private static void pullCluesToLeft(List<Clue> clues, int clueIndex, int pull) {
      clues.get(clueIndex).latestStart -= pull;
      clues.get(clueIndex).latestEnd -= pull;
      if (clueIndex > 0) {
         int separation = clues.get(clueIndex).latestStart - clues.get(clueIndex - 1).latestEnd;
         if (separation < 1) {
            pullCluesToLeft(clues, clueIndex - 1, 1 - separation);
         }
      }
   }

   private static void setLatestStartForClue(Clue clue, int latestStart) {
      if (latestStart > clue.latestStart) {
         throw new ContradictionException();
      }
      clue.latestStart = latestStart;
      clue.latestEnd = latestStart + clue.value;
   }

   public static List<Streak> listStreaks(List<SquareState> line) {
      List<Streak> streaks = new ArrayList<>();

      boolean isInStreak = false;
      int streakStart = -1;
      int streakLength = 0;

      for (int i = 0; i < line.size(); i++) {
         SquareState state = line.get(i);
         if (state.isFilled()) {
            if (!isInStreak) {
               streakStart = i;
               isInStreak = true;
            }
            streakLength++;
         } else if (isInStreak) {
            streaks.add(new Streak(streakStart, streakLength));
            isInStreak = false;
            streakLength = 0;
         }
      }
      if (isInStreak) {
         streaks.add(new Streak(streakStart, streakLength));
      }
      return streaks;
   }

   public static List<SquareState> applyDeductionChainFully(List<ChainedDeduction> chain, List<SquareState> line, List<Integer> clues) {
      List<Clue> workingClues = ChainedDeductor.createClues(clues, line.size());

      applyDeductionChain(chain, line, workingClues);

      return Deductor.cluesToAnswer(workingClues, line).get();
   }

   public static List<Clue> applyDeductionChain(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      for (ChainedDeduction deduction : chain) {
         deduction.apply(line, clues);
      }
      return clues;
   }

   public static List<SquareState> fitToGapsAndStreaksRepeated(List<SquareState> line, List<Integer> clues) {
      List<Clue> workingClues = ChainedDeductor.createClues(clues, line.size());

      List<ChainedDeduction> chain = Arrays.asList(ChainedDeductor::fitCluesToStreaks, (aLine, someClues) -> applyDeductionInBothDirections(ChainedDeductor::fitCluesToGapsOnce, aLine, someClues));
      applyDeductionChainRepeated(chain, line, workingClues);

      return Deductor.cluesToAnswer(workingClues, line).get();
   }

   public static List<Clue> applyDeductionChainRepeated(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      List<Clue> oldClues;
      int deduction = 0;
      do {
         oldClues = new ArrayList<>(clues);
         chain.get(deduction).apply(line, clues);
         if (++deduction >= chain.size()) {
            deduction = 0;
         }
      } while (!oldClues.equals(clues));

      return clues;
   }
}

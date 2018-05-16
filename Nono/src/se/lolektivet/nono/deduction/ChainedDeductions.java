package se.lolektivet.nono.deduction;

import se.lolektivet.nono.Util;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.*;

public class ChainedDeductions {
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

   public static List<Clue> fitCluesToGapsRight(List<SquareState> line, List<Clue> clues) {

      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {
         fitOneClueToGapRight(line, clues, clueNr);
      }

      return clues;
   }

   public static List<Clue> fitCluesToGapsLeft(List<SquareState> line, List<Clue> clues) {

      for (int clueNr = clues.size(); clueNr > 0; clueNr--) {
         fitOneClueToGapLeft(line, clues, clueNr);
      }

      return clues;
   }

   public static List<Clue> fitCluesToGapsBoth(List<SquareState> line, List<Clue> clues) {
      fitCluesToGapsRight(line, clues);
      return fitCluesToGapsLeft(line, clues);
   }

   public static List<Clue> fitCluesToStreaksRight(List<SquareState> line, List<Clue> clues) {
      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {
         fitOneClueToStreakRight(line, clues, clueNr);
      }
      return clues;
   }

   public static List<Clue> fitCluesToStreaksLeft(List<SquareState> line, List<Clue> clues) {
      for (int clueNr = clues.size(); clueNr > 0; clueNr--) {
         fitOneClueToStreakLeft(line, clues, clueNr);
      }
      return clues;
   }

   public static List<Clue> fitCluesToStreaksBoth(List<SquareState> line, List<Clue> clues) {
      fitCluesToStreaksRight(line, clues);
      return fitCluesToStreaksLeft(line, clues);
   }

   public static List<Clue> mapCluesToStreaks(List<SquareState> line, List<Clue> clues) {
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
            fitClueToStreak(streak, clues, possibleClues.get(0), line.size());
         }
         // Take the shortest of the possible clues.
         // Create a new clue with that size, and limits that just fit the streak
         // Fit that clue to the gap where the streak is.
         // Reapply the clue to the line (fill in overlap btw earliest and latest.
         //    5, 3 [     . X       ] -> [     . XX      ]
      }

      return clues;
   }

   public static List<Clue> fitCluesToGapsAndStreaksRight(List<SquareState> line, List<Clue> clues) {

      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {
         fitOneClueToGapRight(line, clues, clueNr);
         fitOneClueToStreakRight(line, clues, clueNr);
      }

      return clues;
   }

   public static List<Clue> fitCluesToGapsAndStreaksLeft(List<SquareState> line, List<Clue> clues) {

      for (int clueNr = clues.size(); clueNr > 0; clueNr--) {
         fitOneClueToGapLeft(line, clues, clueNr);
         fitOneClueToStreakLeft(line, clues, clueNr);
      }

      return clues;
   }

   public static List<Clue> fitCluesToGapsAndStreaksBoth(List<SquareState> line, List<Clue> clues) {
      fitCluesToGapsAndStreaksRight(line, clues);
      return fitCluesToGapsAndStreaksLeft(line, clues);
   }



   private static void fitOneClueToStreakRight(List<SquareState> line, List<Clue> clues, int clueNr) {
      int earliestEnd = clues.get(clueNr).earliestEnd;
      while (earliestEnd < line.size() && line.get(earliestEnd).isFilled()) {
         earliestEnd++;
      }
      int push = earliestEnd - clues.get(clueNr).earliestEnd;
      Util.pushClueToRight(clues, clueNr, push, line.size());
   }

   private static void fitOneClueToGapRight(List<SquareState> line, List<Clue> clues, int clueNr) {
      int gapStart = clues.get(clueNr).earliestStart;
      int firstFit = findFirstFit(clues.get(clueNr).value, line, gapStart);
      int offset = firstFit - gapStart;

      Util.pushClueToRight(clues, clueNr, offset, line.size());
   }

   private static void fitOneClueToGapLeft(List<SquareState> line, List<Clue> clues, int clueNr) {
      int gapStart = clues.get(clueNr - 1).latestEnd;
      int firstFit = findFirstFitLeft(clues.get(clueNr - 1).value, line, gapStart);
      int offset = gapStart - firstFit;

      Util.pullClueToLeft(clues, clueNr - 1, offset);
   }

   private static void fitOneClueToStreakLeft(List<SquareState> line, List<Clue> clues, int clueNr) {
      int latestStart = clues.get(clueNr - 1).latestStart;
      while (latestStart > 0 && line.get(latestStart - 1).isFilled()) {
         latestStart--;
      }
      int pull = clues.get(clueNr - 1).latestStart - latestStart;
      Util.pullClueToLeft(clues, clueNr - 1, pull);
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

   private static void fitClueToStreak(Streak streak, List<Clue> clues, int clueIndex, int lineLength) {
      Clue clue = clues.get(clueIndex);
      int offsetRight = Math.max(0, streak._startIndex + streak._length - clue.earliestEnd);
      Util.pushClueToRight(clues, clueIndex, offsetRight, lineLength);
      int offsetLeft = Math.max(0, clue.latestStart - streak._startIndex);
      Util.pullClueToLeft(clues, clueIndex, offsetLeft);
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

   public static int findFirstFitLeft(int clue, List<SquareState> line, int start) {
      for (int i = start; i > start - clue; i--) {
         if (i == 0) {
            throw new ContradictionException();
         }
         if (i > line.size()) {
            throw new ContradictionException();
         }
         if (line.get(i - 1).isCrossed()) {
            start = i - 1;
         }
      }
      return start;
   }

   public static int findFirstFit(int clue, List<SquareState> line, int start) {
      for (int i = start; i < start + clue; i++) {
         if (i >= line.size()) {
            throw new ContradictionException();
         }
         if (line.get(i).isCrossed()) {
            start = i + 1;
         }
      }
      return start;
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

}

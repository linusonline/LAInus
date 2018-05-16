package se.lolektivet.nono.deduction;

import se.lolektivet.nono.Util;
import se.lolektivet.nono.model.Solution;
import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deductions {

   public static class Answer {
      private final List<SquareState> _line;

      public Answer(List<SquareState> preExisting) {
         _line = new ArrayList<>(preExisting);
      }

      public void set(int index, SquareState state) {
         SquareState existing = _line.get(index);
         if (existing != SquareState.UNKNOW && existing != state) {
            throw new ContradictionException();
         }
         _line.set(index, state);
      }

      public List<SquareState> get() {
         return _line;
      }
   }

   public static List<SquareState> startingDeduction(List<SquareState> existing, List<Integer> clues) {
      int length = existing.size();
      int minimum = clues.stream().mapToInt(Integer::intValue).sum() + clues.size() - 1;
      int slack = length - minimum;
      if (slack < 0) {
         throw new ContradictionException();
      }
      boolean fullRow = slack == 0;
      Answer answer = new Answer(existing);
      int current = 0;
      for (Integer clue : clues) {
         if (clue > slack) {
            for (int i = current + slack; i < current + clue; i++) {
               answer.set(i, SquareState.FILLED);
            }
            if (fullRow && current + clue < length) {
               answer.set(current + clue, SquareState.STRIKE);
            }
         }
         current += clue + 1;
      }
      return answer.get();
   }

   public static List<SquareState> crossRestIfComplete(List<SquareState> existing, List<Integer> clues) {
      Answer answer = new Answer(existing);

      long filledIn = existing.stream().filter(SquareState::isFilled).count();
      long total = clues.stream().mapToInt(Integer::intValue).sum();
      if (total == filledIn) {
         setAllUnknowns(existing, answer, SquareState.STRIKE);
      }
      return answer.get();
   }

   public static List<SquareState> fillInShortestClueFromEdges(List<SquareState> existing, List<Integer> numbers) {
      return applyDeductionInBothDirections(Deductions::fillInShortestClueFromEdgesOnce, existing, numbers);
   }

   public static List<SquareState> fillInShortestClueFromEdgesOnce(List<SquareState> existing, List<Integer> clues) {
      Answer answer = new Answer(existing);
      final int shortest = getShortestClue(clues);
      int lastBlocked = -1;
      boolean isTracing = false;

      for (int i = 0; i < existing.size(); i++) {
         if (existing.get(i).isCrossed()) {
            lastBlocked = i;
            isTracing = false;
         } else if (isTracing) {
            if (i - lastBlocked <= shortest) {
               answer.set(i, SquareState.FILLED);
            }
         } else {
            if (existing.get(i).isFilled()) {
               isTracing = true;
            }
         }
      }

      return answer.get();
   }

   public static List<SquareState> crossShortGaps(List<SquareState> existing, List<Integer> clues) {
      Answer answer = new Answer(existing);
      final int shortest = getShortestClue(clues);
      int unknownStreak = 0;
      boolean skippingGap = false;
      for (int i = 0; i <= existing.size(); i++) {
         if (i == existing.size() || existing.get(i).isCrossed()) {
            if (!skippingGap && unknownStreak > 0 && unknownStreak < shortest) {
               Util.setAll(existing, answer, i - unknownStreak, i, SquareState.STRIKE);
            }
            skippingGap = false;
            unknownStreak = 0;
         } else if (!skippingGap && i < existing.size()) {
            if (existing.get(i).isUnknown()) {
               unknownStreak++;
            } else if (existing.get(i).isFilled()) {
               skippingGap = true;
            }
         }
      }
      return answer.get();
   }

   public static List<SquareState> fillRestIfCompletelyCrossed(List<SquareState> existing, List<Integer> clues) {
      Answer answer = new Answer(existing);

      long crossed = existing.stream().filter(state -> state == SquareState.STRIKE).count();
      long total = clues.stream().mapToInt(Integer::intValue).sum();
      if (existing.size() - crossed == total) {
         setAllUnknowns(existing, answer, SquareState.FILLED);
      }
      return answer.get();
   }



   public static List<SquareState> repeatDeduction(Deduction deduction, List<SquareState> existing, List<Integer> numbers) {
      long before;
      long after;
      List<SquareState> current = existing;
      List<SquareState> answer;
      after = Solution.knownSquaresInLine(current);
      do {
         before = after;
         answer = deduction.apply(current, numbers);
         after = Solution.knownSquaresInLine(current);
         current = answer;
      } while (before < after);
      return answer;
   }

   private static List<SquareState> applyDeductionInBothDirections(Deduction deduction, List<SquareState> existing, List<Integer> numbers) {
      List<SquareState> answer = deduction.apply(existing, numbers);
      Collections.reverse(answer);
      List<Integer> reverseClues = new ArrayList<>(numbers);
      Collections.reverse(reverseClues);
      answer = deduction.apply(answer, reverseClues);
      Collections.reverse(answer);
      return answer;
   }

   private static void setAllUnknowns(List<SquareState> existing, Answer answer, SquareState state) {
      setAllUnknowns(existing, answer, 0, existing.size(), state);
   }

   private static void setAllUnknowns(List<SquareState> existing, Answer answer, int begin, int end, SquareState state) {
      if (begin > end) {
         return;
      }
      for (int i = begin; i < end; i++) {
         if (existing.get(i).isUnknown()) {
            answer.set(i, state);
         }
      }
   }

   private static List<SquareState> createEmptyLine(int length) {
      List<SquareState> line = new ArrayList<>(length);
      for (int i = 0; i < length; i++) {
         line.add(i, SquareState.UNKNOW);
      }
      return line;
   }

   private static int getShortestClue(List<Integer> clues) {
      return clues.stream().min(Integer::compareTo).get();
   }
}

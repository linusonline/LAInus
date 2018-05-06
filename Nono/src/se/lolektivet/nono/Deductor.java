package se.lolektivet.nono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deductor {

   @FunctionalInterface
   public interface Deduction {
      List<SquareState> apply(List<SquareState> existing, List<Integer> clues);
   }

   private final Problem _problem;
   private final Solution _solution;

   private final List<List<Clue>> _rowClues = new ArrayList<>();
   private final List<List<Clue>> _columnClues = new ArrayList<>();

   private final List<Progress> _progressCounters = new ArrayList<>();

   public static class Progress {
      private int _progress = 0;

      int get() {
         return _progress;
      }

      void reset() {
         _progress = 0;
      }

      private void addProgress(int progress) {
         _progress += progress;
      }
   }

   private static class Streak {
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
   }

   private static class Clue {
      final int value;

      int earliestStart;
      int latestStart;
      int earliestEnd;
      int latestEnd;

      Clue(int value, int earliestStart, int latestStart) {
         this.value = value;
         this.earliestStart = earliestStart;
         this.latestStart = latestStart;
         this.earliestEnd = earliestStart + value;
         this.latestEnd = latestStart + value;
      }
   }

   private static class Answer {
      private final List<SquareState> _line;

      private Answer(List<SquareState> preExisting) {
         _line = new ArrayList<>(preExisting);
      }

      private void set(int index, SquareState state) {
         SquareState existing = _line.get(index);
         if (existing != SquareState.UNKNOW && existing != state) {
            throw new ContradictionException();
         }
         _line.set(index, state);
      }

      private List<SquareState> get() {
         return _line;
      }
   }

   public Deductor(Problem problem) {
      _problem = problem;
      _solution = new Solution(_problem.height(), _problem.width());
   }

   private void createClues() {
      for (List<Integer> row : _problem.rows) {
         _rowClues.add(createClues(row, _problem.height()));
      }
      for (List<Integer> column : _problem.columns) {
         _columnClues.add(createClues(column, _problem.width()));
      }
   }

   private static List<Clue> createClues(List<Integer> numberClues, int lineLength) {
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

   public Solution getSolution() {
      return _solution;
   }

   public Deductor startingDeduction() {
      int previouslyKnownSquares = _solution.getKnownSquares();

      applyDeductionToAllLines(Deductor::startingDeduction);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Deductor crossRestInCompleteRows() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::crossRestIfComplete);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Deductor fillInShortestClueFromEdges() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fillInShortestClueFromEdges);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Deductor crossShortGaps() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::crossShortGaps);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Deductor fillRestInCompletelyCrossedRows() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fillRestIfCompletelyCrossed);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Deductor fitCluesToGaps() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fitCluesToGaps);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   private Deductor applyDeductionToAllLines(Deduction deduction) {
      for (int row = 0; row < _problem.height(); row++) {
         if (!_solution.isRowDone(row)) {
            List<SquareState> answer = deduction.apply(_solution.getRow(row), _problem.rows.get(row));
            mergeLineToRow(answer, row);
         }
      }
      for (int column = 0; column < _problem.width(); column++) {
         if (!_solution.isColumnDone(column)) {
            List<SquareState> answer = deduction.apply(_solution.getColumn(column), _problem.columns.get(column));
            mergeLineToColumn(answer, column);
         }
      }
      return this;
   }

   public static List<SquareState> startingDeduction(List<SquareState> existing, List<Integer> clues) {
      int length = existing.size();
      int minimum = clues.stream().mapToInt(Integer::intValue).sum() + clues.size() - 1;
      int slack = length - minimum;
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

      long filledIn = existing.stream().filter(state -> state == SquareState.FILLED).count();
      long total = clues.stream().mapToInt(Integer::intValue).sum();
      if (total == filledIn) {
         setAllUnknowns(existing, answer, SquareState.STRIKE);
      }
      return answer.get();
   }

   public static List<SquareState> fillInShortestClueFromEdges(List<SquareState> existing, List<Integer> numbers) {
      return applyDeductionInBothDirections(Deductor::fillInShortestClueFromEdgesOnce, existing, numbers);
   }

   public static List<SquareState> fillInShortestClueFromEdgesOnce(List<SquareState> existing, List<Integer> clues) {
      Answer answer = new Answer(existing);
      final int shortest = getShortestClue(clues);
      int lastBlocked = -1;
      boolean isTracing = false;

      for (int i = 0; i < existing.size(); i++) {
         if (existing.get(i).equals(SquareState.STRIKE)) {
            lastBlocked = i;
            isTracing = false;
         } else if (isTracing) {
            if (i - lastBlocked <= shortest) {
               answer.set(i, SquareState.FILLED);
            }
         } else {
            if (existing.get(i).equals(SquareState.FILLED)) {
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
         if (i == existing.size() || existing.get(i).equals(SquareState.STRIKE)) {
            if (!skippingGap && unknownStreak > 0 && unknownStreak < shortest) {
               setAllUnknowns(existing, answer, i - unknownStreak, i, SquareState.STRIKE);
            }
            skippingGap = false;
            unknownStreak = 0;
         } else if (!skippingGap && i < existing.size()) {
            if (existing.get(i).equals(SquareState.UNKNOW)) {
               unknownStreak++;
            } else if (existing.get(i).equals(SquareState.FILLED)) {
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

   public static List<SquareState> fitCluesToGaps(List<SquareState> existing, List<Integer> numbers) {
      return applyDeductionInBothDirections(Deductor::fitCluesToGapsOnce, existing, numbers);
   }

   public static List<SquareState> fitCluesToGapsOnce(List<SquareState> existing, List<Integer> numbers) {
      List<Clue> clues = createClues(numbers, existing.size());

      int gapStart = 0;

      for (int clueNr = 0; clueNr < clues.size(); clueNr++) {
         int firstFit = findFirstFit(clues.get(clueNr).value, existing, gapStart);
         int offset = firstFit - gapStart;

         offsetCluesToRight(clues, clueNr, offset);

         if (clues.get(clueNr).earliestEnd < existing.size() && existing.get(clues.get(clueNr).earliestEnd).equals(SquareState.FILLED)) {
            offset++;
            offsetCluesToRight(clues, clueNr, 1);
         }

         gapStart += offset + clues.get(clueNr).value + 1;
      }

      return cluesToAnswer(clues, existing).get();
   }

   public static int findFirstFit(int clue, List<SquareState> existing, int start) {
      for (int i = start; i < start + clue; i++) {
         if (i >= existing.size()) {
            throw new ContradictionException();
         }
         if (existing.get(i).equals(SquareState.STRIKE)) {
            start = i + 1;
         }
      }
      return start;
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

   public void repeatDeductionOnRow(int row, Deduction deduction) {
      List<SquareState> answer = repeatDeduction(deduction, _solution.getRow(row), _problem.rows.get(row));
      mergeLineToRow(answer, row);
   }

   private static Answer cluesToAnswer(List<Clue> clues, List<SquareState> existing) {
      Answer answer = new Answer(existing);
      for (Clue clue : clues) {
         setAllUnknowns(existing, answer, clue.latestStart, clue.earliestEnd, SquareState.FILLED);
      }
      int crossStart = 0;
      for (Clue clue : clues) {
         setAllUnknowns(existing, answer, crossStart, clue.earliestStart, SquareState.STRIKE);
         crossStart = clue.latestEnd;
      }
      setAllUnknowns(existing, answer, crossStart, existing.size(), SquareState.STRIKE);
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

   private static void offsetCluesToRight(List<Clue> clues, int offset) {
      offsetCluesToRight(clues, 0, offset);
   }

   private static void offsetCluesToRight(List<Clue> clues, int firstClueFromLeft, int offset) {
      for (int i = firstClueFromLeft; i < clues.size(); i++) {
         clues.get(i).earliestStart += offset;
         clues.get(i).earliestEnd += offset;
      }
   }

   private static void setLatestStartForClue(Clue clue, int latestStart) {
      if (latestStart > clue.latestStart) {
         throw new ContradictionException();
      }
      clue.latestStart = latestStart;
      clue.latestEnd = latestStart + clue.value;
   }

   private static List<Streak> listStreaks(List<SquareState> line) {
      List<Streak> streaks = new ArrayList<>();

      boolean isInStreak = false;
      int streakStart = -1;
      int streakLength = 0;

      for (int i = 0; i < line.size(); i++) {
         SquareState state = line.get(i);
         if (state.equals(SquareState.FILLED)) {
            if (!isInStreak) {
               streakStart = i;
               isInStreak = true;
            }
            streakLength++;
         } else if (isInStreak) {
            streaks.add(new Streak(streakStart, streakLength));
            isInStreak = false;
         }
      }
      return streaks;
   }

   public Progress getProgressCounter() {
      Progress counter = new Progress();
      _progressCounters.add(counter);
      return counter;
   }

   private void addProgress(int progress) {
      for (Progress counter : _progressCounters) {
         counter.addProgress(progress);
      }
   }



   private static void setAllUnknowns(List<SquareState> existing, Answer answer, SquareState state) {
      setAllUnknowns(existing, answer, 0, existing.size(), state);
   }

   private static void setAllUnknowns(List<SquareState> existing, Answer answer, int begin, int end, SquareState state) {
      if (begin > end) {
         return;
      }
      for (int i = begin; i < end; i++) {
         if (existing.get(i).equals(SquareState.UNKNOW)) {
            answer.set(i, state);
         }
      }
   }

   private static int getShortestClue(List<Integer> clues) {
      return clues.stream().min(Integer::compareTo).get();
   }

   private static List<SquareState> createEmptyLine(int length) {
      List<SquareState> line = new ArrayList<>(length);
      for (int i = 0; i < length; i++) {
         line.add(i, SquareState.UNKNOW);
      }
      return line;
   }

   private void mergeLineToRow(List<SquareState> toMerge, int row) {
      for (int column = 0; column < toMerge.size(); column++) {
         _solution.setSquare(row, column, _solution.getSquare(row, column).add(toMerge.get(column)));
      }
   }

   private void mergeLineToColumn(List<SquareState> toMerge, int column) {
      for (int row = 0; row < toMerge.size(); row++) {
         _solution.setSquare(row, column, _solution.getSquare(row, column).add(toMerge.get(row)));
      }
   }
}

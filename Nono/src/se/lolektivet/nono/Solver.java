package se.lolektivet.nono;

import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.Problem;
import se.lolektivet.nono.model.Solution;
import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.List;

public class Solver {

   private final Problem _problem;
   private final Solution _solution;

   private final List<List<Clue>> _rowClues = new ArrayList<>();
   private final List<List<Clue>> _columnClues = new ArrayList<>();

   private final List<Progress> _progressCounters = new ArrayList<>();

   public Solution solve() {
      startingDeduction();
      Progress outerCounter = getProgressCounter();
      do {
         outerCounter.reset();
         Progress innerCounter = getProgressCounter();

         do {
            innerCounter.reset();

            crossRestInCompleteRows();
            crossShortGaps();
            fillRestInCompletelyCrossedRows();
            fillInShortestClueFromEdges();
         } while (innerCounter.get() > 0);

         fitCluesToGaps();
         fitToGapsAndStreaksRepeated();

      } while (outerCounter.get() > 0);

      return getSolution();
   }

   public Solution getFailed() {
      return getSolution();
   }

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

   public Solver(Problem problem) {
      _problem = problem;
      _solution = new Solution(_problem.height(), _problem.width());
   }

   private void createClues() {
      for (List<Integer> row : _problem.rows()) {
         _rowClues.add(ChainedDeductor.createClues(row, _problem.height()));
      }
      for (List<Integer> column : _problem.columns()) {
         _columnClues.add(ChainedDeductor.createClues(column, _problem.width()));
      }
   }

   public Solution getSolution() {
      return _solution;
   }

   public Solver startingDeduction() {
      int previouslyKnownSquares = _solution.getKnownSquares();

      applyDeductionToAllLines(Deductor::startingDeduction);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver crossRestInCompleteRows() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::crossRestIfComplete);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver fillInShortestClueFromEdges() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fillInShortestClueFromEdges);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver crossShortGaps() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::crossShortGaps);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver fillRestInCompletelyCrossedRows() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fillRestIfCompletelyCrossed);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver fitCluesToGaps() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(Deductor::fitCluesToGaps);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;
   }

   public Solver fitToGapsAndStreaksRepeated() {
      int previouslyKnownSquares = _solution.getKnownSquares();
      applyDeductionToAllLines(ChainedDeductor::fitToGapsAndStreaksRepeated);
      addProgress(_solution.getKnownSquares() - previouslyKnownSquares);
      return this;

   }

   private Solver applyDeductionToAllLines(Deduction deduction) {
      for (int row = 0; row < _problem.height(); row++) {
         if (!_solution.isRowDone(row)) {
            List<SquareState> answer = deduction.apply(_solution.getRow(row), _problem.row(row));
            mergeLineToRow(answer, row);
         }
      }
      for (int column = 0; column < _problem.width(); column++) {
         if (!_solution.isColumnDone(column)) {
            List<SquareState> answer = deduction.apply(_solution.getColumn(column), _problem.column(column));
            mergeLineToColumn(answer, column);
         }
      }
      return this;
   }

   public void repeatDeductionOnRow(int row, Deduction deduction) {
      List<SquareState> answer = Deductor.repeatDeduction(deduction, _solution.getRow(row), _problem.row(row));
      mergeLineToRow(answer, row);
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

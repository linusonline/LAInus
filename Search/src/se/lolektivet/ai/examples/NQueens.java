package se.lolektivet.ai.examples;

import org.jetbrains.annotations.NotNull;
import se.lolektivet.ai.search.ProblemRunner;
import se.lolektivet.ai.search.ProblemSequence;
import se.lolektivet.ai.search.StateSearchProblem;

import java.util.*;

public class NQueens implements StateSearchProblem {

   public static int MAX_PRINTABLE_PROBLEM_SIZE = 32;

   public static void main(String[] args) {
      ProblemRunner problemRunner = new ProblemRunner(new NQueensProblemSequence());
      problemRunner.runDepthFirst();
   }

   private final int problemSize;

   public NQueens(int problemSize) {
      this.problemSize = problemSize;
   }

   @NotNull
   @Override
   public StateSearchProblem.State getInitialState() {
      return new State();
   }

   @NotNull
   @Override
   public Map<Action, State> successorFunction(@NotNull StateSearchProblem.State state) {
      Map<Action, State> allSuccessors = new HashMap<>();
      State currentState = castOrDie(state);
      for (int colPos = 0; colPos < problemSize; colPos++) {
         if (!currentState.positionsInColumn.contains(colPos) &&
               !conflictsDiagonally(currentState, colPos)) {
            Action action = new Action(colPos);
            allSuccessors.put(action, new State(currentState, action));
         }
      }
      return allSuccessors;
   }

   boolean conflictsDiagonally(State state, int newColPos) {
      for (int testColumn = state.positionsInColumn.size() - 1; testColumn >= 0; testColumn--) {
         int testQueenPos = state.positionsInColumn.get(testColumn);
         if (Math.abs(newColPos - testQueenPos) == state.positionsInColumn.size() - testColumn) {
            return true;
         }
      }
      return false;
   }

   @Override
   public boolean isGoal(@NotNull StateSearchProblem.State state) {
      State myState = castOrDie(state);
      if (myState.positionsInColumn.size() < problemSize) {
         return false;
      }
      for (int colNr = 0; colNr < problemSize; colNr++) {
         for (int testColumn = colNr + 1; testColumn < problemSize; testColumn++) {
            int thisQueenPos = myState.positionsInColumn.get(colNr);
            int testQueenPos = myState.positionsInColumn.get(testColumn);
            if (thisQueenPos == testQueenPos) {
               return false;
            }
            if (Math.abs(thisQueenPos - testQueenPos) == testColumn - colNr) {
               return false;
            }
         }
      }
      return true;
   }

   @NotNull
   @Override
   public StateSearchProblem.Cost getZeroCost() {
      return new IntegerCost(0);
   }

   @NotNull
   @Override
   public StateSearchProblem.Cost getStepCost(StateSearchProblem.State fromState, StateSearchProblem.Action action, StateSearchProblem.State toState) {
      return new IntegerCost(1);
   }

   @NotNull
   protected NQueens.State castOrDie(@NotNull StateSearchProblem.State state) {
      return (NQueens.State) state;
   }

   public void printSolution(Solution solution) {
      if (solution.actionSequence.size() != problemSize) {
         throw new RuntimeException();
      }
      if (problemSize > MAX_PRINTABLE_PROBLEM_SIZE) {
         System.out.println("Solution too large to print.");
         return;
      }
      StringBuilder stringBuilder = new StringBuilder();
      for (int column = 0; column < solution.actionSequence.size(); column++) {
         for (int row = 0; row < solution.actionSequence.size(); row++) {
            if (row == ((Action)solution.actionSequence.get(column)).colPos) {
               stringBuilder.append("X");
            } else {
               stringBuilder.append(".");
            }
         }
         stringBuilder.append("\n");
      }
      System.out.println(stringBuilder);
   }

   public static class State implements StateSearchProblem.State {
      @NotNull
      protected final List<Integer> positionsInColumn;

      public State() {
         positionsInColumn = Collections.unmodifiableList(new ArrayList<>());
      }

      public State(State previous, Action action) {
         List<Integer> newPos = new ArrayList<>(previous.positionsInColumn);
         newPos.add(action.colPos);
         this.positionsInColumn = Collections.unmodifiableList(newPos);
      }
   }

   public static class Action implements StateSearchProblem.Action {
      private final int colPos;

      public Action(int colPos) {
         this.colPos = colPos;
      }
   }

   public static class NQueensProblemSequence implements ProblemSequence {

      private int problemSize = 4;

      @Override
      public StateSearchProblem next() {
         NQueens problem = new NQueens(problemSize);
         problemSize += 2;
         return problem;
      }
   }
}

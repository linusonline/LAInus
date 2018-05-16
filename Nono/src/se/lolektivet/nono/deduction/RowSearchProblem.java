package se.lolektivet.nono.deduction;

import se.lolektivet.ai.examples.IntegerCost;
import se.lolektivet.ai.search.StateSearchProblem;
import se.lolektivet.nono.Util;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.*;

public class RowSearchProblem implements StateSearchProblem {

   private final List<SquareState> startingState;
   private final List<Clue> startingClues;

   RowSearchProblem(List<SquareState> startingState, List<Clue> startingClues) {
      this.startingState = Collections.unmodifiableList(startingState);
      this.startingClues = Collections.unmodifiableList(Util.copyClues(startingClues));
   }

   @Override
   public State getInitialState() {
      return new RowState(startingState, startingClues);
   }

   @Override
   public Map<? extends Action, ? extends State> successorFunction(State state) {
      RowState myState = (RowState)state;
      Optional<Clue> nextUnfixedClue = myState.clues.stream()
            .filter((clue) -> !clue.isFixed())
            .findFirst();
      Map<RowAction, RowState> successors = new HashMap<>();
      if (nextUnfixedClue.isPresent()) {
         for (int possibleStart = nextUnfixedClue.get().earliestStart; possibleStart <= nextUnfixedClue.get().latestStart; possibleStart++) {
            RowAction action = new RowAction(possibleStart, myState.clues.indexOf(nextUnfixedClue.get()));
            try {
               successors.put(action, new RowState(myState, action));
            } catch (ContradictionException ignoreIllegalState) {/* Ignore */}
         }
      }

      return successors;
   }

   @Override
   public boolean isGoal(State state) {
      return ((RowState)state).clues.stream().allMatch(Clue::isFixed);
   }

   @Override
   public StateSearchProblem.Cost getZeroCost() {
      return new IntegerCost(0);
   }

   @Override
   public StateSearchProblem.Cost getStepCost(StateSearchProblem.State fromState, StateSearchProblem.Action action, StateSearchProblem.State toState) {
      return new IntegerCost(1);
   }

   @Override
   public void printSolution(Solution solution) {

   }

   static List<SquareState> solutionToLine(List<SquareState> line, List<Clue> clues, Solution solution) {
      List<Clue> newClues = Util.copyClues(clues);
      for (Action action : solution.actionSequence) {
         RowAction rowAction = ((RowAction)action);
         Clue clue = newClues.get(rowAction.indexOfNextClue);
         clue.setEarliestStart(rowAction.positionOfNextClue);
         clue.setLatestStart(rowAction.positionOfNextClue);
      }
      return Util.cluesToAnswer(newClues, line).get();
   }

   class RowState implements StateSearchProblem.State {
      private final List<SquareState> line;
      private final List<Clue> clues;

      RowState(List<SquareState> line, List<Clue> clues) {
         this.line = Collections.unmodifiableList(line);
         this.clues = Collections.unmodifiableList(clues);
      }

      RowState(RowState previousState, RowAction action) {
         this.clues = Util.copyClues(previousState.clues);

         Clue nextClue = this.clues.get(action.indexOfNextClue);
         int push = action.positionOfNextClue - nextClue.earliestStart;
         Util.pushClueToRight(this.clues, action.indexOfNextClue, push, previousState.line.size());
         nextClue.setLatestStart(action.positionOfNextClue);

         Deductions.Answer answer = Util.cluesToAnswer(this.clues, previousState.line);
         this.line = answer.get();
      }
   }

   class RowAction implements StateSearchProblem.Action {
      private final int positionOfNextClue;
      private final int indexOfNextClue;

      RowAction(int positionOfNextClue, int indexOfNextClue) {
         this.positionOfNextClue = positionOfNextClue;
         this.indexOfNextClue = indexOfNextClue;
      }
   }
}

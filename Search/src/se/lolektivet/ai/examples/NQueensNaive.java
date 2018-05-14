package se.lolektivet.ai.examples;

import org.jetbrains.annotations.NotNull;
import se.lolektivet.ai.search.StateSearchProblem;

import java.util.HashMap;
import java.util.Map;

public class NQueensNaive extends NQueens {
   private final int problemSize;

   public NQueensNaive(int problemSize) {
      super(problemSize);
      this.problemSize = problemSize;
   }

   @NotNull
   @Override
   public Map<Action, State> successorFunction(@NotNull StateSearchProblem.State state) {
      Map<Action, State> allSuccessors = new HashMap<>();
      State currentState = castOrDie(state);
      for (int colPos = 0; colPos < problemSize; colPos++) {
         if (!currentState.positionsInColumn.contains(colPos)) {
            Action action = new Action(colPos);
            allSuccessors.put(action, new State(currentState, action));
         }
      }
      return allSuccessors;
   }
}

package se.lolektivet.ai.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface StateSearchProblem {
   interface State {}
   interface Action {}
   interface Cost {
      int compareTo(Cost other);
      Cost add(Cost other);
   }

   class Solution {
      @NotNull
      public final List<Action> actionSequence;
      public final boolean isFailure;

      public Solution() {
         this.actionSequence = new ArrayList<>(0);
         this.isFailure = true;
      }

      public Solution(@NotNull List<Action> actionSequence) {
         this.actionSequence = Collections.unmodifiableList(actionSequence);
         this.isFailure = false;
      }
   }

   State getInitialState();

   Map<? extends Action, ? extends State> successorFunction(State state);

   boolean isGoal(State state);

   Cost getZeroCost();

   Cost getStepCost(State fromState, Action action, State toState);

   void printSolution(Solution solution);
}

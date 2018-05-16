package se.lolektivet.ai.examples;

import org.jetbrains.annotations.NotNull;
import se.lolektivet.ai.search.StateSearchProblem;

public class IntegerCost implements StateSearchProblem.Cost {

   private final int total;

   public IntegerCost(int total) {
      this.total = total;
   }

   @Override
   public int compareTo(@NotNull StateSearchProblem.Cost other) {
      return Integer.compare(total, castOrDie(other).total);
   }

   @NotNull
   @Override
   public StateSearchProblem.Cost add(@NotNull StateSearchProblem.Cost other) {
      return new IntegerCost(total + castOrDie(other).total);
   }

   @NotNull
   private IntegerCost castOrDie(@NotNull StateSearchProblem.Cost cost) {
      return (IntegerCost) cost;
   }
}

package se.lolektivet.nono;

import se.lolektivet.nono.model.SquareState;

import java.util.List;

@FunctionalInterface
public interface Deduction {

   /**
    * Applies a deduction algorithm to a line problem.
    *
    * @param existing A partially solved line. Contents will not be modified.
    * @param clues The clues for the line.
    *
    * @return A partially solved line with the deduction applied.
    */
   List<SquareState> apply(List<SquareState> existing, List<Integer> clues);
}

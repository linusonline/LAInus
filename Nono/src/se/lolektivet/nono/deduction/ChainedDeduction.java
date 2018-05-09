package se.lolektivet.nono.deduction;

import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.List;

@FunctionalInterface
public interface ChainedDeduction {

   /**
    * Applies a deduction algorithm to an in-progress line problem
    *
    * @param existing A partially solved line. Contents will not be modified.
    * @param clues    The clues for the line, including previously deduced constraints. Contents will be updated to
    *                 reflect the results of the algorithm.
    *
    * @return The clues parameter.
    */
   List<Clue> apply(List<SquareState> existing, List<Clue> clues);
}

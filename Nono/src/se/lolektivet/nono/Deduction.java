package se.lolektivet.nono;

import java.util.List;

@FunctionalInterface
public interface Deduction {
   List<SquareState> apply(List<SquareState> existing, List<Integer> clues);
}

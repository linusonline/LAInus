package se.lolektivet.nono.cases;

import se.lolektivet.nono.model.SquareState;

import java.util.List;

public class TestCase {
   public final List<Integer> clues;
   public final List<SquareState> problem;
   public final List<SquareState> solution;

   public TestCase(List<Integer> clues, List<SquareState> problem, List<SquareState> solution) {
      this.clues = clues;
      this.problem = problem;
      this.solution = solution;
   }
}

package se.lolektivet.nono.solvers;

import org.junit.Test;
import se.lolektivet.nono.Solver;
import se.lolektivet.nono.cases.Puzzles;
import se.lolektivet.nono.model.Solution;

import static org.junit.Assert.assertEquals;

public class TestSolver {

   @Test
   public void testProblem0() {
      testSolver(0);
   }

   @Test
   public void testProblem1() {
      testSolver(1);
   }

   @Test
   public void testProblem2() {
      testSolver(2);
   }

   @Test
   public void testProblem3() {
      testSolver(3);
   }

   @Test
   public void testProblem4() {
      testSolver(4);
   }

   @Test
   public void testProblem5() {
      testSolver(5, true);
   }

   @Test
   public void testProblem6() {
      testSolver(6, true);
   }

   @Test
   public void testProblem7() {
      testSolver(7, true);
   }

   @Test
   public void testProblem8() {
      testSolver(8, true);
   }

   @Test
   public void testProblem9() {
      testSolver(9, true);
   }

   @Test
   public void testProblem10() {
      testSolver(10, true);
   }

   @Test
   public void testProblem11() {
      testSolver(11, true);
   }

   @Test
   public void testProblem12() {
      testSolver(12, true);
   }



   private void testSolver(int problem) {
      testSolver(problem, false);
   }

   private void testSolver(int problem, boolean print) {
      Puzzles puzzles = new Puzzles();
      Solution actual = new Solver(puzzles.problem(problem)).solve();
      if (print) {
         System.out.println(actual);
      }
      assertEquals(puzzles.solution(problem), actual);
   }
}

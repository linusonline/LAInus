package se.lolektivet.nono;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.lolektivet.nono.SquareState.FILLED;
import static se.lolektivet.nono.SquareState.STRIKE;

public class TestSolver {
   private final Problem problem1 = new ProblemFactory().create(5, 5)
         .addColumnFromLeft(1, 1)
         .addColumnFromLeft(3)
         .addColumnFromLeft(3, 1)
         .addColumnFromLeft(1, 1)
         .addColumnFromLeft(2)

         .addRowFromTop(4)
         .addRowFromTop(2)
         .addRowFromTop(2)
         .addRowFromTop(1)
         .addRowFromTop(1, 3)

         .finish();

   private final Solution solution1 = new Solution(5, 5)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, STRIKE)
         .setRow(1, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(2, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(3, STRIKE, STRIKE, STRIKE, STRIKE, FILLED)
         .setRow(4, FILLED, STRIKE, FILLED, FILLED, FILLED);

   private final Problem problem2 = new ProblemFactory().create(5, 5)
         .addColumnFromLeft(3)
         .addColumnFromLeft(3)
         .addColumnFromLeft(3)
         .addColumnFromLeft(2)
         .addColumnFromLeft(1, 1)

         .addRowFromTop(1)
         .addRowFromTop(3)
         .addRowFromTop(3)
         .addRowFromTop(3, 1)
         .addRowFromTop(2)

         .finish();

   private final Solution solution2 = new Solution(5, 5)
         .setRow(0, STRIKE, STRIKE, STRIKE, FILLED, STRIKE)
         .setRow(1, STRIKE, STRIKE, FILLED, FILLED, FILLED)
         .setRow(2, FILLED, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(3, FILLED, FILLED, FILLED, STRIKE, FILLED)
         .setRow(4, FILLED, FILLED, STRIKE, STRIKE, STRIKE);

   private final Problem problem3 = new ProblemFactory().create(5, 5)
         .addColumnFromLeft(3)
         .addColumnFromLeft(2)
         .addColumnFromLeft(1, 1, 1)
         .addColumnFromLeft(3)
         .addColumnFromLeft(2)

         .addRowFromTop(2)
         .addRowFromTop(2)
         .addRowFromTop(1, 3)
         .addRowFromTop(2)
         .addRowFromTop(3)

         .finish();

   private final Solution solution3 = new Solution(5, 5)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, STRIKE)
         .setRow(1, STRIKE, STRIKE, STRIKE, FILLED, FILLED)
         .setRow(2, FILLED, STRIKE, FILLED, FILLED, FILLED)
         .setRow(3, FILLED, FILLED, STRIKE, STRIKE, STRIKE)
         .setRow(4, FILLED, FILLED, FILLED, STRIKE, STRIKE);

   // 10x10 Nonograms Puzzle ID: 4,258,481
   private final Problem problem4 = new ProblemFactory().create(10, 10)
         .addColumnFromLeft(2, 2, 1)
         .addColumnFromLeft(1, 1)
         .addColumnFromLeft(2, 2)
         .addColumnFromLeft(3, 3)
         .addColumnFromLeft(3, 3)
         .addColumnFromLeft(2, 3)
         .addColumnFromLeft(3, 1)
         .addColumnFromLeft(5, 2)
         .addColumnFromLeft(6)
         .addColumnFromLeft(5)

         .addRowFromTop(5)
         .addRowFromTop(1, 4, 3)
         .addRowFromTop(7)
         .addRowFromTop(4)
         .addRowFromTop(2, 4)
         .addRowFromTop(1, 3)
         .addRowFromTop(1)
         .addRowFromTop(3)
         .addRowFromTop(4, 1)
         .addRowFromTop(1, 6)

         .finish();

   private final Solution solution4 = new Solution(10, 10)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(1, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED)
         .setRow(2, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(3, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED)
         .setRow(4, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED)
         .setRow(5, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED)
         .setRow(6, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE)
         .setRow(7, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(8, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, STRIKE, STRIKE)
         .setRow(9, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE);

   // 15x15 Nonograms Puzzle ID: 7,978,914
   private final Problem problem5 = new ProblemFactory().create(15, 15)
         .addColumnFromLeft(1, 4, 1, 1)
         .addColumnFromLeft(4, 1)
         .addColumnFromLeft(1, 5, 1, 1)
         .addColumnFromLeft(1, 3, 5)
         .addColumnFromLeft(1, 10)
         .addColumnFromLeft(3, 3, 4, 1)
         .addColumnFromLeft(1, 11)
         .addColumnFromLeft(2, 4, 3)
         .addColumnFromLeft(2, 2, 3)
         .addColumnFromLeft(3, 3)
         .addColumnFromLeft(3, 2, 2)
         .addColumnFromLeft(7)
         .addColumnFromLeft(3, 4, 1)
         .addColumnFromLeft(3)
         .addColumnFromLeft(3)

         .addRowFromTop(1, 10)
         .addRowFromTop(1, 1, 8)
         .addRowFromTop(5, 6)
         .addRowFromTop(3, 1)
         .addRowFromTop(4, 2, 3)
         .addRowFromTop(8, 3)
         .addRowFromTop(1, 7, 2)
         .addRowFromTop(1, 3, 1)
         .addRowFromTop(1, 4)
         .addRowFromTop(3)
         .addRowFromTop(4)
         .addRowFromTop(4)
         .addRowFromTop(5, 4)
         .addRowFromTop(8)
         .addRowFromTop(3, 5, 1)

         .finish();

   private final Solution solution5 = new Solution(15, 15)
         .setRow(0, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(1, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(2, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(3, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE)
         .setRow(4, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(5, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(6, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(7, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE)
         .setRow(8, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(9, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(10, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(11, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(12, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(13, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(14, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, STRIKE, STRIKE);

   private final Problem problem6 = new ProblemFactory().create(20, 30)
         .addColumnFromLeft(10)
         .addColumnFromLeft(10)
         .addColumnFromLeft(19)
         .addColumnFromLeft(19)
         .addColumnFromLeft(20)
         .addColumnFromLeft(16)
         .addColumnFromLeft(19)
         .addColumnFromLeft(20)
         .addColumnFromLeft(13,4)
         .addColumnFromLeft(13,2)
         .addColumnFromLeft(13)
         .addColumnFromLeft(13,1)
         .addColumnFromLeft(14,3)
         .addColumnFromLeft(19)
         .addColumnFromLeft(18)
         .addColumnFromLeft(17)
         .addColumnFromLeft(13)
         .addColumnFromLeft(17)
         .addColumnFromLeft(17)
         .addColumnFromLeft(16)
         .addColumnFromLeft(2,10,2)
         .addColumnFromLeft(13)
         .addColumnFromLeft(1,10)
         .addColumnFromLeft(2,7)
         .addColumnFromLeft(1,1,4)
         .addColumnFromLeft(2,5)
         .addColumnFromLeft(12)
         .addColumnFromLeft(10)
         .addColumnFromLeft(3,1)
         .addColumnFromLeft(2)

         .addRowFromTop(4,4,1)
         .addRowFromTop(15,1,1)
         .addRowFromTop(17,2,1)
         .addRowFromTop(18,1,2,1)
         .addRowFromTop(24,1)
         .addRowFromTop(22,2)
         .addRowFromTop(23,2)
         .addRowFromTop(23,2)
         .addRowFromTop(24,2)
         .addRowFromTop(28)
         .addRowFromTop(24,4)
         .addRowFromTop(30)
         .addRowFromTop(1,28)
         .addRowFromTop(1,26)
         .addRowFromTop(6,3,3,4,2)
         .addRowFromTop(6,4,3,1)
         .addRowFromTop(3,3,5,3)
         .addRowFromTop(3,3,3,3)
         .addRowFromTop(3,4,1,4)
         .addRowFromTop(3,3,3)

         .finish();

   private final Solution solution6 = new Solution(20, 30)
         .setRow(0, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, STRIKE, FILLED, FILLED, STRIKE, FILLED, STRIKE, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE)
         .setRow(0, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(0, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED)
         .setRow(0, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, FILLED, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE)
         .setRow(0, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, FILLED, FILLED, FILLED, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE, STRIKE);


           @Test
   public void testProblem1() {
      Solution actual = new Solver(problem1).solve();
      assertEquals(solution1, actual);
   }

   @Test
   public void testProblem2() {
      Solution actual = new Solver(problem2).solve();
      assertEquals(solution2, actual);
   }

   @Test
   public void testProblem3() {
      Solution actual = new Solver(problem3).solve();
      assertEquals(solution3, actual);
   }

   @Test
   public void testProblem4() {
      Solver solver = new Solver(problem4);
      Solution actual = solver.solve();
      assertEquals(solution4, actual);
   }

   @Test
   public void testProblem5() {
      Solver solver = new Solver(problem5);
      Solution actual = solver.solve();
      assertEquals(solution5, actual);
   }

   @Test
   public void testProblem6() {
      Solver solver = new Solver(problem6);
      Solution actual = solver.solve();
      System.out.println(actual);
      assertEquals(solution6, actual);
   }
}

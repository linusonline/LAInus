package se.lolektivet.nono.unittests;

import org.junit.Test;
import se.lolektivet.nono.Solver;
import se.lolektivet.nono.model.Problem;
import se.lolektivet.nono.model.ProblemFactory;
import se.lolektivet.nono.model.Solution;
import se.lolektivet.nono.model.SquareState;

import static org.junit.Assert.assertEquals;

public class TestDeductorSolutions {

   private final Problem problem = new ProblemFactory().create(5, 5)
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

   private final Solution solutionTrivial = new Solution(5, 5)
         .setRow(0, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED, SquareState.UNKNOW)
         .setRow(1, SquareState.UNKNOW, SquareState.UNKNOW, SquareState.FILLED, SquareState.UNKNOW, SquareState.UNKNOW)
         .setRow(2, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.UNKNOW, SquareState.UNKNOW)
         .setRow(3, SquareState.UNKNOW, SquareState.UNKNOW, SquareState.STRIKE, SquareState.UNKNOW, SquareState.UNKNOW)
         .setRow(4, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED);

   private final Solution solutionCrossDone = new Solution(5, 5)
         .setRow(0, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED, SquareState.UNKNOW)
         .setRow(1, SquareState.UNKNOW, SquareState.UNKNOW, SquareState.FILLED, SquareState.STRIKE, SquareState.UNKNOW)
         .setRow(2, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE, SquareState.STRIKE)
         .setRow(3, SquareState.UNKNOW, SquareState.UNKNOW, SquareState.STRIKE, SquareState.STRIKE, SquareState.UNKNOW)
         .setRow(4, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED);

   private final Solution solutionFillInShortest = new Solution(5, 5)
         .setRow(0, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED, SquareState.UNKNOW)
         .setRow(1, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE, SquareState.UNKNOW)
         .setRow(2, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE, SquareState.STRIKE)
         .setRow(3, SquareState.UNKNOW, SquareState.UNKNOW, SquareState.STRIKE, SquareState.STRIKE, SquareState.FILLED)
         .setRow(4, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED);

   private final Solution solutionCrossShortCross = new Solution(5, 5)
         .setRow(0, SquareState.UNKNOW, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE)
         .setRow(1, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE, SquareState.STRIKE)
         .setRow(2, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.STRIKE, SquareState.STRIKE)
         .setRow(3, SquareState.STRIKE, SquareState.STRIKE, SquareState.STRIKE, SquareState.STRIKE, SquareState.FILLED)
         .setRow(4, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED, SquareState.FILLED, SquareState.FILLED);

   @Test
   public void testTrivialSolution() {
      assertEquals(new Solution(1, 1), new Solution(1, 1));
   }

   @Test
   public void testTrivialSolution2() {
      Solution actual = new Solver(problem).startingDeduction().getSolution();
      assertEquals(solutionTrivial.getRow(0), actual.getRow(0));
      assertEquals(solutionTrivial.getRow(1), actual.getRow(1));
      assertEquals(solutionTrivial.getRow(2), actual.getRow(2));
      assertEquals(solutionTrivial.getRow(3), actual.getRow(3));
      assertEquals(solutionTrivial.getRow(4), actual.getRow(4));
   }

   @Test
   public void testCrossDoneRows() {
      Solution actual = new Solver(problem).startingDeduction().crossRestInCompleteRows().getSolution();

      assertEquals(solutionCrossDone.getRow(0), actual.getRow(0));
      assertEquals(solutionCrossDone.getRow(1), actual.getRow(1));
      assertEquals(solutionCrossDone.getRow(2), actual.getRow(2));
      assertEquals(solutionCrossDone.getRow(3), actual.getRow(3));
      assertEquals(solutionCrossDone.getRow(4), actual.getRow(4));
   }

   @Test
   public void testFillInShortest() {
      Solution actual = new Solver(problem).startingDeduction().crossRestInCompleteRows().fillInShortestClueFromEdges().getSolution();

      assertEquals(solutionFillInShortest.getRow(0), actual.getRow(0));
      assertEquals(solutionFillInShortest.getRow(1), actual.getRow(1));
      assertEquals(solutionFillInShortest.getRow(2), actual.getRow(2));
      assertEquals(solutionFillInShortest.getRow(3), actual.getRow(3));
      assertEquals(solutionFillInShortest.getRow(4), actual.getRow(4));
   }

   @Test
   public void testCrossShortCross() {
      Solution actual = new Solver(problem)
            .startingDeduction()
            .crossRestInCompleteRows()
            .fillInShortestClueFromEdges()
            .crossRestInCompleteRows().getSolution();

      assertEquals(solutionCrossShortCross.getRow(0), actual.getRow(0));
      assertEquals(solutionCrossShortCross.getRow(1), actual.getRow(1));
      assertEquals(solutionCrossShortCross.getRow(2), actual.getRow(2));
      assertEquals(solutionCrossShortCross.getRow(3), actual.getRow(3));
      assertEquals(solutionCrossShortCross.getRow(4), actual.getRow(4));
   }
}

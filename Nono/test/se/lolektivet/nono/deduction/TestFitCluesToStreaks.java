package se.lolektivet.nono.deduction;

import org.junit.Test;
import se.lolektivet.nono.ChainedDeductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestFitCluesToStreaks {

   @Test
   public void testTrivialElimination0() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testFitCluesToStreaks(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testFitCluesToStreaks(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testFitCluesToStreaks(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testFitCluesToStreaks(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testFitCluesToStreaks(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testFitCluesToStreaks(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testFitCluesToStreaks(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testFitCluesToStreaks(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testFitCluesToStreaks(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testFitCluesToStreaks(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testFitCluesToStreaks(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testFitCluesToStreaks(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testFitCluesToStreaks(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testFitCluesToStreaks(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testFitCluesToStreaks(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testFitCluesToStreaks(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testFitCluesToStreaks(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testFitCluesToStreaks(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testFitCluesToStreaks(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testFitCluesToStreaks(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testFitCluesToStreaks(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testFitCluesToStreaks(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testFitCluesToStreaks(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testFitCluesToStreaks(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testFitCluesToStreaks(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testFitCluesToStreaks(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testFitCluesToStreaks(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testFitCluesToStreaks(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testFitCluesToStreaks(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testFitCluesToStreaks(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testFitCluesToStreaks(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testFitCluesToStreaks(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testFitCluesToStreaks(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testFitCluesToStreaks(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testFitCluesToStreaks(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testFitCluesToStreaks(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testFitCluesToStreaks(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testFitCluesToStreaks(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testFitCluesToStreaks(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testFitCluesToStreaks(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testFitCluesToStreaks(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testFitCluesToStreaks(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testFitCluesToStreaks(Cases.MISC, 6);
   }




   @Test
   public void testHardProblem0() {
      testFitCluesToStreaks(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testFitCluesToStreaks(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testFitCluesToStreaks(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testFitCluesToStreaks(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testFitCluesToStreaks(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testFitCluesToStreaks(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testFitCluesToStreaks(Cases.HARD, 6);
   }

   private void testFitCluesToStreaks(String testType, int testCase) {
      TestUtils.testChainedDeduction(ChainedDeductor::fitCluesToStreaks, testType, testCase);
   }
}

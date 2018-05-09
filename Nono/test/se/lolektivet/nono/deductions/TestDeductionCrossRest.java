package se.lolektivet.nono.deductions;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionCrossRest {
   @Test
   public void testTrivialElimination0() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testCrossRestIfComplete(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testCrossRestIfComplete(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testCrossRestIfComplete(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testCrossRestIfComplete(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testCrossRestIfComplete(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testCrossRestIfComplete(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testCrossRestIfComplete(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testCrossRestIfComplete(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testCrossRestIfComplete(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testCrossRestIfComplete(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testCrossRestIfComplete(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testCrossRestIfComplete(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testCrossRestIfComplete(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testCrossRestIfComplete(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testCrossRestIfComplete(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testCrossRestIfComplete(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testCrossRestIfComplete(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testCrossRestIfComplete(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testCrossRestIfComplete(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testCrossRestIfComplete(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testCrossRestIfComplete(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testCrossRestIfComplete(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testCrossRestIfComplete(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testCrossRestIfComplete(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testCrossRestIfComplete(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testCrossRestIfComplete(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testCrossRestIfComplete(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testCrossRestIfComplete(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testCrossRestIfComplete(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testCrossRestIfComplete(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testCrossRestIfComplete(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testCrossRestIfComplete(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testCrossRestIfComplete(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testCrossRestIfComplete(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testCrossRestIfComplete(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testCrossRestIfComplete(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testCrossRestIfComplete(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testCrossRestIfComplete(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testCrossRestIfComplete(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testCrossRestIfComplete(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testCrossRestIfComplete(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testCrossRestIfComplete(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testCrossRestIfComplete(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testCrossRestIfComplete(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testCrossRestIfComplete(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testCrossRestIfComplete(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testCrossRestIfComplete(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testCrossRestIfComplete(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testCrossRestIfComplete(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testCrossRestIfComplete(Cases.HARD, 6);
   }

   private void testCrossRestIfComplete(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::crossRestIfComplete, testType, testCase);
   }
}

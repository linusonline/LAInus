package se.lolektivet.nono.deductions;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionFillRest {
   @Test
   public void testTrivialElimination0() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testFillRestIfComplete(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testFillRestIfComplete(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testFillRestIfComplete(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testFillRestIfComplete(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testFillRestIfComplete(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testFillRestIfComplete(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testFillRestIfComplete(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testFillRestIfComplete(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testFillRestIfComplete(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testFillRestIfComplete(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testFillRestIfComplete(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testFillRestIfComplete(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testFillRestIfComplete(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testFillRestIfComplete(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testFillRestIfComplete(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testFillRestIfComplete(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testFillRestIfComplete(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testFillRestIfComplete(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testFillRestIfComplete(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testFillRestIfComplete(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testFillRestIfComplete(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testFillRestIfComplete(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testFillRestIfComplete(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testFillRestIfComplete(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testFillRestIfComplete(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testFillRestIfComplete(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testFillRestIfComplete(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testFillRestIfComplete(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testFillRestIfComplete(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testFillRestIfComplete(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testFillRestIfComplete(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testFillRestIfComplete(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testFillRestIfComplete(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testFillRestIfComplete(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testFillRestIfComplete(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testFillRestIfComplete(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testFillRestIfComplete(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testFillRestIfComplete(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testFillRestIfComplete(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testFillRestIfComplete(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testFillRestIfComplete(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testFillRestIfComplete(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testFillRestIfComplete(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testFillRestIfComplete(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testFillRestIfComplete(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testFillRestIfComplete(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testFillRestIfComplete(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testFillRestIfComplete(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testFillRestIfComplete(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testFillRestIfComplete(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testFillRestIfComplete(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testFillRestIfComplete(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testFillRestIfComplete(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testFillRestIfComplete(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testFillRestIfComplete(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testFillRestIfComplete(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testFillRestIfComplete(Cases.HARD, 6);
   }

   private void testFillRestIfComplete(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::fillRestIfCompletelyCrossed, testType, testCase);
   }
}

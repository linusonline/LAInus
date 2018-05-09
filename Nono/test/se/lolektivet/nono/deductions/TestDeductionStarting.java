package se.lolektivet.nono.deductions;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionStarting {

   @Test
   public void testTrivialElimination0() {
      testStartingDeduction(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testStartingDeduction(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testStartingDeduction(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testStartingDeduction(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testStartingDeduction(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testStartingDeduction(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testStartingDeduction(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testStartingDeduction(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testStartingDeduction(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testStartingDeduction(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testStartingDeduction(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testStartingDeduction(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testStartingDeduction(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testStartingDeduction(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testStartingDeduction(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testStartingDeduction(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testStartingDeduction(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testStartingDeduction(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testStartingDeduction(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testStartingDeduction(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testStartingDeduction(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testStartingDeduction(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testStartingDeduction(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testStartingDeduction(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testStartingDeduction(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testStartingDeduction(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testStartingDeduction(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testStartingDeduction(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testStartingDeduction(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testStartingDeduction(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testStartingDeduction(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testStartingDeduction(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testStartingDeduction(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testStartingDeduction(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testStartingDeduction(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testStartingDeduction(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testStartingDeduction(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testStartingDeduction(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testStartingDeduction(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testStartingDeduction(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testStartingDeduction(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testStartingDeduction(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testStartingDeduction(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testStartingDeduction(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testStartingDeduction(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testStartingDeduction(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testStartingDeduction(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testStartingDeduction(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testStartingDeduction(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testStartingDeduction(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testStartingDeduction(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testStartingDeduction(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testStartingDeduction(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testStartingDeduction(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testStartingDeduction(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testStartingDeduction(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testStartingDeduction(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testStartingDeduction(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testStartingDeduction(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testStartingDeduction(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testStartingDeduction(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testStartingDeduction(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testStartingDeduction(Cases.HARD, 6);
   }

   private void testStartingDeduction(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::startingDeduction, testType, testCase);
   }
}

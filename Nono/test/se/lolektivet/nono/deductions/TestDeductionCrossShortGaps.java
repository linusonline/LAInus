package se.lolektivet.nono.deductions;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionCrossShortGaps {
   @Test
   public void testTrivialElimination0() {
      testCrossShortGaps(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testCrossShortGaps(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testCrossShortGaps(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testCrossShortGaps(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testCrossShortGaps(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testCrossShortGaps(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testCrossShortGaps(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testCrossShortGaps(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testCrossShortGaps(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testCrossShortGaps(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testCrossShortGaps(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testCrossShortGaps(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testCrossShortGaps(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testCrossShortGaps(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testCrossShortGaps(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testCrossShortGaps(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testCrossShortGaps(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testCrossShortGaps(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testCrossShortGaps(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testCrossShortGaps(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testCrossShortGaps(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testCrossShortGaps(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testCrossShortGaps(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testCrossShortGaps(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testCrossShortGaps(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testCrossShortGaps(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testCrossShortGaps(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testCrossShortGaps(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testCrossShortGaps(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testCrossShortGaps(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testCrossShortGaps(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testCrossShortGaps(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testCrossShortGaps(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testCrossShortGaps(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testCrossShortGaps(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testCrossShortGaps(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testCrossShortGaps(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testCrossShortGaps(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testCrossShortGaps(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testCrossShortGaps(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testCrossShortGaps(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testCrossShortGaps(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testCrossShortGaps(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testCrossShortGaps(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testCrossShortGaps(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testCrossShortGaps(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testCrossShortGaps(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testCrossShortGaps(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testCrossShortGaps(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testCrossShortGaps(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testCrossShortGaps(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testCrossShortGaps(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testCrossShortGaps(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testCrossShortGaps(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testCrossShortGaps(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testCrossShortGaps(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testCrossShortGaps(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testCrossShortGaps(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testCrossShortGaps(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testCrossShortGaps(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testCrossShortGaps(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testCrossShortGaps(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testCrossShortGaps(Cases.HARD, 6);
   }

   private void testCrossShortGaps(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::crossShortGaps, testType, testCase);
   }
}

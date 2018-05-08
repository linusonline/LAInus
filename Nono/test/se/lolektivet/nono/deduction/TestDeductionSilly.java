package se.lolektivet.nono.deduction;

import org.junit.Test;
import se.lolektivet.nono.ChainedDeductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionSilly {

   @Test
   public void testTrivialElimination0() {
      testSillyDeduction(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testSillyDeduction(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testSillyDeduction(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testSillyDeduction(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testSillyDeduction(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testSillyDeduction(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testSillyDeduction(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testSillyDeduction(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testSillyDeduction(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testSillyDeduction(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testSillyDeduction(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testSillyDeduction(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testSillyDeduction(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testSillyDeduction(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testSillyDeduction(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testSillyDeduction(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testSillyDeduction(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testSillyDeduction(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testSillyDeduction(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testSillyDeduction(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testSillyDeduction(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testSillyDeduction(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testSillyDeduction(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testSillyDeduction(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testSillyDeduction(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testSillyDeduction(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testSillyDeduction(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testSillyDeduction(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testSillyDeduction(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testSillyDeduction(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testSillyDeduction(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testSillyDeduction(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testSillyDeduction(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testSillyDeduction(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testSillyDeduction(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testSillyDeduction(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testSillyDeduction(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testSillyDeduction(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testSillyDeduction(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testSillyDeduction(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testSillyDeduction(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testSillyDeduction(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testSillyDeduction(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testSillyDeduction(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testSillyDeduction(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testSillyDeduction(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testSillyDeduction(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testSillyDeduction(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testSillyDeduction(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testSillyDeduction(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testSillyDeduction(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testSillyDeduction(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testSillyDeduction(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testSillyDeduction(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testSillyDeduction(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testSillyDeduction(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testSillyDeduction(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testSillyDeduction(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testSillyDeduction(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testSillyDeduction(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testSillyDeduction(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testSillyDeduction(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testSillyDeduction(Cases.HARD, 6);
   }

   private void testSillyDeduction(String testType, int testCase) {
      TestUtils.testSimpleDeduction(ChainedDeductor::sillyDeduction, testType, testCase);
   }
}

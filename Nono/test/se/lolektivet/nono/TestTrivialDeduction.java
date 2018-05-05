package se.lolektivet.nono;

import org.junit.Test;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestTrivialDeduction {

   @Test
   public void testTrivialElimination0() {
      testTrivialDeduction(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testTrivialDeduction(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testTrivialDeduction(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testTrivialDeduction(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testTrivialDeduction(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testTrivialDeduction(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testTrivialDeduction(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testTrivialDeduction(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testTrivialDeduction(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testTrivialDeduction(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testTrivialDeduction(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testTrivialDeduction(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testTrivialDeduction(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testTrivialDeduction(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testTrivialDeduction(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testTrivialDeduction(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testTrivialDeduction(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testTrivialDeduction(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testTrivialDeduction(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testTrivialDeduction(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testTrivialDeduction(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testTrivialDeduction(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testTrivialDeduction(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testTrivialDeduction(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testTrivialDeduction(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testTrivialDeduction(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testTrivialDeduction(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testTrivialDeduction(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testTrivialDeduction(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testTrivialDeduction(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testTrivialDeduction(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testTrivialDeduction(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testTrivialDeduction(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testTrivialDeduction(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testTrivialDeduction(Cases.STREAK_FILL, 1);
   }



   @Test
   public void testFromScratch0() {
      testTrivialDeduction(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testTrivialDeduction(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testTrivialDeduction(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testTrivialDeduction(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testTrivialDeduction(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testTrivialDeduction(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testTrivialDeduction(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testTrivialDeduction(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testTrivialDeduction(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testTrivialDeduction(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testTrivialDeduction(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testTrivialDeduction(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testTrivialDeduction(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testTrivialDeduction(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testTrivialDeduction(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testTrivialDeduction(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testTrivialDeduction(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testTrivialDeduction(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testTrivialDeduction(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testTrivialDeduction(Cases.MISC, 6);
   }

   private void testTrivialDeduction(String testType, int testCase) {
      TestUtils.testDeduction(Deductor::fillInTrivialSequence, testType, testCase);
   }
}

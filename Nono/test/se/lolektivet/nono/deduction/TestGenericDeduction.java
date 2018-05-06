package se.lolektivet.nono.deduction;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestGenericDeduction {

   @Test
   public void testTrivialElimination0() {
      testGenericDeduction(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testGenericDeduction(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testGenericDeduction(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testGenericDeduction(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testGenericDeduction(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testGenericDeduction(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testGenericDeduction(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testGenericDeduction(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testGenericDeduction(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testGenericDeduction(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testGenericDeduction(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testGenericDeduction(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testGenericDeduction(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testGenericDeduction(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testGenericDeduction(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testGenericDeduction(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testGenericDeduction(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testGenericDeduction(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testGenericDeduction(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testGenericDeduction(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testGenericDeduction(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testGenericDeduction(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testGenericDeduction(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testGenericDeduction(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testGenericDeduction(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testGenericDeduction(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testGenericDeduction(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testGenericDeduction(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testGenericDeduction(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testGenericDeduction(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testGenericDeduction(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testGenericDeduction(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testGenericDeduction(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testGenericDeduction(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testGenericDeduction(Cases.STREAK_FILL, 1);
   }



   @Test
   public void testFromScratch0() {
      testGenericDeduction(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testGenericDeduction(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testGenericDeduction(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testGenericDeduction(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testGenericDeduction(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testGenericDeduction(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testGenericDeduction(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testGenericDeduction(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testGenericDeduction(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testGenericDeduction(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testGenericDeduction(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testGenericDeduction(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testGenericDeduction(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testGenericDeduction(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testGenericDeduction(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testGenericDeduction(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testGenericDeduction(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testGenericDeduction(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testGenericDeduction(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testGenericDeduction(Cases.MISC, 6);
   }

   private void testGenericDeduction(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::fitCluesToGaps, testType, testCase);
   }
}

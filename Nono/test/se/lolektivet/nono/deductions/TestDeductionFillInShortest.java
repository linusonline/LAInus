package se.lolektivet.nono.deductions;

import org.junit.Test;
import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.cases.TestUtils;

public class TestDeductionFillInShortest {
   @Test
   public void testTrivialElimination0() {
      testFillInShortest(Cases.TRIV_ELIM, 0);
   }

   @Test
   public void testTrivialElimination1() {
      testFillInShortest(Cases.TRIV_ELIM, 1);
   }

   @Test
   public void testTrivialElimination2() {
      testFillInShortest(Cases.TRIV_ELIM, 2);
   }

   @Test
   public void testTrivialElimination3() {
      testFillInShortest(Cases.TRIV_ELIM, 3);
   }

   @Test
   public void testTrivialElimination4() {
      testFillInShortest(Cases.TRIV_ELIM, 4);
   }

   @Test
   public void testTrivialElimination5() {
      testFillInShortest(Cases.TRIV_ELIM, 5);
   }

   @Test
   public void testTrivialElimination6() {
      testFillInShortest(Cases.TRIV_ELIM, 6);
   }



   @Test
   public void testTrivialFillIn0() {
      testFillInShortest(Cases.TRIV_FILL, 0);
   }

   @Test
   public void testTrivialFillIn1() {
      testFillInShortest(Cases.TRIV_FILL, 1);
   }

   @Test
   public void testTrivialFillIn2() {
      testFillInShortest(Cases.TRIV_FILL, 2);
   }

   @Test
   public void testTrivialFillIn3() {
      testFillInShortest(Cases.TRIV_FILL, 3);
   }

   @Test
   public void testTrivialFillIn4() {
      testFillInShortest(Cases.TRIV_FILL, 4);
   }

   @Test
   public void testTrivialFillIn5() {
      testFillInShortest(Cases.TRIV_FILL, 5);
   }

   @Test
   public void testTrivialFillIn6() {
      testFillInShortest(Cases.TRIV_FILL, 6);
   }

   @Test
   public void testTrivialFillIn7() {
      testFillInShortest(Cases.TRIV_FILL, 7);
   }



   @Test
   public void testElimination0() {
      testFillInShortest(Cases.ELIM, 0);
   }

   @Test
   public void testElimination1() {
      testFillInShortest(Cases.ELIM, 1);
   }

   @Test
   public void testElimination2() {
      testFillInShortest(Cases.ELIM, 2);
   }

   @Test
   public void testElimination3() {
      testFillInShortest(Cases.ELIM, 3);
   }

   @Test
   public void testElimination4() {
      testFillInShortest(Cases.ELIM, 4);
   }

   @Test
   public void testElimination5() {
      testFillInShortest(Cases.ELIM, 5);
   }

   @Test
   public void testElimination6() {
      testFillInShortest(Cases.ELIM, 6);
   }

   @Test
   public void testElimination7() {
      testFillInShortest(Cases.ELIM, 7);
   }

   @Test
   public void testElimination8() {
      testFillInShortest(Cases.ELIM, 8);
   }

   @Test
   public void testElimination9() {
      testFillInShortest(Cases.ELIM, 9);
   }

   @Test
   public void testElimination10() {
      testFillInShortest(Cases.ELIM, 10);
   }

   @Test
   public void testElimination11() {
      testFillInShortest(Cases.ELIM, 11);
   }

   @Test
   public void testElimination12() {
      testFillInShortest(Cases.ELIM, 12);
   }



   @Test
   public void testEliminationByStreak0() {
      testFillInShortest(Cases.STREAK_ELIM, 0);
   }

   @Test
   public void testEliminationByStreak1() {
      testFillInShortest(Cases.STREAK_ELIM, 1);
   }

   @Test
   public void testEliminationByStreak2() {
      testFillInShortest(Cases.STREAK_ELIM, 2);
   }

   @Test
   public void testEliminationByStreak3() {
      testFillInShortest(Cases.STREAK_ELIM, 3);
   }

   @Test
   public void testEliminationByStreak4() {
      testFillInShortest(Cases.STREAK_ELIM, 4);
   }



   @Test
   public void testFillInByStreak0() {
      testFillInShortest(Cases.STREAK_FILL, 0);
   }

   @Test
   public void testFillInByStreak1() {
      testFillInShortest(Cases.STREAK_FILL, 1);
   }

   @Test
   public void testFillInByStreak2() {
      testFillInShortest(Cases.STREAK_FILL, 2);
   }



   @Test
   public void testFromScratch0() {
      testFillInShortest(Cases.SCRATCH, 0);
   }

   @Test
   public void testFromScratch1() {
      testFillInShortest(Cases.SCRATCH, 1);
   }

   @Test
   public void testFromScratch2() {
      testFillInShortest(Cases.SCRATCH, 2);
   }

   @Test
   public void testFromScratch3() {
      testFillInShortest(Cases.SCRATCH, 3);
   }

   @Test
   public void testFromScratch4() {
      testFillInShortest(Cases.SCRATCH, 4);
   }

   @Test
   public void testFromScratch5() {
      testFillInShortest(Cases.SCRATCH, 5);
   }



   @Test
   public void testNullProblems0() {
      testFillInShortest(Cases.FALSE, 0);
   }

   @Test
   public void testNullProblems1() {
      testFillInShortest(Cases.FALSE, 1);
   }

   @Test
   public void testNullProblems2() {
      testFillInShortest(Cases.FALSE, 2);
   }

   @Test
   public void testNullProblems3() {
      testFillInShortest(Cases.FALSE, 3);
   }

   @Test
   public void testNullProblems4() {
      testFillInShortest(Cases.FALSE, 4);
   }

   @Test
   public void testNullProblems5() {
      testFillInShortest(Cases.FALSE, 5);
   }

   @Test
   public void testNullProblems6() {
      testFillInShortest(Cases.FALSE, 6);
   }



   @Test
   public void testMisc0() {
      testFillInShortest(Cases.MISC, 0);
   }

   @Test
   public void testMisc1() {
      testFillInShortest(Cases.MISC, 1);
   }

   @Test
   public void testMisc2() {
      testFillInShortest(Cases.MISC, 2);
   }

   @Test
   public void testMisc3() {
      testFillInShortest(Cases.MISC, 3);
   }

   @Test
   public void testMisc4() {
      testFillInShortest(Cases.MISC, 4);
   }

   @Test
   public void testMisc5() {
      testFillInShortest(Cases.MISC, 5);
   }

   @Test
   public void testMisc6() {
      testFillInShortest(Cases.MISC, 6);
   }



   @Test
   public void testHardProblem0() {
      testFillInShortest(Cases.HARD, 0);
   }

   @Test
   public void testHardProblem1() {
      testFillInShortest(Cases.HARD, 1);
   }

   @Test
   public void testHardProblem2() {
      testFillInShortest(Cases.HARD, 2);
   }

   @Test
   public void testHardProblem3() {
      testFillInShortest(Cases.HARD, 3);
   }

   @Test
   public void testHardProblem4() {
      testFillInShortest(Cases.HARD, 4);
   }

   @Test
   public void testHardProblem5() {
      testFillInShortest(Cases.HARD, 5);
   }

   @Test
   public void testHardProblem6() {
      testFillInShortest(Cases.HARD, 6);
   }

   private void testFillInShortest(String testType, int testCase) {
      TestUtils.testSimpleDeduction(Deductor::fillInShortestClueFromEdges, testType, testCase);
   }
}

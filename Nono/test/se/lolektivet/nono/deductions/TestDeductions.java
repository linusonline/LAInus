package se.lolektivet.nono.deductions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import se.lolektivet.nono.cases.Cases;
import se.lolektivet.nono.deduction.ComplexDeductions;
import se.lolektivet.nono.deduction.Deduction;
import se.lolektivet.nono.deduction.Deductions;
import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDeductions {

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialElimination6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_ELIM, 6);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 6);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testTrivialFillIn7 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.TRIV_FILL, 7);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 6);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination7 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 7);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination8 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 8);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination9 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 9);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination10 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 10);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination11 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 11);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testElimination12 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.ELIM, 12);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testEliminationByStreak0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_ELIM, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testEliminationByStreak1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_ELIM, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testEliminationByStreak2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_ELIM, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testEliminationByStreak3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_ELIM, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testEliminationByStreak4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_ELIM, 4);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFillInByStreak0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_FILL, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFillInByStreak1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_FILL, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFillInByStreak2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.STREAK_FILL, 2);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testFromScratch5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.SCRATCH, 5);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testNullProblems6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.FALSE, 6);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testMisc6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.MISC, 6);
   }



   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem0 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 0);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem1 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 1);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem2 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 2);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem3 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 3);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem4 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 4);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem5 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 5);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem6 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 6);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem7 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 7);
   }

   @ParameterizedTest
   @MethodSource("deductionProvider")
   public void testHardProblem8 (NamedDeduction deduction) {
      testDeduction(deduction, Cases.HARD, 8);
   }



   private void testDeduction(NamedDeduction deduction, String testType, int testCase) {
      List<SquareState> expected = Cases.solution(testType, testCase);
      List<Integer> clues = Cases.clues(testType, testCase);
      List<SquareState> problem = Cases.problem(testType, testCase);

      List<SquareState> answer = deduction.deduction.apply(problem, clues);

      System.out.println("CLUE: " + clues);
      System.out.println("PROB: [" + se.lolektivet.nono.Util.lineToString(problem) + "]");
      System.out.println("EXPC: [" + se.lolektivet.nono.Util.lineToString(expected) + "]");
      System.out.println("ANSW: [" + se.lolektivet.nono.Util.lineToString(answer) + "]");

      assertEquals(expected, answer);
   }

   static class NamedDeduction {
      public final Deduction deduction;
      public final String name;

      NamedDeduction(Deduction deduction, String name) {
         this.deduction = deduction;
         this.name = name;
      }

      @Override
      public String toString() {
         return name;
      }
   }

   private static Stream<NamedDeduction> deductionProvider() {
      List<NamedDeduction> deductions = new ArrayList<>();
      deductions.add(new NamedDeduction(Deductions::startingDeduction, "startingDeduction"));
      deductions.add(new NamedDeduction(Deductions::crossRestIfComplete, "crossRestIfComplete"));
      deductions.add(new NamedDeduction(Deductions::fillInShortestClueFromEdges, "fillInShortestClueFromEdges"));
      deductions.add(new NamedDeduction(Deductions::crossShortGaps, "crossShortGaps"));
      deductions.add(new NamedDeduction(Deductions::fillRestIfCompletelyCrossed, "fillRestIfCompletelyCrossed"));
      deductions.add(new NamedDeduction(ComplexDeductions::fitCluesToGapsBoth, "fitCluesToGapsBoth"));
      deductions.add(new NamedDeduction(ComplexDeductions::fitCluesToStreaksBoth, "fitCluesToStreaksBoth"));
      deductions.add(new NamedDeduction(ComplexDeductions::fitCluesToGapsAndStreaksBoth, "fitCluesToGapsAndStreaksBoth"));
      deductions.add(new NamedDeduction(ComplexDeductions::fitCluesToStreaksAdvanced, "fitCluesToStreaksAdvanced"));
      deductions.add(new NamedDeduction(ComplexDeductions::fitToStreaksAndGapsAdvancedRepeated, "fitToStreaksAndGapsAdvancedRepeated"));

      return deductions.stream();
   }
}

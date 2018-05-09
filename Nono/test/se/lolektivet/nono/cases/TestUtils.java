package se.lolektivet.nono.cases;

import se.lolektivet.nono.ChainedDeduction;
import se.lolektivet.nono.ChainedDeductor;
import se.lolektivet.nono.Deduction;
import se.lolektivet.nono.model.SquareState;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUtils {

   public static void testChainedDeduction(ChainedDeduction deduction, String testType, int testCase) {
      testDeductionChain(Arrays.asList(deduction), testType, testCase);
   }

   public static void testDeductionChain(List<ChainedDeduction> chain, String testType, int testCase) {

      List<Integer> clues = Cases.clues(testType, testCase);
      List<SquareState> problem = Cases.problem(testType, testCase);
      List<SquareState> expected = Cases.solution(testType, testCase);

      List<SquareState> answer = ChainedDeductor.applyDeductionChainFully(chain, problem, clues);

      System.out.println("CLUE: " + clues);
      System.out.println("PROB: [" + se.lolektivet.nono.Util.lineToString(problem) + "]");
      System.out.println("EXPC: [" + se.lolektivet.nono.Util.lineToString(expected) + "]");
      System.out.println("ANSW: [" + se.lolektivet.nono.Util.lineToString(answer) + "]");

      assertEquals(expected, answer);
   }

   public static void testSimpleDeduction(Deduction deduction, String testType, int testCase) {

      List<SquareState> expected = Cases.solution(testType, testCase);
      List<Integer> clues = Cases.clues(testType, testCase);
      List<SquareState> problem = Cases.problem(testType, testCase);

      List<SquareState> answer = deduction.apply(problem, clues);

      System.out.println("CLUE: " + clues);
      System.out.println("PROB: [" + se.lolektivet.nono.Util.lineToString(problem) + "]");
      System.out.println("EXPC: [" + se.lolektivet.nono.Util.lineToString(expected) + "]");
      System.out.println("ANSW: [" + se.lolektivet.nono.Util.lineToString(answer) + "]");

      assertEquals(expected, answer);
   }
}

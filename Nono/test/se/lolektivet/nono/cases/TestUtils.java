package se.lolektivet.nono.cases;

import se.lolektivet.nono.Deductor;
import se.lolektivet.nono.SquareState;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUtils {

   public static void testDeduction(Deductor.Deduction deduction, String testType, int testCase) {
      List<SquareState> answer = deduction.apply(
            Cases.problem(testType, testCase),
            Cases.clues(testType, testCase));
      List<SquareState> expected =
            Cases.solution(testType, testCase);

      System.out.println("CLUE: " + Cases.clues(testType, testCase));
      System.out.println("PROB: [" + se.lolektivet.nono.Util.lineToString(Cases.problem(testType, testCase)) + "]");
      System.out.println("EXPC: [" + se.lolektivet.nono.Util.lineToString(Cases.solution(testType, testCase)) + "]");
      System.out.println("ANSW: [" + se.lolektivet.nono.Util.lineToString(answer) + "]");

      assertEquals(expected, answer);
   }
}

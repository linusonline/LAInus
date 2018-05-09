package se.lolektivet.nono.unittests;

import org.junit.jupiter.api.Test;
import se.lolektivet.nono.deduction.Deductions;
import se.lolektivet.nono.model.SquareState;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.lolektivet.nono.model.SquareState.STRIKE;
import static se.lolektivet.nono.model.SquareState.UNKNOW;

public class TestDeductorSequences {

   @Test
   public void testCrossShortGaps1() {
      List<SquareState> answer = Deductions.crossShortGaps(
            Arrays.asList(UNKNOW, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testCrossShortGaps2() {
      List<SquareState> answer = Deductions.crossShortGaps(
            Arrays.asList(UNKNOW, STRIKE, UNKNOW, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(STRIKE, STRIKE, UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testCrossShortGaps3() {
      List<SquareState> answer = Deductions.crossShortGaps(
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, STRIKE);
      assertEquals(expected, answer);
   }

}

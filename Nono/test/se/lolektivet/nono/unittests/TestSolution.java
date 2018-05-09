package se.lolektivet.nono.unittests;

import org.junit.Test;
import se.lolektivet.nono.model.Solution;
import se.lolektivet.nono.model.SquareState;

import static org.junit.Assert.assertEquals;

public class TestSolution {

   @Test
   public void testCreate() {
      Solution answer = Solution.createFromString("X.X");
      Solution expected = new Solution(1, 3).setRow(0, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED);
      assertEquals(expected, answer);
   }

   @Test
   public void testCreate2() {
      Solution answer = Solution.createFromString("X.X", ".X.");
      Solution expected = new Solution(2, 3)
            .setRow(0, SquareState.FILLED, SquareState.STRIKE, SquareState.FILLED)
            .setRow(1, SquareState.STRIKE, SquareState.FILLED, SquareState.STRIKE);
      assertEquals(expected, answer);
   }
}

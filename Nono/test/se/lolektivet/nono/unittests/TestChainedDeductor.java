package se.lolektivet.nono.unittests;

import org.junit.Test;
import se.lolektivet.nono.ChainedDeductor;
import se.lolektivet.nono.ContradictionException;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static se.lolektivet.nono.model.SquareState.STRIKE;
import static se.lolektivet.nono.model.SquareState.UNKNOW;

public class TestChainedDeductor {

   @Test
   public void testFirstFit1() {
      int firstFit = ChainedDeductor.findFirstFit(2, Arrays.asList(UNKNOW, UNKNOW), 0);
      assertEquals(0, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit2() {
      ChainedDeductor.findFirstFit(2, Arrays.asList(UNKNOW), 0);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit7() {
      ChainedDeductor.findFirstFit(2, Arrays.asList(STRIKE, UNKNOW, STRIKE), 0);
   }

   @Test
   public void testFirstFit3() {
      int firstFit = ChainedDeductor.findFirstFit(1,
            Arrays.asList(STRIKE, UNKNOW),
            0);
      assertEquals(1, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit4() {
      ChainedDeductor.findFirstFit(1, Arrays.asList(STRIKE, STRIKE), 0);
   }

   @Test
   public void testFirstFit5() {
      int firstFit = ChainedDeductor.findFirstFit(2,
            Arrays.asList(UNKNOW, STRIKE, UNKNOW, STRIKE, UNKNOW, UNKNOW),
            0);
      assertEquals(4, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit6() {
      ChainedDeductor.findFirstFit(2,
            Arrays.asList(UNKNOW, STRIKE, UNKNOW),
            0);
   }

   @Test
   public void testFirstFit8() {
      int firstFit = ChainedDeductor.findFirstFit(3,
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, UNKNOW, UNKNOW, UNKNOW),
            0);
      assertEquals(3, firstFit);
   }

   @Test
   public void testCreateClues0() {
      List<Clue> answer = ChainedDeductor.createClues(Collections.emptyList(), 1);
      List<Clue> expected = Collections.emptyList();
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues1() {
      List<Clue> answer = ChainedDeductor.createClues(Arrays.asList(1), 1);
      List<Clue> expected = Arrays.asList(new Clue(1, 0, 0));
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues2() {
      List<Clue> answer = ChainedDeductor.createClues(Arrays.asList(1), 2);
      List<Clue> expected = Arrays.asList(new Clue(1, 0, 1));
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues3() {
      List<Clue> answer = ChainedDeductor.createClues(Arrays.asList(1, 2, 3, 4), 15);
      List<Clue> expected = Arrays.asList(
            new Clue(1, 0, 2),
            new Clue(2, 2, 4),
            new Clue(3, 5, 7),
            new Clue(4, 9, 11)
            );
      assertEquals(expected, answer);
   }

   @Test
   public void testReverseClue() {
      Clue answer = ChainedDeductor.getReverseClue(new Clue(3, 0, 2), 5);
      Clue expected = new Clue(3, 0, 2);
      assertEquals(expected, answer);
   }

   @Test
   public void testStreakFitsClue0() {
      ChainedDeductor.Streak streak = new ChainedDeductor.Streak(0, 1);
      Clue clue = new Clue(1, 0, 1);
      assertTrue(ChainedDeductor.streakFitsClue(streak, clue));
   }

   @Test
   public void testListStreaks() {
      List<ChainedDeductor.Streak> answer = ChainedDeductor.listStreaks(Arrays.asList(SquareState.UNKNOW, SquareState.FILLED, SquareState.UNKNOW, SquareState.FILLED, SquareState.UNKNOW));
      List<ChainedDeductor.Streak> expected = Arrays.asList(new ChainedDeductor.Streak(1, 1), new ChainedDeductor.Streak(3, 1));
      assertEquals(expected, answer);
   }
}

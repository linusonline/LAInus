package se.lolektivet.nono.unittests;

import org.junit.jupiter.api.Test;
import se.lolektivet.nono.Util;
import se.lolektivet.nono.deduction.ChainedDeductions;
import se.lolektivet.nono.deduction.ComplexDeductions;
import se.lolektivet.nono.deduction.ContradictionException;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static se.lolektivet.nono.model.SquareState.STRIKE;
import static se.lolektivet.nono.model.SquareState.UNKNOW;

public class TestChainedDeductions {

   @Test
   public void testFirstFit1() {
      int firstFit = ChainedDeductions.findFirstFit(2, Arrays.asList(UNKNOW, UNKNOW), 0);
      assertEquals(0, firstFit);
   }

   @Test
   public void testFirstFit2() {
      assertThrows(ContradictionException.class, () ->
            ChainedDeductions.findFirstFit(2, Arrays.asList(UNKNOW), 0));

   }

   @Test
   public void testFirstFit7() {
      assertThrows(ContradictionException.class, () ->
         ChainedDeductions.findFirstFit(2, Arrays.asList(STRIKE, UNKNOW, STRIKE), 0));
   }

   @Test
   public void testFirstFit3() {
      int firstFit = ChainedDeductions.findFirstFit(1,
            Arrays.asList(STRIKE, UNKNOW),
            0);
      assertEquals(1, firstFit);
   }

   @Test
   public void testFirstFit4() {
      assertThrows(ContradictionException.class, () ->
         ChainedDeductions.findFirstFit(1, Arrays.asList(STRIKE, STRIKE), 0));
   }

   @Test
   public void testFirstFit5() {
      int firstFit = ChainedDeductions.findFirstFit(2,
            Arrays.asList(UNKNOW, STRIKE, UNKNOW, STRIKE, UNKNOW, UNKNOW),
            0);
      assertEquals(4, firstFit);
   }

   @Test
   public void testFirstFit6() {
      assertThrows(ContradictionException.class, () ->
            ChainedDeductions.findFirstFit(2,
                  Arrays.asList(UNKNOW, STRIKE, UNKNOW),
                  0));
   }

   @Test
   public void testFirstFit8() {
      int firstFit = ChainedDeductions.findFirstFit(3,
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, UNKNOW, UNKNOW, UNKNOW),
            0);
      assertEquals(3, firstFit);
   }

   @Test
   public void testFirstFit9() {
      int firstFit = ChainedDeductions.findFirstFit(2,
            Util.stringToLine("...  "),
            0);
      assertEquals(3, firstFit);
   }

   @Test
   public void testFirstFitLeft0() {
      int firstFit = ChainedDeductions.findFirstFitLeft(2,
            Util.stringToLine("  ..."),
            5);
      assertEquals(2, firstFit);
   }

   @Test
   public void testCreateClues0() {
      List<Clue> answer = ChainedDeductions.createClues(Collections.emptyList(), 1);
      List<Clue> expected = Collections.emptyList();
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues1() {
      List<Clue> answer = ChainedDeductions.createClues(Arrays.asList(1), 1);
      List<Clue> expected = Arrays.asList(new Clue(1, 0, 0));
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues2() {
      List<Clue> answer = ChainedDeductions.createClues(Arrays.asList(1), 2);
      List<Clue> expected = Arrays.asList(new Clue(1, 0, 1));
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateClues3() {
      List<Clue> answer = ChainedDeductions.createClues(Arrays.asList(1, 2, 3, 4), 15);
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
      Clue answer = ComplexDeductions.getReverseClue(new Clue(3, 0, 2), 5);
      Clue expected = new Clue(3, 0, 2);
      assertEquals(expected, answer);
   }

   @Test
   public void testStreakFitsClue0() {
      ChainedDeductions.Streak streak = new ChainedDeductions.Streak(0, 1);
      Clue clue = new Clue(1, 0, 1);
      assertTrue(ChainedDeductions.streakFitsClue(streak, clue));
   }

   @Test
   public void testListStreaks() {
      List<ChainedDeductions.Streak> answer = ChainedDeductions.listStreaks(Arrays.asList(SquareState.UNKNOW, SquareState.FILLED, SquareState.UNKNOW, SquareState.FILLED, SquareState.UNKNOW));
      List<ChainedDeductions.Streak> expected = Arrays.asList(new ChainedDeductions.Streak(1, 1), new ChainedDeductions.Streak(3, 1));
      assertEquals(expected, answer);
   }

   @Test
   public void testCopyClues() {
      Clue clue = new Clue(1, 0, 1);
      List<Clue> clues = Collections.singletonList(clue);
      List<Clue> copy = ComplexDeductions.copyClues(clues);
      clue.earliestStart = 1;
      assertEquals(1, clues.get(0).earliestStart);
      assertEquals(0, copy.get(0).earliestStart);
      assertNotEquals(clues, copy);
      clue.earliestStart = 0;
      assertEquals(clues, copy);
   }
}

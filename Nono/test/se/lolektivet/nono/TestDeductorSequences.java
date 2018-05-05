package se.lolektivet.nono;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static se.lolektivet.nono.SquareState.FILLED;
import static se.lolektivet.nono.SquareState.STRIKE;
import static se.lolektivet.nono.SquareState.UNKNOW;

public class TestDeductorSequences {

   private List<SquareState> empty(int length) {
      List<SquareState> sequence = new ArrayList<>(length);
      for (int i = 0; i < length; i++) {
         sequence.add(i, UNKNOW);
      }
      return sequence;
   }

   @Test
   public void testTrivialSequence1() {
      List<SquareState> answer = Deductor.fillInTrivialSequence(empty(5), Arrays.asList(1, 1));
      List<SquareState> expected = Arrays.asList(UNKNOW, UNKNOW, UNKNOW, UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testTrivialSequence2() {
      List<SquareState> answer = Deductor.fillInTrivialSequence(empty(5), Arrays.asList(3));
      List<SquareState> expected = Arrays.asList(UNKNOW, UNKNOW, FILLED, UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testTrivialSequence3() {
      List<SquareState> answer = Deductor.fillInTrivialSequence(empty(5), Arrays.asList(3, 1));
      List<SquareState> expected = Arrays.asList(FILLED, FILLED, FILLED, STRIKE, FILLED);
      assertEquals(expected, answer);
   }

   @Test
   public void testTrivialSequence4() {
      List<SquareState> answer = Deductor.fillInTrivialSequence(empty(5), Arrays.asList(4));
      List<SquareState> expected = Arrays.asList(UNKNOW, FILLED, FILLED, FILLED, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testFillInShortest() {
      List<SquareState> answer = Deductor.fillInShortestClueFromEdges(
            Arrays.asList(UNKNOW, UNKNOW, FILLED, UNKNOW, UNKNOW),
            Arrays.asList(4));
      List<SquareState> expected =
            Arrays.asList(UNKNOW, FILLED, FILLED, FILLED, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testCrossShortGaps1() {
      List<SquareState> answer = Deductor.crossShortGaps(
            Arrays.asList(UNKNOW, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testCrossShortGaps2() {
      List<SquareState> answer = Deductor.crossShortGaps(
            Arrays.asList(UNKNOW, STRIKE, UNKNOW, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(STRIKE, STRIKE, UNKNOW, UNKNOW);
      assertEquals(expected, answer);
   }

   @Test
   public void testCrossShortGaps3() {
      List<SquareState> answer = Deductor.crossShortGaps(
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, UNKNOW),
            Arrays.asList(2));
      List<SquareState> expected =
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, STRIKE);
      assertEquals(expected, answer);
   }

   @Test
   public void testFirstFit1() {
      int firstFit = Deductor.findFirstFit(2, Arrays.asList(UNKNOW, UNKNOW), 0);
      assertEquals(0, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit2() {
      Deductor.findFirstFit(2, Arrays.asList(UNKNOW), 0);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit7() {
      Deductor.findFirstFit(2, Arrays.asList(STRIKE, UNKNOW, STRIKE), 0);
   }

   @Test
   public void testFirstFit3() {
      int firstFit = Deductor.findFirstFit(1,
            Arrays.asList(STRIKE, UNKNOW),
            0);
      assertEquals(1, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit4() {
      Deductor.findFirstFit(1, Arrays.asList(STRIKE, STRIKE), 0);
   }

   @Test
   public void testFirstFit5() {
      int firstFit = Deductor.findFirstFit(2,
            Arrays.asList(UNKNOW, STRIKE, UNKNOW, STRIKE, UNKNOW, UNKNOW),
            0);
      assertEquals(4, firstFit);
   }

   @Test (expected = ContradictionException.class)
   public void testFirstFit6() {
      Deductor.findFirstFit(2,
            Arrays.asList(UNKNOW, STRIKE, UNKNOW),
            0);
   }

   @Test
   public void testFirstFit8() {
      int firstFit = Deductor.findFirstFit(3,
            Arrays.asList(UNKNOW, UNKNOW, STRIKE, UNKNOW, UNKNOW, UNKNOW),
            0);
      assertEquals(3, firstFit);
   }
}

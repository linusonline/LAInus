package se.lolektivet.nono;

import org.junit.Test;
import se.lolektivet.nono.model.Clue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestChainedDeductor {

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

}

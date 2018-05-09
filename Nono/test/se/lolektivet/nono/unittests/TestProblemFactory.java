package se.lolektivet.nono.unittests;

import org.junit.Test;
import se.lolektivet.nono.Util;
import se.lolektivet.nono.model.Problem;
import se.lolektivet.nono.model.ProblemFactory;
import se.lolektivet.nono.model.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestProblemFactory {

   @Test
   public void testCreateProblem() {
      Solution solution = Solution.createFromString("X");
      Problem answer = ProblemFactory.create(solution);
      Problem expected = new ProblemFactory().create(1, 1).addRowFromTop(1).addColumnFromLeft(1).finish();
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateProblem1() {
      Solution solution = Solution.createFromString("XX", "XX");
      Problem answer = ProblemFactory.create(solution);
      Problem expected = new ProblemFactory().create(2, 2)
            .addRowFromTop(2)
            .addRowFromTop(2)
            .addColumnFromLeft(2)
            .addColumnFromLeft(2)
            .finish();
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateProblem2() {
      Solution solution = Solution.createFromString("..", "..");
      Problem answer = ProblemFactory.create(solution);
      Problem expected = new Problem(Arrays.asList(Collections.emptyList(), Collections.emptyList()), Arrays.asList(Collections.emptyList(), Collections.emptyList()));
      assertEquals(expected, answer);
   }

   @Test
   public void testCreateProblem3() {
      Solution solution = Solution.createFromString(".X", "X.");
      Problem answer = ProblemFactory.create(solution);
      Problem expected = new ProblemFactory().create(2, 2)
            .addRowFromTop(1)
            .addRowFromTop(1)
            .addColumnFromLeft(1)
            .addColumnFromLeft(1)
            .finish();
      assertEquals(expected, answer);
   }

   @Test
   public void testListClues() {
      List<Integer> answer = ProblemFactory.listClues(Util.stringToLine(".....XXX..XXXXX.XXX................"));
      List<Integer> expected = Arrays.asList(3, 5, 3);
      assertEquals(expected, answer);
   }

   @Test
   public void testListClues3() {
      List<Integer> answer = ProblemFactory.listClues(Util.stringToLine("..XXX.XXXXX.XXX."));
      List<Integer> expected = Arrays.asList(3, 5, 3);
      assertEquals(expected, answer);
   }

   @Test
   public void testListClues2() {
      List<Integer> answer = ProblemFactory.listClues(Util.stringToLine(".X.X."));
      List<Integer> expected = Arrays.asList(1, 1);
      assertEquals(expected, answer);
   }
}

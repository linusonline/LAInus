package se.lolektivet.ai.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNQueens {

   @Test
   public void testConflictsDiagonally() {
      assertTrue(
      new NQueens(8).conflictsDiagonally(
         new NQueens.State(
               new NQueens.State(), new NQueens.Action(1)), 2));
   }

   @Test
   public void testConflictsDiagonally1() {
      assertFalse(
      new NQueens(8).conflictsDiagonally(
         new NQueens.State(
         new NQueens.State(
               new NQueens.State(), new NQueens.Action(1)), new NQueens.Action(3)), 5));
   }
}

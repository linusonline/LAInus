package se.lolektivet.nono.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemFactory {

   private boolean _created = false;
   private boolean _finished = false;
   private int _height;
   private int _width;
   private final List<List<Integer>> _rows;
   private final List<List<Integer>> _columns;

   public ProblemFactory() {
      _rows = new ArrayList<>();
      _columns = new ArrayList<>();
   }

   public static Problem create(Solution completeSolution) {
      List<List<Integer>> rows = new ArrayList<>();
      List<List<Integer>> columns = new ArrayList<>();

      for (int row = 0; row < completeSolution.getHeight(); row++) {
         rows.add(listClues(completeSolution.getRow(row)));
      }

      for (int column = 0; column < completeSolution.getWidth(); column++) {
         columns.add(listClues(completeSolution.getColumn(column)));
      }

      return new Problem(rows, columns);
   }

   public static List<Integer> listClues(List<SquareState> line) {
      List<Integer> clues = new ArrayList<>();

      boolean isInStreak = false;
      int streakLength = 0;

      for (SquareState state : line) {
         if (state.isFilled()) {
            if (!isInStreak) {
               isInStreak = true;
               streakLength = 0;
            }
            streakLength++;
         } else if (isInStreak) {
            clues.add(streakLength);
            isInStreak = false;
         }
      }
      if (isInStreak) {
         clues.add(streakLength);
      }
      return clues;
   }

   public ProblemFactory create(int height, int width) {
      if (_created) {
         throw new RuntimeException("Problem already created!");
      }
      _created = true;
      _height = height;
      _width = width;
      return this;
   }

   public ProblemFactory r(Integer... numbers) {
      return addRowFromTop(numbers);
   }

   public ProblemFactory addRowFromTop(Integer... numbers) {
      if (!_created || _finished) {
         throw new RuntimeException();
      }
      _rows.add(Collections.unmodifiableList(Arrays.asList(numbers)));
      return this;
   }

   public ProblemFactory c(Integer... numbers) {
      return addColumnFromLeft(numbers);
   }

   public ProblemFactory addColumnFromLeft(Integer... numbers) {
      if (!_created || _finished) {
         throw new RuntimeException();
      }
      _columns.add(Collections.unmodifiableList(Arrays.asList(numbers)));
      return this;
   }

   public Problem finish() {
      if (!_created || _finished) {
         throw new RuntimeException();
      }
      if (_rows.size() != _height) {
         throw new RuntimeException("Expected " + _height + " rows, found " + _rows.size());
      }
      if (_columns.size() != _width) {
         throw new RuntimeException("Expected " + _width + " columns, found " + _columns.size());
      }
      _finished = true;
      return new Problem(_rows, _columns);
   }
}

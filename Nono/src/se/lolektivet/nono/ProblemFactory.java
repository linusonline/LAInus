package se.lolektivet.nono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemFactory {

   private boolean _created = false;
   private int _height;
   private int _width;
   private final List<List<Integer>> _rows;
   private final List<List<Integer>> _columns;

   public ProblemFactory() {
      _rows = new ArrayList<>();
      _columns = new ArrayList<>();
   }

   public ProblemFactory create(int height, int width) {
      if (_created) {
         throw new RuntimeException("Problem already created!");
      }
      _height = height;
      _width = width;
      return this;
   }

   public ProblemFactory addRowFromTop(Integer... numbers) {
      _rows.add(Arrays.asList(numbers));
      return this;
   }

   public ProblemFactory addColumnFromLeft(Integer... numbers) {
      _columns.add(Arrays.asList(numbers));
      return this;
   }

   public Problem finish() {
      if (_rows.size() != _height) {
         throw new RuntimeException("Expected " + _height + " rows, found " + _rows.size());
      }
      if (_columns.size() != _width) {
         throw new RuntimeException("Expected " + _width + " columns, found " + _columns.size());
      }
      return new Problem(_rows, _columns);
   }

   public void reset() {
      _created = false;
   }
}

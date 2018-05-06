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

   public ProblemFactory create(int height, int width) {
      if (_created) {
         throw new RuntimeException("Problem already created!");
      }
      _created = true;
      _height = height;
      _width = width;
      return this;
   }

   public ProblemFactory addRowFromTop(Integer... numbers) {
      if (!_created || _finished) {
         throw new RuntimeException();
      }
      _rows.add(Collections.unmodifiableList(Arrays.asList(numbers)));
      return this;
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

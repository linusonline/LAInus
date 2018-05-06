package se.lolektivet.nono.model;

import java.util.Collections;
import java.util.List;

public class Problem {
   private final List<List<Integer>> _rows;
   private final List<List<Integer>> _columns;

   Problem(List<List<Integer>> rows, List<List<Integer>> columns) {
      _rows = Collections.unmodifiableList(rows);
      _columns = Collections.unmodifiableList(columns);
   }

   public int width() {
      return _columns.size();
   }

   public int height() {
      return _rows.size();
   }

   public List<List<Integer>> rows() {
      return _rows;
   }

   public List<List<Integer>> columns() {
      return _columns;
   }

   public List<Integer> row(int row) {
      return _rows.get(row);
   }

   public List<Integer> column(int column) {
      return _columns.get(column);
   }
}

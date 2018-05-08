package se.lolektivet.nono.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem {
   private final List<List<Integer>> _rows;
   private final List<List<Integer>> _columns;

   public Problem(List<List<Integer>> rows, List<List<Integer>> columns) {
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

   @Override
   public String toString() {
      return "Problem{" +
            "_rows=" + _rows +
            ", _columns=" + _columns +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Problem problem = (Problem) o;
      return Objects.equals(_rows, problem._rows) &&
            Objects.equals(_columns, problem._columns);
   }

   @Override
   public int hashCode() {

      return Objects.hash(_rows, _columns);
   }
}

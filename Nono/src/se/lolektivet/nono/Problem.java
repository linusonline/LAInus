package se.lolektivet.nono;

import java.util.List;

public class Problem {
   final List<List<Integer>> rows;
   final List<List<Integer>> columns;

   public Problem(List<List<Integer>> rows, List<List<Integer>> columns) {
      this.rows = rows;
      this.columns = columns;
   }

   public int width() {
      return columns.size();
   }

   public int height() {
      return rows.size();
   }

   public List<Integer> getRow(int row) {
      return rows.get(row);
   }

   public List<Integer> getColumn(int column) {
      return columns.get(column);
   }
}

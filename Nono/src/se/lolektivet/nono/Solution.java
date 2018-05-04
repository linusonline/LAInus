package se.lolektivet.nono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
   private final List<List<SquareState>> rows;
   private int _height;
   private int _width;

   public Solution(int height, int width) {
      rows = new ArrayList<>(height);
      for (int i = 0; i < height; i++) {
         List<SquareState> row = new ArrayList<>(width);
         for (int j = 0; j < width; j++) {
            row.add(SquareState.UNKNOW);
         }
         rows.add(row);
      }
      _height = height;
      _width = width;
   }

   public Solution setRow(int row, SquareState... states) {
      throwOnInvalidSquare(row, states.length - 1);
      for (int column = 0; column < _width; column++) {
         setSquare(row, column, states[column]);
      }
      return this;
   }

   public List<SquareState> getRow(int row) {
      return rows.get(row);
   }

   public List<SquareState> getColumn(int columnNr) {
      List<SquareState> column = new ArrayList<>();
      for (int row = 0; row < _height; row++) {
         column.add(rows.get(row).get(columnNr));
      }
      return column;
   }

   public Solution setSquare(int row, int column, SquareState state) {
      throwOnInvalidSquare(row, column);
      rows.get(row).set(column, state);
      return this;
   }

   public SquareState getSquare(int row, int column) {
      throwOnInvalidSquare(row, column);
      return rows.get(row).get(column);
   }

   public boolean isFull(int row, int column) {
      throwOnInvalidSquare(row, column);
      return getSquare(row, column) == SquareState.FILLED;
   }

   public boolean isEmpty(int row, int column) {
      throwOnInvalidSquare(row, column);
      return getSquare(row, column) == SquareState.STRIKE;
   }

   private void throwOnInvalidSquare(int row, int column) {
      if (row < 0 || row >= _height) {
         throw new RuntimeException("Row " + row + " is invalid, height is " + _height);
      }
      if (column< 0 || column >= _width) {
         throw new RuntimeException("Column " + column + " is invalid, width is " + _width);
      }
   }

   public int getKnownSquares() {
      int known = 0;
      for (List<SquareState> row : rows) {
         known += knownSquaresInSequence(row);
      }
      return known;
   }

   public boolean isRowDone(int row) {
      return knownSquaresInRow(row) == _width;
   }

   public boolean isColumnDone(int column) {
      return knownSquaresInColumn(column) == _height;
   }

   public long knownSquaresInRow(int row) {
      return knownSquaresInSequence(getRow(row));
   }

   public long knownSquaresInColumn(int column) {
      return knownSquaresInSequence(getColumn(column));
   }

   public long knownSquaresInSequence(List<SquareState> row) {
      return row.stream().filter(state -> state != SquareState.UNKNOW).count();
   }

   public int totalSquares() {
      return _height * _width;
   }

   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < _width; i++) {
         stringBuilder.append("-");
      }
      stringBuilder.append("\n");
      for (List<SquareState> row : rows) {
         for (SquareState state : row) {
            stringBuilder.append(state == SquareState.UNKNOW ? " " : state == SquareState.FILLED ? "X" : ".");
         }
         stringBuilder.append("\n");
      }
      for (int i = 0; i < _width; i++) {
         stringBuilder.append("-");
      }
      stringBuilder.append("\n");
      return stringBuilder.toString();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Solution solution = (Solution) o;
      return Objects.equals(rows, solution.rows);
   }

   @Override
   public int hashCode() {
      return Objects.hash(rows);
   }
}

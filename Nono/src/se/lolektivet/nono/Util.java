package se.lolektivet.nono;

import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.List;

public class Util {
   public static String lineToString(List<SquareState> line) {
      StringBuilder stringBuilder = new StringBuilder();
      for (SquareState state : line) {
         switch (state) {
            case FILLED:
               stringBuilder.append("X"); break;
            case STRIKE:
               stringBuilder.append("."); break;
            case UNKNOW:
               stringBuilder.append(" "); break;
         }
      }
      return stringBuilder.toString();
   }

   public static List<SquareState> stringToLine(String lineString) {
      List<SquareState> line = new ArrayList<>(lineString.length());
      for (int i = 0; i < lineString.length(); i++) {
         char c = lineString.charAt(i);
         switch (c) {
            case 'X':
               line.add(SquareState.FILLED); break;
            case '.':
               line.add(SquareState.STRIKE); break;
            case ' ':
               line.add(SquareState.UNKNOW); break;
            default:
               throw new RuntimeException("Illegal character in line string.");
         }
      }
      return line;
   }
}

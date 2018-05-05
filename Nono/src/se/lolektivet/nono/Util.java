package se.lolektivet.nono;

import org.omg.CORBA.UNKNOWN;

import java.util.ArrayList;
import java.util.List;

public class Util {
   public static String sequenceToString(List<SquareState> seq) {
      StringBuilder stringBuilder = new StringBuilder();
      for (SquareState state : seq) {
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

   public static List<SquareState> stringToSequence(String line) {
      List<SquareState> seq = new ArrayList<>(line.length());
      for (int i = 0; i < line.length(); i++) {
         char c = line.charAt(i);
         switch (c) {
            case 'X':
               seq.add(SquareState.FILLED); break;
            case '.':
               seq.add(SquareState.STRIKE); break;
            case ' ':
               seq.add(SquareState.UNKNOW); break;
            default:
               throw new RuntimeException("Illegal character in sequence string.");
         }
      }
      return seq;
   }
}

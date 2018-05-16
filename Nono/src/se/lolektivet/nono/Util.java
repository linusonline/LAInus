package se.lolektivet.nono;

import se.lolektivet.nono.deduction.Deductions;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

   public static List<Clue> copyClues(List<Clue> clues) {
      return clues.stream().map(Clue::new).collect(Collectors.toList());
   }

   public static Deductions.Answer cluesToAnswer(List<Clue> clues, List<SquareState> existing) {
      Deductions.Answer answer = new Deductions.Answer(existing);
      for (Clue clue : clues) {
         setAll(existing, answer, clue.latestStart, clue.earliestEnd, SquareState.FILLED);
      }
      int crossStart = 0;
      for (Clue clue : clues) {
         setAll(existing, answer, crossStart, clue.earliestStart, SquareState.STRIKE);
         crossStart = clue.latestEnd;
      }
      setAll(existing, answer, crossStart, existing.size(), SquareState.STRIKE);
      return answer;
   }

   public static void setAll(List<SquareState> existing, Deductions.Answer answer, SquareState state) {
      setAll(existing, answer, 0, existing.size(), state);
   }

   public static void setAll(List<SquareState> existing, Deductions.Answer answer, int begin, int end, SquareState state) {
      if (begin > end) {
         return;
      }
      for (int i = begin; i < end; i++) {
         answer.set(i, state);
      }
   }
}

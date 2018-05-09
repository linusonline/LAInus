package se.lolektivet.nono.deduction;

import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexDeductions {

   public static List<SquareState> fitCluesToGapsRight(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToGapsRight, line, clues);
   }

   public static List<SquareState> fitCluesToGapsLeft(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToGapsLeft, line, clues);
   }

   public static List<SquareState> fitCluesToGapsBoth(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToGapsBoth, line, clues);
   }

   public static List<SquareState> fitCluesToStreaksRight(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToStreaksRight, line, clues);
   }

   public static List<SquareState> fitCluesToStreaksLeft(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToStreaksLeft, line, clues);
   }

   public static List<SquareState> fitCluesToStreaksBoth(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToStreaksBoth, line, clues);
   }

   public static List<SquareState> fitCluesToStreaksAdvanced(List<SquareState> line, List<Integer> clues) {
      return applyChainedDeductionAsSimple(ChainedDeductions::fitCluesToStreaksAdvanced, line, clues);
   }

   public static List<SquareState> fitToGapsAndStreaksRepeated(List<SquareState> line, List<Integer> clues) {
      List<Clue> workingClues = ChainedDeductions.createClues(clues, line.size());

      List<ChainedDeduction> chain = Arrays.asList(ChainedDeductions::fitCluesToStreaksAdvanced, (aLine, someClues) -> applyDeductionInBothDirections(ChainedDeductions::fitCluesToGapsRight, aLine, someClues));
      applyDeductionChainRepeated(chain, line, workingClues);

      return Deductions.cluesToAnswer(workingClues, line).get();
   }

   public static List<SquareState> sillyDeduction(List<SquareState> line, List<Integer> clueNumbers) {
      List<Clue> clues = ChainedDeductions.createClues(clueNumbers, line.size());

      List<ChainedDeduction> chain = new ArrayList<>(2);
      chain.add(ChainedDeductions::fitCluesToGapsRight);
      chain.add(ChainedDeductions::fitCluesToStreaksRight);

      applyDeductionChain(chain, line, clues);
      applyDeductionChainRightToLeft(chain, line, clues);

      return Deductions.cluesToAnswer(clues, line).get();
   }



   public static Deduction chainedToSimpleDeduction(ChainedDeduction chained) {
      return (List<SquareState> line, List<Integer> clues) ->
            applyChainedDeductionAsSimple(chained, line, clues);
   }

   public static List<SquareState> applyChainedDeductionAsSimple(ChainedDeduction deduction, List<SquareState> line, List<Integer> clues) {
      return applyDeductionChainAsSimple(Collections.singletonList(deduction), line, clues);
   }

   public static List<SquareState> applyDeductionChainAsSimple(List<ChainedDeduction> chain, List<SquareState> line, List<Integer> clues) {
      List<Clue> workingClues = ChainedDeductions.createClues(clues, line.size());

      applyDeductionChain(chain, line, workingClues);

      return Deductions.cluesToAnswer(workingClues, line).get();
   }

   public static List<Clue> applyDeductionChain(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      for (ChainedDeduction deduction : chain) {
         deduction.apply(line, clues);
      }
      return clues;
   }

   public static List<Clue> applyDeductionChainRepeated(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      List<Clue> oldClues;
      int deduction = 0;
      do {
         oldClues = new ArrayList<>(clues);
         chain.get(deduction).apply(line, clues);
         if (++deduction >= chain.size()) {
            deduction = 0;
         }
      } while (!oldClues.equals(clues));

      return clues;
   }

   static List<Clue> applyDeductionChainRightToLeft(List<ChainedDeduction> chain, List<SquareState> line, List<Clue> clues) {
      // Reverse line
      List<SquareState> reverseLine = new ArrayList<>(line);
      Collections.reverse(reverseLine);

      // Reverse clues
      List<Clue> reverseClues = getReverseClues(clues, line.size());

      // Apply deduction chain right to left
      applyDeductionChain(chain, reverseLine, reverseClues);

      // To fulfill contract, "clues" needs to be modified with final answer
      List<Clue> finalClues = getReverseClues(reverseClues, line.size());
      Collections.copy(clues, finalClues);

      return clues;
   }

   private static List<Clue> applyDeductionInBothDirections(ChainedDeduction deduction, List<SquareState> line, List<Clue> clues) {
      // First deduction, applied left to right
      deduction.apply(line, clues);

      // Reverse line
      List<SquareState> reverseLine = new ArrayList<>(line);
      Collections.reverse(reverseLine);

      // Reverse clues
      List<Clue> reverseClues = getReverseClues(clues, line.size());

      // Second deduction, applied right to left
      deduction.apply(reverseLine, reverseClues);

      // To fulfill contract, "clues" needs to be modified with final answer
      List<Clue> finalClues = getReverseClues(reverseClues, line.size());
      Collections.copy(clues, finalClues);

      return clues;
   }

   private static List<Clue> getReverseClues(List<Clue> clues, final int lineLength) {
      List<Clue> reverseClues = clues.stream().map((clue) -> getReverseClue(clue, lineLength)).collect(Collectors.toList());
      Collections.reverse(reverseClues);
      return reverseClues;
   }

   public static Clue getReverseClue(Clue clue, int lineLength) {
      return new Clue(clue.value, lineLength - clue.latestEnd, lineLength - clue.earliestEnd);
   }

}

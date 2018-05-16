package se.lolektivet.nono.deduction;

import se.lolektivet.ai.search.StateSearch;
import se.lolektivet.ai.search.StateSearchProblem;
import se.lolektivet.nono.model.Clue;
import se.lolektivet.nono.model.SquareState;

import java.util.*;

public class SearchDeductions {

   public static List<SquareState> search(List<SquareState> line, List<Integer> clueNumbers) {
      List<Clue> clues = ChainedDeductions.createClues(clueNumbers, line.size());
      RowSearchProblem problem = new RowSearchProblem(line, clues);
      StateSearch search = new StateSearch(problem, Collections.asLifoQueue(new ArrayDeque<>()));
      Set<StateSearchProblem.Solution> possibilities = search.findAllGoals();
      return possibilities.stream()
            .map((solution) -> RowSearchProblem.solutionToLine(line, clues, solution))
            .reduce(SearchDeductions::mergePossibilities)
            .orElseThrow(ContradictionException::new);
   }

   private static List<SquareState> mergePossibilities(List<SquareState> lineOne, List<SquareState> lineTwo) {
      List<SquareState> mergedLine = new ArrayList<>(lineOne.size());
      for (int i = 0; i < lineOne.size(); i++) {
         SquareState newState = SquareState.UNKNOW;
         if (lineOne.get(i) == lineTwo.get(i)) {
            newState = lineOne.get(i);
         }
         mergedLine.add(newState);
      }
      return mergedLine;
   }
}

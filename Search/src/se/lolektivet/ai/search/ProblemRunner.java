package se.lolektivet.ai.search;

import java.util.ArrayDeque;
import java.util.Collections;

public class ProblemRunner {

   public static final long MAX_TIME_MS = 30000;

   private final ProblemSequence sequence;

   public ProblemRunner(ProblemSequence sequence) {
      this.sequence = sequence;
   }

   public void runDepthFirst() {
      StateSearchProblem problem = sequence.next();
      while (problem != null) {
         StateSearch search = new StateSearch(problem, Collections.asLifoQueue(new ArrayDeque<>()));
         System.out.println("Searching...");
         long before = System.currentTimeMillis();
         StateSearchProblem.Solution solution = search.findGoal();
         long time = System.currentTimeMillis() - before;
         if (solution.isFailure) {
            System.out.println("Failed to find solution in " + time + " ms.");
         } else {
            System.out.println("Found a solution in " + time + " ms.");
            problem.printSolution(solution);
         }
         problem = (time > MAX_TIME_MS ? null : sequence.next());
      }
   }
}

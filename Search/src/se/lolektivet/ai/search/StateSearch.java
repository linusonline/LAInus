package se.lolektivet.ai.search;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class StateSearch {
   public static class Node {
      private final StateSearchProblem.State state;
      private final Node parent;
      private final StateSearchProblem.Action previousAction;
      private final StateSearchProblem.Cost totalCost;
      private final int depth;


      public Node(StateSearchProblem.State state, Node parent, StateSearchProblem.Action previousAction, StateSearchProblem.Cost totalCost, int depth) {
         this.state = state;
         this.parent = parent;
         this.previousAction = previousAction;
         this.totalCost = totalCost;
         this.depth = depth;
      }
   }

   private final StateSearchProblem problem;
   private final Queue<Node> fringe;
   private int processedNodes = 0;

   public StateSearch(StateSearchProblem problem, Queue<Node> fringe) {
      this.problem = problem;
      this.fringe = fringe;
   }

   @NotNull
   public StateSearchProblem.Solution findGoal() {
      return findGoal(false);
   }

   public StateSearchProblem.Solution findGoal(boolean debug) {
      return internalFindGoals(debug, false).stream()
            .findFirst()
            .orElse(new StateSearchProblem.Solution());
   }

   public Set<StateSearchProblem.Solution> findAllGoals() {
      return findAllGoals(false);
   }

   public Set<StateSearchProblem.Solution> findAllGoals(boolean debug) {
      return internalFindGoals(debug, true);
   }

   private Set<StateSearchProblem.Solution> internalFindGoals(boolean debug, boolean findAll) {
      Set<StateSearchProblem.Solution> allSolutions = new HashSet<>();
      fringe.add(rootNode());
      while (!fringe.isEmpty()){
         Node nextNode = fringe.remove();
         if (problem.isGoal(nextNode.state)) {
            allSolutions.add(solutionFromState(nextNode));
            if (!findAll) {
               return allSolutions;
            }
         } else {
            fringe.addAll(expandNode(nextNode));
            if (++processedNodes > 1000000 && debug) {
               processedNodes = 0;
               System.out.println("Latest depth: " + nextNode.depth);
               System.out.println("Fringe size: " + fringe.size());
            }
         }
      }
      return allSolutions;
   }

   private List<Node> expandNode(Node node) {
      return problem.successorFunction(node.state).entrySet().stream()
            .map((entry) -> nodeFromState(entry.getValue(), node, entry.getKey()))
            .collect(Collectors.toList());
   }

   private StateSearchProblem.Solution solutionFromState(Node node) {
      List<StateSearchProblem.Action> actionList = new ArrayList<>();
      while (node.previousAction != null) {
         actionList.add(0, node.previousAction);
         node = node.parent;
      }
      return new StateSearchProblem.Solution(actionList);
   }

   private Node rootNode() {
      return new Node(problem.getInitialState(), null, null, problem.getZeroCost(), 0);
   }

   private Node nodeFromState(StateSearchProblem.State state, @NotNull Node parent, StateSearchProblem.Action action) {
      return new Node(state, parent, action, parent.totalCost.add(problem.getStepCost(state, action, parent.state)), parent.depth + 1);
   }
}

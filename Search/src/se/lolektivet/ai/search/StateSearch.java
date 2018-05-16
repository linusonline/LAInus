package se.lolektivet.ai.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
   public StateSearchProblem.Solution search() {
      return search(false);
   }

   public StateSearchProblem.Solution search(boolean debug) {
      fringe.add(rootNode());
      while (!fringe.isEmpty()){
         Node nextNode = fringe.remove();
         if (problem.isGoal(nextNode.state)) {
            return solutionFromState(nextNode);
         }
         fringe.addAll(expandNode(nextNode));
         if (++processedNodes > 1000000 && debug) {
            processedNodes = 0;
            System.out.println("Latest depth: " + nextNode.depth);
            System.out.println("Fringe size: " + fringe.size());
         }
      }
      return new StateSearchProblem.Solution();
   }

   private List<Node> expandNode(Node node) {
      Map<? extends StateSearchProblem.Action, ? extends StateSearchProblem.State> successors = problem.successorFunction(node.state);
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

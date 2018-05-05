package se.lolektivet.nono.cases;

import se.lolektivet.nono.SquareState;
import se.lolektivet.nono.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequences {

   public static final List<TestCase> allTestCases = new ArrayList<>();

   static {
      init();
   }

   public static List<Integer> clues(int index) {
      return allTestCases.get(index).clues;
   }

   public static List<SquareState> problem(int index) {
      return allTestCases.get(index).problem;
   }

   public static List<SquareState> solution(int index) {
      return allTestCases.get(index).solution;
   }

   public static void init() {
      List<Integer> clues;
      List<SquareState> problem;
      List<SquareState> solution;

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("  ");
      solution = Util.stringToSequence("XX");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence("     ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence("  X  ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(3, 1);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence("XXX.X");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(4);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence(" XXX ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(4);
      problem  = Util.stringToSequence("  X  ");
      solution = Util.stringToSequence(" XXX ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("  X ");
      solution = Util.stringToSequence(". X ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(".  X ");
      solution = Util.stringToSequence(".. X ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(".   X ");
      solution = Util.stringToSequence("... X ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(4);
      problem  = Util.stringToSequence("      ");
      solution = Util.stringToSequence("  XX  ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence("      ");
      solution = Util.stringToSequence(" X  X ");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("  .   ");
      solution = Util.stringToSequence("...XXX");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2, 4);
      problem  = Util.stringToSequence("   .. XXXX");
      solution = Util.stringToSequence(" X ...XXXX");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("   X   ");
      solution = Util.stringToSequence(".. X ..");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence(" X    ");
      solution = Util.stringToSequence(" XX ..");
      allTestCases.add(new TestCase(clues, problem, solution));

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence("   X   ");
      solution = Util.stringToSequence("   X   ");
      allTestCases.add(new TestCase(clues, problem, solution));

      // Case X
      clues = Arrays.asList(5, 2);
      problem  = Util.stringToSequence("          .  X    ");
      solution = Util.stringToSequence("          .. X ...");
      allTestCases.add(new TestCase(clues, problem, solution));
   }
}

package se.lolektivet.nono.cases;

import se.lolektivet.nono.SquareState;
import se.lolektivet.nono.Util;

import java.util.*;

public class Cases {

   public static final String TRIV_ELIM = "Trivial Elimination";
   public static final String TRIV_FILL = "Trivial Fill-in";
   public static final String ELIM = "Elimination";
   public static final String STREAK_ELIM = "Elimination by Streak";
   public static final String STREAK_FILL = "Fill-in by Streak";
   public static final String FALSE = "False Deduction";
   public static final String SCRATCH = "From scratch";
   public static final String MISC = "Misc";

   public static final List<TestCase> allTestCases = new ArrayList<>();
   public static final Map<String, List<TestCase>> allTestCasesByType = new HashMap<>();

   static {
      init();
   }

   public static List<Integer> clues(String type, int index) {
      return allTestCasesByType.get(type).get(index).clues;
   }

   public static List<SquareState> problem(String type, int index) {
      return allTestCasesByType.get(type).get(index).problem;
   }

   public static List<SquareState> solution(String type, int index) {
      return allTestCasesByType.get(type).get(index).solution;
   }

   private static void add(String type, List<Integer> clues, List<SquareState> problem, List<SquareState> solution) {
      allTestCasesByType.get(type).add(new TestCase(clues, problem, solution));
   }

   public static void init() {
      List<Integer> clues;
      List<SquareState> problem;
      List<SquareState> solution;

      allTestCasesByType.put(TRIV_ELIM, new ArrayList<>());
      allTestCasesByType.put(TRIV_FILL, new ArrayList<>());
      allTestCasesByType.put(ELIM, new ArrayList<>());
      allTestCasesByType.put(STREAK_ELIM, new ArrayList<>());
      allTestCasesByType.put(STREAK_FILL, new ArrayList<>());
      allTestCasesByType.put(FALSE, new ArrayList<>());
      allTestCasesByType.put(SCRATCH, new ArrayList<>());
      allTestCasesByType.put(MISC, new ArrayList<>());

      // Trivial elimination

      clues = Arrays.asList();
      problem  = Util.stringToSequence(" ");
      solution = Util.stringToSequence(".");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList();
      problem  = Util.stringToSequence(". .");
      solution = Util.stringToSequence("...");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList();
      problem  = Util.stringToSequence("   ");
      solution = Util.stringToSequence("...");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(" X ");
      solution = Util.stringToSequence(".X.");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("  XX  ");
      solution = Util.stringToSequence("..XX..");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence(" X X ");
      solution = Util.stringToSequence(".X.X.");
      add(TRIV_ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 1);
      problem  = Util.stringToSequence(" XX X ");
      solution = Util.stringToSequence(".XX.X.");
      add(TRIV_ELIM, clues, problem, solution);

      // Trivial fill-in problems

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(" ");
      solution = Util.stringToSequence("X");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(". .");
      solution = Util.stringToSequence(".X.");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence("... ...");
      solution = Util.stringToSequence("...X...");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("   ");
      solution = Util.stringToSequence("XXX");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("...   ...");
      solution = Util.stringToSequence("...XXX...");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence(" . ");
      solution = Util.stringToSequence("X.X");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence(". . .");
      solution = Util.stringToSequence(".X.X.");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(2, 1);
      problem  = Util.stringToSequence(".  . .");
      solution = Util.stringToSequence(".XX.X.");
      add(TRIV_FILL, clues, problem, solution);

      clues = Arrays.asList(3, 2, 1);
      problem  = Util.stringToSequence("..   .  . .");
      solution = Util.stringToSequence("..XXX.XX.X.");
      add(TRIV_FILL, clues, problem, solution);

      // Eliminate gaps

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(" .  .  . ");
      solution = Util.stringToSequence("..  .  ..");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(". .  .  . .");
      solution = Util.stringToSequence("...  .  ...");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("  . .  ");
      solution = Util.stringToSequence("  ...  ");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(".  . .  .");
      solution = Util.stringToSequence(".  ...  .");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence(" .  .  .  . ");
      solution = Util.stringToSequence("..  .  .  ..");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence(". .  .  .  . .");
      solution = Util.stringToSequence("...  .  .  ...");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence(" .       . ");
      solution = Util.stringToSequence("..       ..");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence("  .  . .  ");
      solution = Util.stringToSequence("  .  ...  ");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence("  .  . .  ");
      solution = Util.stringToSequence("  .  ...  ");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 2);
      problem  = Util.stringToSequence(".  .  . .  .");
      solution = Util.stringToSequence(".  .  ...  .");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(1, 2);
      problem  = Util.stringToSequence("      . ");
      solution = Util.stringToSequence("      ..");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(1, 2);
      problem  = Util.stringToSequence("      . . .");
      solution = Util.stringToSequence("      .....");
      add(ELIM, clues, problem, solution);

      clues = Arrays.asList(2, 1, 2);
      problem  = Util.stringToSequence("         . ");
      solution = Util.stringToSequence("         ..");
      add(ELIM, clues, problem, solution);



      // Use streaks to eliminate

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(" X  ");
      solution = Util.stringToSequence(" X .");
      add(STREAK_ELIM, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("  X  ");
      solution = Util.stringToSequence(". X .");
      add(STREAK_ELIM, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(" X ");
      solution = Util.stringToSequence(".X.");
      add(STREAK_ELIM, clues, problem, solution);

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("   X  ");
      solution = Util.stringToSequence(".  X  ");
      add(STREAK_ELIM, clues, problem, solution);

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("   X    ");
      solution = Util.stringToSequence(".  X  ..");
      add(STREAK_ELIM, clues, problem, solution);

      // Use streaks to fill in

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence(" X    ");
      solution = Util.stringToSequence(" XX ..");
      add(STREAK_FILL, clues, problem, solution);

      clues = Arrays.asList(3, 1);
      problem  = Util.stringToSequence(" X      ");
      solution = Util.stringToSequence(" XX     ");
      add(STREAK_FILL, clues, problem, solution);



      // From scratch

      clues = Arrays.asList(3);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence("  X  ");
      add(SCRATCH, clues, problem, solution);

      clues = Arrays.asList(3, 1);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence("XXX.X");
      add(SCRATCH, clues, problem, solution);

      clues = Arrays.asList(4);
      problem  = Util.stringToSequence("     ");
      solution = Util.stringToSequence(" XXX ");
      add(SCRATCH, clues, problem, solution);

      clues = Arrays.asList(1, 2, 3, 2, 1);
      problem  = Util.stringToSequence("             ");
      solution = Util.stringToSequence("X.XX.XXX.XX.X");
      add(SCRATCH, clues, problem, solution);

      clues = Arrays.asList(1, 2, 3, 2, 1);
      problem  = Util.stringToSequence("              ");
      solution = Util.stringToSequence("   X  XX  X   ");
      add(SCRATCH, clues, problem, solution);

      clues = Arrays.asList(1, 2, 3, 2, 1);
      problem  = Util.stringToSequence("               ");
      solution = Util.stringToSequence("       X       ");
      add(SCRATCH, clues, problem, solution);



      // Null solutions, false deduction detection

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence("  ");
      solution = Util.stringToSequence("  ");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(".  .");
      solution = Util.stringToSequence(".  .");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(".    .");
      solution = Util.stringToSequence(".    .");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(" . ");
      solution = Util.stringToSequence(" . ");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(1);
      problem  = Util.stringToSequence(". . .");
      solution = Util.stringToSequence(". . .");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence("..  .  ..");
      solution = Util.stringToSequence("..  .  ..");
      add(FALSE, clues, problem, solution);

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence("    ");
      solution = Util.stringToSequence("    ");
      add(FALSE, clues, problem, solution);



      // Multiple gaps, misc

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(" .  ");
      solution = Util.stringToSequence("..XX");
      add(MISC, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(". .  .");
      solution = Util.stringToSequence("...XX.");
      add(MISC, clues, problem, solution);

      clues = Arrays.asList(2);
      problem  = Util.stringToSequence(". .  . .");
      solution = Util.stringToSequence("...XX...");
      add(MISC, clues, problem, solution);



      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence("   ");
      solution = Util.stringToSequence("X.X");
      add(MISC, clues, problem, solution);

      clues = Arrays.asList(1, 1);
      problem  = Util.stringToSequence(".   .");
      solution = Util.stringToSequence(".X.X.");
      add(MISC, clues, problem, solution);

      // "Streak pull"

      clues = Arrays.asList(3, 2);
      problem  = Util.stringToSequence(".   X    .");
      solution = Util.stringToSequence(".. XX  X .");
      add(MISC, clues, problem, solution);

      clues = Arrays.asList(3, 2);
      problem  = Util.stringToSequence(".   XX    .");
      solution = Util.stringToSequence("..  XX  X .");
      add(MISC, clues, problem, solution);

   }
}

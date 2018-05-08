package se.lolektivet.nono;

import se.lolektivet.nono.model.Problem;
import se.lolektivet.nono.model.ProblemFactory;
import se.lolektivet.nono.model.Solution;

import java.util.ArrayList;
import java.util.List;

public class Puzzles {

   public final List<Problem> allProblems = new ArrayList<>();
   public final List<Solution> allSolutions = new ArrayList<>();

   public Problem problem(int index) {
      return allProblems.get(index);
   }

   public Solution solution(int index) {
      return allSolutions.get(index);
   }

   public Puzzles() {
      init();
   }

   private void init() {

      allSolutions.add(Solution.createFromString(
            "XXXX.",
            ".XX..",
            ".XX..",
            "....X",
            "X.XXX"));
      allProblems.add(ProblemFactory.create(allSolutions.get(0)));

      allSolutions.add(Solution.createFromString(
            "...X.",
            "..XXX",
            "XXX..",
            "XXX.X",
            "XX..."));
      allProblems.add(ProblemFactory.create(allSolutions.get(1)));

      allSolutions.add(Solution.createFromString(
            "..XX.",
            "...XX",
            "X.XXX",
            "XX...",
            "XXX.."));
      allProblems.add(ProblemFactory.create(allSolutions.get(2)));

      // 10x10 Nonograms Puzzle ID: 4,258,481
      allSolutions.add(Solution.createFromString(
            "XXXXX.....",
            "X.XXXX.XXX",
            "...XXXXXXX",
            "......XXXX",
            "XX....XXXX",
            "X......XXX",
            "........X.",
            "...XXX....",
            "..XXXX.X..",
            "X.XXXXXX.."));
      allProblems.add(ProblemFactory.create(allSolutions.get(3)));

      // 15x15 Nonograms Puzzle ID: 7,978,914
      allSolutions.add(Solution.createFromString(
            "..X..XXXXXXXXXX",
            "X....X.XXXXXXXX",
            ".XXXXX...XXXXXX",
            "XXX........X...",
            "XXXX.XX...XXX..",
            "XXXXXXXX..XXX..",
            "X.XXXXXXX..XX..",
            "....X.XXX...X..",
            "X...XXXX.......",
            "....XXX........",
            "...XXXX........",
            "...XXXX........",
            "XXXXX.XXXX.....",
            "...XXXXXXXX....",
            "..XXX.XXXXX.X.."));
      allProblems.add(ProblemFactory.create(allSolutions.get(4)));

      allSolutions.add(Solution.createFromString(
            "....XXXX....XXXX.........X....",
            "..XXXXXXXXXXXXXXX...X....X....",
            ".XXXXXXXXXXXXXXXXX..XX....X...",
            ".XXXXXXXXXXXXXXXXXX..X.XX.X...",
            "XXXXXXXXXXXXXXXXXXXXXXXX..X...",
            "XXXXXXXXXXXXXXXXXXXXXX....XX..",
            "XXXXXXXXXXXXXXXXXXXXXXX...XX..",
            "XXXXXXXXXXXXXXXXXXXXXXX...XX..",
            "XXXXXXXXXXXXXXXXXXXXXXXX..XX..",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXX..",
            "XXXXXXXXXXXXXXXXXXXXXXXX.XXXX.",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "X.XXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "X.XXXXXXXXXXXXXXXXXXXXXXXXXX..",
            "..XXXXXX.....XXX.XXX.XXXX..XX.",
            "..XXXXXX....XXXX.XXX..X.......",
            "..XXX.XXX..XXXXX.XXX..........",
            "..XXX.XXX...XXX..XXX..........",
            "..XXX.XXXX...X...XXXX.........",
            "..XXX..XXX........XXX........."));
      allProblems.add(ProblemFactory.create(allSolutions.get(5)));

      allSolutions.add(Solution.createFromString(
            "........XXXX........",
            "......XXXXXXXX......",
            "........XXXXXXXX....",
            "...X..X..XXXXXXXX...",
            "..X..X.X..XXXXXXXX..",
            "..X..X.X..XXXXXXXX..",
            ".XX...X...XXXXXXXXX.",
            ".XX..X.X..XXXXXXXXX.",
            "XXX..X.X..XXXXXXXXXX",
            "XXXX..X..XXXXXXXXXXX",
            "XXXXX...XXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXX",
            ".XXXXXXXXXXXXXXXXXX.",
            ".XXXXXXXXXXXXXXXXXX.",
            "..XXXXXXXXXXXXXXXX..",
            "..XXXXXXXXXXXXXXXX..",
            "...XXXXXXXXXXXXXX...",
            "....XXXXXXXXXXXX....",
            "......XXXXXXXX......",
            "........XXXX........"));
      allProblems.add(ProblemFactory.create(allSolutions.get(6)));

      allSolutions.add(Solution.createFromString(
            ".......XXXXXX.................",
            ".....XXXXXXXXXX...............",
            "....XXXXXXXXXXXXX.............",
            "...XXXXXXXXXXXXXXX............",
            "..XXXXX.....XXXXXXX...........",
            ".XXXXX.XXXXX..XXXXXX..........",
            ".XXXX.XXXXXXXX.XXXXXX.........",
            "XXXX.XXXXXXXXXX.XXXXX.........",
            "XXXX.XXXX..XXXX.XXXXXX..X.X...",
            "XXX.XXX..XX..XXX.XXXXX...X.X..",
            "XXX.XXX.XXXXX.XX.XXXXX...X.X..",
            "XXX.XXX.XXXXX.XXX.XXXX....XXX.",
            "XXX.XXX.XX.XX.XXX.XXXX...XXXXX",
            "XXXX.XXX..XXX.XXX.XXXX...XXXXX",
            ".XXXX.XXXXXX.XXX.XXXXX...XXXXX",
            ".XXXXX.XXXX.XXXX.XXXXXX..XXXX.",
            "..XXXXX....XXXX.XXXXXXX..XXXX.",
            "...XXXXXXXXXXX.XXXXXXXXX.XXXX.",
            "....XXXXXXXXX.XXXXXXXXX.XXXXX.",
            "......XXXXX..XXXXXXXX..XXXXXX.",
            "...........XXXXXXX...XXXXXXXX.",
            ".....XXXXXX.......XXXXXXXXXX..",
            "...XXXXXXXXXXXXXXXXXXXXXXXXX..",
            ".XXXXXXXXXXXXXXXXXXXXXXXXXX...",
            "XXXXXXXXXXXXXXXXXXXXXXXXXX...."));
      allProblems.add(ProblemFactory.create(allSolutions.get(7)));

      allSolutions.add(Solution.createFromString(
            "................XXXX...............",
            ".......X......XXXXXXXX............X",
            "......XXX....XXXXXXXXXXX........XXX",
            ".....XXX....XXXXXXXXXXXXXX....XXXX.",
            "...XXXX....XXXXXXXXXXXXXXXXXXXXXX..",
            "..X.XXXX.XXXXXXXXXXXXXXXXXXXXXX....",
            ".XXXXXXXXXXXXXXXXXXXXXXXXXXXX......",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXX........",
            "XXX...XXXXXXXXXXX.XXXXXXXX.........",
            ".......XXXXXXXXX.XXXXXXXXX.........",
            "........XXXXXXXX.XXXXXXXX..........",
            ".........XXXXXXX.XXXXXXXX..........",
            "...........XX..X.XXXXXXX...........",
            "............XX....XXXXXX...........",
            ".............XXX..XXXXX............",
            "..............XX...XXXX............",
            "...................XXXX............",
            "....................XX.............",
            "....................XX.............",
            "...................XX..............",
            "..................XX...............",
            ".................XX................",
            "................XX.................",
            "...............XX..................",
            "...............XX.................."));
      allProblems.add(ProblemFactory.create(allSolutions.get(8)));

      allSolutions.add(Solution.createFromString(
            ".............XXXX........",
            "...........XX....X.......",
            "..........X..XXXX.XX.....",
            ".......XXX.XX.XXX.X.XXX..",
            ".....XX..X..XX...XXX..XX.",
            "....X...X.X...XXXXXX.X.X.",
            "...XX..XX..XX...XX..XX.X.",
            "...X...XXX..XXX....XX..X.",
            "..XX..XXXXXX...XXXXX..XX.",
            "..X..XX....XXXXX.....XX..",
            "...XXX.......XXX..XXXXX..",
            "...X.......XX..XX....XX..",
            "....XXXXXXXX....X....X...",
            ".....X..........XX..XX...",
            "......X..........XXXX....",
            "......XXXX.......XXX.....",
            ".......XXXXX..XXXX.......",
            "......XXXX.XXXXXXXXX.....",
            ".....X...XX..XXXXXX.X..X.",
            ".........XXXXXXX........X",
            "..XXXXX...XXXXX.......XXX",
            ".XXXXXXXX.XXXX...XXXXXXX.",
            ".X.XXXXXXXXXXX..XXXXX.XX.",
            "X.XXXXXXX.XXX..XXX...XX..",
            "XXXXXXX...XXXXXXXXXXXX...",
            "XX........XXXX...XXXX....",
            "XX.......XXX.............",
            ".XX......XXXX............",
            ".......XXXXX.............",
            ".........XX...XXXXX......",
            "........XXX.XXXX..XX.X...",
            "........XXXXXXXXXX.XX....",
            "........XXXX....XXXX.....",
            "......XXXX...............",
            "........XX..............."));
      allProblems.add(ProblemFactory.create(allSolutions.get(9)));

      allSolutions.add(Solution.createFromString(
            ".....XXX..XXXXX.XXX................",
            "....X...XXXX..XX...XXX.XXX.........",
            "...X.XX...X......XXX..XX..X........",
            "....XXX..XX......XXX.X..XXXXX......",
            "..X.XX.XX..X.....XXXXXXX.X.XX......",
            "..X.XX.XXXXX...XXXX..XXXXXX.XX.....",
            ".XXXX.XX..XX...XXXXXX.XX.XXXXX.....",
            ".X.XXXX.XXXX..XXX...XXXXX.X.XX.....",
            ".XX.XXX.X.XX..XXX.XX.X.XX.X.XXX....",
            ".XX.XXX..XX....X..X.XX.XX.X.X.X....",
            "XX.XXX.X.X......X...X..XX.X.X.XX...",
            "X..XXX.XX..XX...XX.XX.XXX.XX.X.X...",
            "X..XXXX.X.XX.X..XXXXX.XX.XXX.X.X...",
            "XX.XXXXX..XXXX...XXX.X.X.XXX.X.XX..",
            ".XX.X.XX...XX....XXXXX.XX.XX.X.XX..",
            ".XX.XXXX...X.....XXXXXX.X.XX.X.XX..",
            ".X.X.XXX...X......X.XX.XXX.X..XXX..",
            ".X.XXXXXX.X.XX..X.X.XXX.XXX.X.XXXX.",
            ".X.XX.XXXX...XXX.X.XXXX.XXX.X..X.X.",
            ".X.X..XXXXX......XX.XXXXXX..X..XXX.",
            "..X..XXXXX.XXX....XXXXX.XX.X..X.X.X",
            "..X..XXXXX........XXXXXX.X.XX.X.X.X",
            "..X.X.X.XXX....X..XXXXXX.X..X..XXXX",
            "..X.XX.XXXX....X...X.XXX.XX.X..X.XX",
            "..X..X.XXX..X...X..X.XX..XX..X.X.XX",
            "..X..X.XXX..XX.XX.X.XXX.XXX..X...XX",
            "..XX.X.XXX..XX.XX.X..XXX.XX..X..XXX",
            "...X..XXX...X..X.....XXX.XXX.X..XXX",
            "...X..XXX...XX.X......XXXX.X..X.XX.",
            "....X..X.....X..X.....XXXXXX.XXXX..",
            "....XX.X.....XX........XXXXX.XXX...",
            ".....XX.X.....X.........XX.XXXXX...",
            "......X.................XXX.XX.X...",
            ".....X..................X.X.X......",
            "...........................XX......"));
      allProblems.add(ProblemFactory.create(allSolutions.get(10)));

      allSolutions.add(Solution.createFromString(
            ".......XXX.........................",
            "......XXXXX........................",
            "......XXXXX........................",
            "......XXXXX........................",
            "......XXXXX........................",
            "......XXXXXX.......................",
            "........XXXXX......................",
            "........XXXXXXXXXXX................",
            "........XXXXXXXXXXXX...............",
            "......XXXXXXXXXXXXXXX..............",
            "......XXXXXXXXXXXXXXXXX............",
            "......XXXXXXXXXXXXXXXXXX...........",
            "......XXXXXXXXXXXXXXXXXXX..........",
            "......XXXXXXXXXXX..XXXXXX..........",
            ".....XXXXXXXXXXXX.....XXXX.........",
            ".....XXXX.XXXXXXX......XXXX........",
            ".....XXX..XXXXXXX.......XXXX.......",
            "XXX.XXXX..XXXXXXX.........XXX......",
            "XXXXXXXX..XXXXXXX.........XXX......",
            ".XXXXXX...XXXXXXXX.................",
            "..........XXXXXXXXX..........XXXX..",
            "...........XXXXXXXXXXXXXXXXXXXXXXX.",
            "...........XXXXXXXXXXXXXXXXXXXXXXX.",
            "...........XXXXXXXXXXXXXXXXXX..XXX.",
            "...........XXXXXXXXXXXXXXXXXX..XXX.",
            "........XXXXXXXXXXXXXXXXXXXXX..XXXX",
            ".......XXXXXXXXXXXXXXXXXXXXXX...XXX",
            ".......XXXXXXXXXXXXXXXXXXXXXX...XXX",
            ".......XX....XXXXXXXXXXXXXXXX....XX",
            ".......XXX...XXXXXXXXXXXXXXXX.....X",
            "........XXX..XXX...XXXX..XXXXX.....",
            "........XXX..XXX....XXXX.XXXXXX....",
            ".............XXX.....XXX...XXXXX...",
            "..............XX.....XXX.....XXX...",
            "..............XX....XXX.......XX...",
            "..............XX...XXXX.......XXX..",
            "..............XX...XXX........XXX..",
            "..............XX..XXXX........XXX..",
            "..............XX..XXXX........XXX..",
            "..............XX..............XXX..",
            ".............XXX...................",
            ".............XXX..................."));
      allProblems.add(ProblemFactory.create(allSolutions.get(11)));

      allSolutions.add(Solution.createFromString(
            "........XXXX........",
            "........XXXXX.......",
            "..XX....X..XXXX.....",
            ".XXX.....XXX...X....",
            "XXXXX......X.X..XX..",
            "XXXX.X...XX..X.XXXX.",
            "XXXXXXXXX..XX.XXXXXX",
            "X........XX...XXXXXX",
            "X.......XX...XXXXXXX",
            ".X......X....X......",
            "..XXXXXX.....XXXXXXX",
            "....XXX.......XX.XX.",
            ".XXX...XXX...XX..XX.",
            ".X.X...X.X...XX...XX",
            ".XXX...XXX..X.X..X.X"));
      allProblems.add(ProblemFactory.create(allSolutions.get(12)));

   }
}

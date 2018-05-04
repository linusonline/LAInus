package se.lolektivet.nono;

public class Main {
   public static void main(String[] args) {

      Problem problem = new ProblemFactory().create(5, 5)
            .addColumnFromLeft(1, 1)
            .addColumnFromLeft(3)
            .addColumnFromLeft(3, 1)
            .addColumnFromLeft(1, 1)
            .addColumnFromLeft(2)

            .addRowFromTop(4)
            .addRowFromTop(2)
            .addRowFromTop(2)
            .addRowFromTop(1)
            .addRowFromTop(1, 3)

            .finish();


   }

}

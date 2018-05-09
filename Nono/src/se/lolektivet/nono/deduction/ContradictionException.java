package se.lolektivet.nono.deduction;

public class ContradictionException extends RuntimeException {

   public ContradictionException() {
   }

   public ContradictionException(String msg) {
      super(msg);
   }
}

package se.lolektivet.nono;

public class ContradictionException extends RuntimeException {

   public ContradictionException() {
   }

   public ContradictionException(String msg) {
      super(msg);
   }
}

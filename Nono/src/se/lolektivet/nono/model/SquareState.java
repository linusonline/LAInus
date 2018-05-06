package se.lolektivet.nono.model;

public enum SquareState {
   FILLED,
   STRIKE,
   UNKNOW;

   public SquareState add(SquareState other) {
      if (this != UNKNOW && other != UNKNOW && this != other) {
         throw new RuntimeException("Tried to merge square conflicting with existing square!");
      }
      if (other == UNKNOW) {
         return this;
      } else {
         return other;
      }
   }
}

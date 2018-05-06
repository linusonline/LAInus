package se.lolektivet.nono.model;

public enum SquareState {
   FILLED,
   STRIKE,
   UNKNOW;

   public boolean isFilled() {
      return this == FILLED;
   }

   public boolean isCrossed() {
      return this == STRIKE;
   }

   public boolean isKnown() {
      return this != UNKNOW;
   }

   public boolean isUnknown() {
      return this == UNKNOW;
   }

   public SquareState add(SquareState other) {
      if (this.isKnown() && other.isKnown() && this != other) {
         throw new RuntimeException("Tried to merge square conflicting with existing square!");
      }
      if (other.isUnknown()) {
         return this;
      } else {
         return other;
      }
   }
}

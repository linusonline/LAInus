package se.lolektivet.nono.model;

import java.util.Objects;

public class Clue {
   public final int value;

   public int earliestStart;
   public int latestStart;
   public int earliestEnd;
   public int latestEnd;

   public Clue(Clue other) {
      this(other.value, other.earliestStart, other.latestStart);
   }

   public Clue(int value, int earliestStart, int latestStart) {
      this.value = value;
      this.earliestStart = earliestStart;
      this.latestStart = latestStart;
      this.earliestEnd = earliestStart + value;
      this.latestEnd = latestStart + value;
   }

   @Override
   public String toString() {
      return "[" + value +
            ", " + earliestStart + " -> " + earliestEnd +
            ", " + latestStart + " -> " + latestEnd +
            ']';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Clue clue = (Clue) o;
      return value == clue.value &&
            earliestStart == clue.earliestStart &&
            latestStart == clue.latestStart &&
            earliestEnd == clue.earliestEnd &&
            latestEnd == clue.latestEnd;
   }

   @Override
   public int hashCode() {

      return Objects.hash(value, earliestStart, latestStart, earliestEnd, latestEnd);
   }
}

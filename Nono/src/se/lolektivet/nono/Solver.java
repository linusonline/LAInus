package se.lolektivet.nono;

public class Solver {
   private Deductor _deductor;

   public Solver(Problem problem) {
      _deductor = new Deductor(problem);
   }

   public Solution solve() {
      _deductor.startingDeduction();
      Deductor.Progress outerCounter = _deductor.getProgressCounter();
      do {
         outerCounter.reset();
         Deductor.Progress innerCounter = _deductor.getProgressCounter();

         do {
            innerCounter.reset();

            _deductor.crossRestInCompleteRows();
            _deductor.crossShortGaps();
            _deductor.fillRestInCompletelyCrossedRows();
            _deductor.fillInShortestClueFromEdges();
         } while (innerCounter.get() > 0);

         _deductor.fitCluesToGaps();

      } while (outerCounter.get() > 0);

      return _deductor.getSolution();
   }

   public Solution getFailed() {
      return _deductor.getSolution();
   }
}

package se.lolektivet.ai.search;

/**
 * A sequence of State Search Problems, usually of increasing size.
 */
public interface ProblemSequence {
   /**
    *
    * @return A StateSearchProblem, or null if the sequence has ended.
    */
   StateSearchProblem next();
}

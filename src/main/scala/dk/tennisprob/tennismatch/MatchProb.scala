package dk.tennisprob.tennismatch

trait MatchProb {

   /**
   * Returns the probability of winning a tie-break match by player1. Player 1 serves first, followed by player 2
   *
   * @param p1AceProb Probability of shooting aces by player 1
   * @param p1PointProb Probability of winning a point given not ace by player 1
   * @param p1AceProb Probability of shooting aces by player 2
   * @param p1PointProb Probability of winning a point given not ace by player 2
   * @param maxWinSets For best-of-3 it's 2, for bets-of-5 it's 3
   */
  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double,maxWinSets:Int): Double
}
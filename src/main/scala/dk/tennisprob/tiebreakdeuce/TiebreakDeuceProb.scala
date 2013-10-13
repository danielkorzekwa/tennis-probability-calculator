package dk.tennisprob.tiebreakdeuce

trait TiebreakDeuceProb {

  /**
   * Returns the probability of winning a deuce by player 1. Player 1 serves first, followed by player 2
   *
   * @param p1AceProb Probability of shooting aces by player 1
   * @param p1PointProb Probability of winning a point on serve given not ace by player 1
   * @param p2AceProb Probability of shooting aces by player 2
   * @param p2PointProb Probability of winning a point on serve given not ace by player 2
   */
  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Double
}
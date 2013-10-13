package dk.tennisprob.twopointsgame

trait TwoPointsGameProb {

  /**
   * Returns the probability of winning a two points game. The same player is on serve for all points.
   *
   * @param aceProb Probability of shooting aces
   * @param pointProb Probability of winning a point on serve given not ace
   * @param Probability of winning/losing/draw of a two points game
   */
  def prob(aceProb: Double, pointProb: Double): Tuple3[Double, Double, Double]

  /**
   * Returns the probability of winning a two points game by player 1. Player 1 serves first, followed by player 2
   *
   * @param p1AceProb Probability of shooting aces by player 1
   * @param p1PointProb Probability of winning a point on serve given not ace by player 1
   * @param p2AceProb Probability of shooting aces by player 2
   * @param p2PointProb Probability of winning a point on serve given not ace by player 2
   * @param Probability of winning/losing/draw of a two points game by player 1
   */
  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Tuple3[Double, Double, Double]
}
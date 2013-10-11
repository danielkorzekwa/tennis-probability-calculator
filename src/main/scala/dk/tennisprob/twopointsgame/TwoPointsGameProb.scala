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
}
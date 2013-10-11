package dk.tennisprob.deuce

trait DeuceProb {

  /**
   * Returns the probability of winning a deuce
   *
   * @param aceProb Probability of shooting aces
   * @param pointProb Probability of winning a point given not ace
   */
  def prob(aceProb: Double, pointProb: Double): Double
}
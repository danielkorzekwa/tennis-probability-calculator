package dk.tennisprob.gameprob

trait GameProb {

  /**
   * Returns the probability of winning a game on serve
   *
   * @param aceProb Probability of shooting aces
   * @param pointProb Probability of winning a point given not ace
   */
  def prob(aceProb: Double, pointProb: Double): Double
}
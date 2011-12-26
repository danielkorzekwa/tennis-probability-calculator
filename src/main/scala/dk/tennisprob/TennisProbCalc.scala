package dk.tennisprob

trait TennisProbCalc {

  /**
   * Calculates average probability of winning a point by a player against other players he played.
   *
   * @param firstServeProb Probability of a first serve. 1-firstServeProb is a probability of missing the first serve.
   * @param firstServeWinProb Probability of winning a point on a first serve.
   * @param secondServeWinProb Probability of winning a point on a second serve.
   *
   */
  def pointAvgProb(firstServeProb: Double, firstServeWinProb: Double, secondServeWinProb: Double): Double

  /**
   * Calculates probability of winning a point on serve by player A against player B.
   *
   * @param winOnServeProb Probability of winning a point on serve by player A against the 'field' (average player).
   * @param winOnReturnOpponentProb Probability of winning a point on return by player B against the 'field' (average player).
   * @param winOnReturnAvgProb Probability of winning a point on return by the field (average player).
   */
  def pointProb(winOnServeProb: Double, winOnReturnOpponentProb: Double, winOnReturnAvgProb: Double): Double

  /**
   * Calculates probability of winning a tennis game by player on serve.
   *
   * @param pointProb Probability of winning a point by a player on serve
   */
  def gameProb(pointProb: Double): Double

  /**
   * Calculates probability of winning a tennis tie break.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def tiebreakProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double

  /**
   * Calculates probability of winning a tennis set.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def setProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double

  /**
   * Calculates probability of winning a tennis three-set match.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def match3SetProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double

  /**
   * Calculates probability of winning a tennis five-set match.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def match5SetProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double
}
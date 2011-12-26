package dk.tennisprob

import scala.Math._

/**
 * This calculator is based on research paper:
 * Probability Formulas and Statistical Analysis in Tennis, O'Malley, a. James, Journal of Quantitative Analysis in Sports, 2008
 */
object TennisProbFormulaCalc extends TennisProbCalc {

  /**
   * Calculates average probability of winning a point by a player against other players he played.
   *
   * @param firstServeProb Probability of a first serve. 1-firstServeProb is a probability of missing the first serve.
   * @param firstServeWinProb Probability of winning a point on a first serve.
   * @param secondServeWinProb Probability of winning a point on a second serve.
   *
   */
  def pointAvgProb(firstServeProb: Double, firstServeWinProb: Double, secondServeWinProb: Double): Double =
    firstServeProb * firstServeWinProb + (1 - firstServeProb) * secondServeWinProb

  /**
   * Calculates probability of winning a point on serve by player A against player B.
   *
   * @param winOnServeProb Probability of winning a point on serve by player A against the 'field' (average player).
   * @param winOnReturnOpponentProb Probability of winning a point on return by player B against the 'field' (average player).
   * @param winOnReturnAvgProb Probability of winning a point on return by the field (average player).
   */
  def pointProb(winOnServeProb: Double, winOnReturnOpponentProb: Double, winOnReturnAvgProb: Double): Double =
    winOnServeProb - (winOnReturnOpponentProb - winOnReturnAvgProb)
  /**
   * Calculates probability of winning a tennis game by player on serve.
   *
   * @param pointProb Probability of winning a point by a player on serve
   */
  def gameProb(pointProb: Double): Double = {
    val p = pointProb
    pow(p, 4) * (15 - 4 * p - (10 * p * p) / (1 - 2 * p * (1 - p)))
  }

  /**
   * Calculates probability of winning a tennis tie break.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def tiebreakProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double = {
    val p = pointProbOnServe
    val q = pointProbOnReceive

    def d = p * q * pow(1 - (p * (1 - q) + (1 - p) * q), -1)

    def product(a: Array[Int]): Double = a(0) * pow(p, a(1)) * pow((1 - p), a(2)) * pow(q, a(3)) * pow((1 - q), a(4)) * pow(d, a(5))
    val prob = A.foldLeft(0d)((sum, array) => sum + product(array))
    prob
  }

  /**
   * Calculates probability of winning a tennis set.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def setProb(pointProbOnServe: Double, pointProbOnReceive: Double) = {
    val p = pointProbOnServe
    val q = pointProbOnReceive
    val G = gameProb _
    val TB = tiebreakProb _

    def product(b: Array[Int]): Double = b(0) * pow(G(p), b(1)) * pow(1 - G(p), b(2)) * pow(G(q), b(3)) * pow(1 - G(q), b(4)) *
      pow(G(p) * G(q) + (G(p) * (1 - G(q)) + (1 - G(p)) * G(q)) * TB(p, q), b(5))

    val prob = B.foldLeft(0d)((sum, array) => sum + product(array))
    prob
  }

  /**
   * Calculates probability of winning a tennis three-set match.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def match3SetProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double = {
    val p = pointProbOnServe
    val q = pointProbOnReceive
    val S = setProb _
    val prob = pow(S(p, q), 2) * (1 + 2 * (1 - S(p, q)))
    prob
  }

  /**
   * Calculates probability of winning a tennis five-set match.
   *
   * @param pointProbOnServe Probability of winning a point when serving
   * @param pointProbOnReceive Probability of winning a point when receiving serve
   */
  def match5SetProb(pointProbOnServe: Double, pointProbOnReceive: Double): Double = {
    val p = pointProbOnServe
    val q = pointProbOnReceive
    val S = setProb _
    val prob = pow(S(p, q), 3) * (1 + 3 * (1 - S(p, q)) + 6 * pow((1 - S(p, q)), 2))
    prob
  }

  val A = Array(
    Array(1, 3, 0, 4, 0, 0),
    Array(3, 3, 1, 4, 0, 0),
    Array(4, 4, 0, 3, 1, 0),
    Array(6, 3, 2, 4, 0, 0),
    Array(16, 4, 1, 3, 1, 0),
    Array(6, 5, 0, 2, 2, 0),
    Array(10, 2, 3, 5, 0, 0),
    Array(40, 3, 2, 4, 1, 0),
    Array(30, 4, 1, 3, 2, 0),
    Array(4, 5, 0, 2, 3, 0),

    Array(5, 1, 4, 6, 0, 0),
    Array(50, 2, 3, 5, 1, 0),
    Array(100, 3, 2, 4, 2, 0),
    Array(50, 4, 1, 3, 3, 0),
    Array(5, 5, 0, 2, 4, 0),
    Array(1, 1, 5, 6, 0, 0),
    Array(30, 2, 4, 5, 1, 0),
    Array(150, 3, 3, 4, 2, 0),
    Array(200, 4, 2, 3, 3, 0),
    Array(75, 5, 1, 2, 4, 0),

    Array(6, 6, 0, 1, 5, 0),
    Array(1, 0, 6, 6, 0, 1),
    Array(36, 1, 5, 5, 1, 1),
    Array(225, 2, 4, 4, 2, 1),
    Array(400, 3, 3, 3, 3, 1),
    Array(225, 4, 2, 2, 4, 1),
    Array(36, 5, 1, 1, 5, 1),
    Array(1, 6, 0, 0, 6, 1))

  val B = Array(
    Array(1, 3, 0, 3, 0, 0),
    Array(3, 3, 1, 3, 0, 0),
    Array(3, 4, 0, 2, 1, 0),
    Array(6, 2, 2, 4, 0, 0),
    Array(12, 3, 1, 3, 1, 0),
    Array(3, 4, 0, 2, 2, 0),
    Array(4, 2, 3, 4, 0, 0),
    Array(24, 3, 2, 3, 1, 0),
    Array(24, 4, 1, 2, 2, 0),
    Array(4, 5, 0, 1, 3, 0),

    Array(5, 1, 4, 5, 0, 0),
    Array(40, 2, 3, 4, 1, 0),
    Array(60, 3, 2, 3, 2, 0),
    Array(20, 4, 1, 2, 3, 0),
    Array(1, 5, 0, 1, 4, 0),
    Array(1, 0, 5, 5, 0, 1),
    Array(25, 1, 4, 4, 1, 1),
    Array(100, 2, 3, 3, 2, 1),
    Array(100, 3, 2, 2, 3, 1),
    Array(25, 4, 1, 1, 4, 1),

    Array(1, 5, 0, 0, 5, 1))

}
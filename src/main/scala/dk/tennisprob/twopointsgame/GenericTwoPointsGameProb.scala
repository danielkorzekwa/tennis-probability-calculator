package dk.tennisprob.twopointsgame

import scala.math._
import scala.annotation.tailrec

object GenericTwoPointsGameProb extends TwoPointsGameProb {

  def prob(aceProb: Double, pointProb: Double): Tuple3[Double, Double, Double] = {

    def markovChainPoint(p1Points: Int, p2Points: Int, outcome: Int): Double = {
      (p1Points, p2Points) match {
        case (2, 0) => if (outcome == 0) 1 else 0
        case (0, 2) => if (outcome == 1) 1 else 0
        case (1, 1) => if (outcome == 2) 1 else 0
        case _ => pointProb * markovChainAce(p1Points + 1, p2Points, outcome) + (1 - pointProb) * markovChainAce(p1Points, p2Points + 1, outcome)
      }
    }

    def markovChainAce(p1Points: Int, p2Points: Int, outcome: Int): Double = {
      (p1Points, p2Points) match {
        case (2, 0) => if (outcome == 0) 1 else 0
        case (0, 2) => if (outcome == 1) 1 else 0
        case (1, 1) => if (outcome == 2) 1 else 0
        case _ => aceProb * markovChainAce(p1Points + 1, p2Points, outcome) + (1 - aceProb) * markovChainPoint(p1Points, p2Points, outcome)
      }
    }

    val winProb = markovChainAce(0, 0, outcome = 0)
    val loseProb = markovChainAce(0, 0, outcome = 1)
    val drawProb = markovChainAce(0, 0, outcome = 2)

    normalise(Tuple3(winProb, loseProb, drawProb))
  }

  def probByEquations(aceProb: Double, pointProb: Double): Tuple3[Double, Double, Double] = {

    val winProb = aceProb * aceProb + aceProb * (1 - aceProb) * pointProb + (1 - aceProb) * pointProb * aceProb + (1 - aceProb) * pointProb * (1 - aceProb) * pointProb
    val loseProb = (1 - aceProb) * (1 - pointProb) * (1 - aceProb) * (1 - pointProb)
    val drawProb = aceProb * (1 - aceProb) * (1 - pointProb) + (1 - aceProb) * pointProb * (1 - aceProb) * (1 - pointProb) + (1 - aceProb) * (1 - pointProb) * aceProb + (1 - aceProb) * (1 - pointProb) * (1 - aceProb) * pointProb

    normalise(Tuple3(winProb, loseProb, drawProb))

  }

  def prob3(aceProb: Double, pointProb: Double): Tuple3[Double, Double, Double] = {

    val winProb = pointProb * pointProb
    val loseProb = pow(1 - pointProb, 2)
    val drawProb = 2 * pointProb * (1 - pointProb)

    Tuple3(winProb, loseProb, drawProb)

  }

  def normalise(probs: Tuple3[Double, Double, Double]): Tuple3[Double, Double, Double] = {
    val sum = probs._1 + probs._2 + probs._3
    Tuple3(probs._1 / sum, probs._2 / sum, probs._3 / sum)

  }
}
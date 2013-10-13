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

  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Tuple3[Double, Double, Double] = {
    def markovChainPoint(p1Points: Int, p2Points: Int, outcome: Int): Double = {
      (p1Points, p2Points) match {
        case (2, 0) => if (outcome == 0) 1 else 0
        case (0, 2) => if (outcome == 1) 1 else 0
        case (1, 1) => if (outcome == 2) 1 else 0
        case (_, _) if (p1Points + p2Points) == 1 => p2PointProb * markovChainAce(p1Points, p2Points + 1, outcome) + (1 - p2PointProb) * markovChainAce(p1Points + 1, p2Points, outcome)
        case (0, 0) => p1PointProb * markovChainAce(p1Points + 1, p2Points, outcome) + (1 - p1PointProb) * markovChainAce(p1Points, p2Points + 1, outcome)
      }
    }

    def markovChainAce(p1Points: Int, p2Points: Int, outcome: Int): Double = {
      (p1Points, p2Points) match {
        case (2, 0) => if (outcome == 0) 1 else 0
        case (0, 2) => if (outcome == 1) 1 else 0
        case (1, 1) => if (outcome == 2) 1 else 0
        case (_, _) if (p1Points + p2Points) == 1 => p2AceProb * markovChainAce(p1Points, p2Points + 1, outcome) + (1 - p2AceProb) * markovChainPoint(p1Points, p2Points, outcome)
        case (0, 0) => p1AceProb * markovChainAce(p1Points + 1, p2Points, outcome) + (1 - p1AceProb) * markovChainPoint(p1Points, p2Points, outcome)
      }
    }

    val winProb = markovChainAce(0, 0, outcome = 0)
    val loseProb = markovChainAce(0, 0, outcome = 1)
    val drawProb = markovChainAce(0, 0, outcome = 2)

    normalise(Tuple3(winProb, loseProb, drawProb))
  }

  def normalise(probs: Tuple3[Double, Double, Double]): Tuple3[Double, Double, Double] = {
    val sum = probs._1 + probs._2 + probs._3
    Tuple3(probs._1 / sum, probs._2 / sum, probs._3 / sum)

  }
}
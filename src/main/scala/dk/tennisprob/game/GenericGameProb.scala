package dk.tennisprob.game

import dk.tennisprob.TennisProbFormulaCalc
import dk.tennisprob.game.deuce.GenericDeuceProb

object GenericGameProb extends GameProb {

  def prob(aceProb: Double, pointProb: Double): Double = {
   
    def markovChainPoint(p1Points: Int, p2Points: Int): Double = {
      (p1Points, p2Points) match {
        case (4, _) if p2Points < 3 => 1
        case (_, 4) if p1Points < 3 => 0
        case (3, 3) => GenericDeuceProb.prob(aceProb, pointProb)
        case _ => pointProb * markovChainAce(p1Points + 1, p2Points) + (1 - pointProb) * markovChainAce(p1Points, p2Points + 1)
      }
    }

    def markovChainAce(p1Points: Int, p2Points: Int): Double = {

      (p1Points, p2Points) match {
        case (4, _) if p2Points < 3 => 1
        case (_, 4) if p1Points < 3 => 0
        case (3, 3) => GenericDeuceProb.prob(aceProb, pointProb)
        case _ => aceProb * markovChainAce(p1Points + 1, p2Points) + (1 - aceProb) * markovChainPoint(p1Points, p2Points)
      }
    }

    markovChainAce(0, 0)
  }
}
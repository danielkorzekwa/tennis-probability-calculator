package dk.tennisprob.tiebreak

import dk.tennisprob.tiebreak.deuce.GenericTiebreakDeuceProb
import dk.tennisprob.TennisProbFormulaCalc

object GenericTiebreakProb extends TiebreakProb {

  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Double = {

    def markovChainPoint(p1Points: Int, p2Points: Int, player1OnServe: Boolean): Double = {
     val pointProb = (p1Points, p2Points) match {
        case (7, _) if p2Points < 6 => 1
        case (_, 7) if p1Points < 6 => 0
        case (6, 6) => {
          player1OnServe match {
            case true => GenericTiebreakDeuceProb.prob(p1AceProb, p1PointProb, p2AceProb, p2PointProb)
            case false => 1 - GenericTiebreakDeuceProb.prob(p2AceProb, p2PointProb, p1AceProb, p1PointProb)
          }
        }
        case _ => {
          player1OnServe match {
            case true => {
              if ((p1Points + p2Points) % 2 == 0) p1PointProb * markovChainAce(p1Points + 1, p2Points, !player1OnServe) + (1 - p1PointProb) * markovChainAce(p1Points, p2Points + 1, !player1OnServe)
              else p1PointProb * markovChainAce(p1Points + 1, p2Points, player1OnServe) + (1 - p1PointProb) * markovChainAce(p1Points, p2Points + 1, player1OnServe)
            }
            case false => {
              if ((p1Points + p2Points) % 2 == 0) p2PointProb * markovChainAce(p1Points, p2Points + 1, !player1OnServe) + (1 - p2PointProb) * markovChainAce(p1Points + 1, p2Points, !player1OnServe)
              else p2PointProb * markovChainAce(p1Points, p2Points + 1, player1OnServe) + (1 - p2PointProb) * markovChainAce(p1Points + 1, p2Points, player1OnServe)
            }
          }
        }

      }
     pointProb
    }

    def markovChainAce(p1Points: Int, p2Points: Int, player1OnServe: Boolean): Double = {
      
      val aceProb = (p1Points, p2Points) match {
        case (7, _) if p2Points < 6 => 1
        case (_, 7) if p1Points < 6 => 0
        case (6, 6) => {
          player1OnServe match {
            case true => GenericTiebreakDeuceProb.prob(p1AceProb, p1PointProb, p2AceProb, p2PointProb)
            case false => 1 - GenericTiebreakDeuceProb.prob(p2AceProb, p2PointProb, p1AceProb, p1PointProb)
          }

        }
        case _ => {
          player1OnServe match {
            case true => {
              if ((p1Points + p2Points) % 2 == 0) p1AceProb * markovChainAce(p1Points + 1, p2Points, !player1OnServe) + (1 - p1AceProb) * markovChainPoint(p1Points, p2Points, player1OnServe)
              else p1AceProb * markovChainAce(p1Points + 1, p2Points, player1OnServe) + (1 - p1AceProb) * markovChainPoint(p1Points, p2Points, player1OnServe)
            }
            case false => {
              if ((p1Points + p2Points) % 2 == 0) p2AceProb * markovChainAce(p1Points, p2Points + 1, !player1OnServe) + (1 - p2AceProb) * markovChainPoint(p1Points, p2Points, player1OnServe)
              else p2AceProb * markovChainAce(p1Points, p2Points + 1, player1OnServe) + (1 - p2AceProb) * markovChainPoint(p1Points, p2Points, player1OnServe)
            }
          }
        }
      }

      aceProb

    }

    markovChainAce(0, 0, player1OnServe = true)

  }
}
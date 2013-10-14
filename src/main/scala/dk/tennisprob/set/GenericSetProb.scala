package dk.tennisprob.set

import dk.tennisprob.TennisProbFormulaCalc
import dk.tennisprob.tiebreak.GenericTiebreakProb
import dk.tennisprob.game.GenericGameProb
import scala.annotation.tailrec

object GenericSetProb {

  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Double = {

    val p1GameProb = GenericGameProb.prob(p1AceProb, p1PointProb)
    val p2GameProb = GenericGameProb.prob(p2AceProb, p2PointProb)
    val p1TiebreakProb = GenericTiebreakProb.prob(p1AceProb, p1PointProb, p2AceProb, p2PointProb)
    val p2TiebreakProb = GenericTiebreakProb.prob(p2AceProb, p2PointProb, p1AceProb, p1PointProb)

    def markovChain(p1Points: Int, p2Points: Int, player1OnServe: Boolean): Double = {

      val setProb = (p1Points, p2Points) match {
        case (6, _) if p2Points < 5 => 1
        case (7, 5) => 1
        case (_, 6) if p1Points < 5 => 0
        case (5, 7) => 0
        case (6, 6) => {
          player1OnServe match {
            case true => p1TiebreakProb
            case false => 1 - p2TiebreakProb
          }
        }
        case _ => {
          player1OnServe match {
            case true => p1GameProb * markovChain(p1Points + 1, p2Points, !player1OnServe) + (1 - p1GameProb) * markovChain(p1Points, p2Points + 1, !player1OnServe)
            case false => p2GameProb * markovChain(p1Points, p2Points + 1, !player1OnServe) + (1 - p2GameProb) * markovChain(p1Points + 1, p2Points, !player1OnServe)
          }
        }
      }
      setProb

    }

    markovChain(0, 0, player1OnServe = true)
  }
}
package dk.tennisprob.tennismatch

import dk.tennisprob.set.GenericSetProb
import dk.tennisprob.TennisProbCalc.MatchTypeEnum._
import dk.tennisprob.TennisProbFormulaCalc

object GenericMatchProb extends MatchProb {

  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double, maxWinSets: Int): Double = {

    val p1SetProb = GenericSetProb.prob(p1AceProb, p1PointProb, p2AceProb, p2PointProb)
    val p2SetProb = GenericSetProb.prob(p2AceProb, p2PointProb, p1AceProb, p1PointProb)

    def markovChain(p1Points: Int, p2Points: Int, player1OnServe: Boolean): Double = {

      val setProb = (p1Points, p2Points) match {
        case (`maxWinSets`, _) => 1
        case (_, `maxWinSets`) => 0
        case _ => {
          player1OnServe match {
            case true => p1SetProb * markovChain(p1Points + 1, p2Points, !player1OnServe) + (1 - p1SetProb) * markovChain(p1Points, p2Points + 1, !player1OnServe)
            case false => p2SetProb * markovChain(p1Points, p2Points + 1, !player1OnServe) + (1 - p2SetProb) * markovChain(p1Points + 1, p2Points, !player1OnServe)
          }
        }
      }
      setProb

    }

    markovChain(0, 0, player1OnServe = true)
  }
}
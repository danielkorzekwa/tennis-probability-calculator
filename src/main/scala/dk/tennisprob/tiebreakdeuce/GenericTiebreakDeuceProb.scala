package dk.tennisprob.tiebreakdeuce

import dk.tennisprob.twopointsgame.GenericTwoPointsGameProb

object GenericTiebreakDeuceProb extends TiebreakDeuceProb {

  def prob(p1AceProb: Double, p1PointProb: Double, p2AceProb: Double, p2PointProb: Double): Double = {

    val (winProb, loseProb, drawProb) = GenericTwoPointsGameProb.prob(p1AceProb, p1PointProb, p2AceProb, p2PointProb)

    val deuceProb = winProb / (1 - drawProb)

    deuceProb
  }
}
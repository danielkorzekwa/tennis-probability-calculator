package dk.tennisprob.game.deuce

import scala.math._
import dk.tennisprob.twopointsgame.GenericTwoPointsGameProb

object GenericDeuceProb extends DeuceProb {

  def prob(aceProb: Double, pointProb: Double): Double = {

    val (winProb, loseProb, drawProb) = GenericTwoPointsGameProb.prob(aceProb, pointProb)

    val deuceProb = winProb / (1 - drawProb)

    deuceProb
  }
}
package dk.tennisprob.twopointsgame

import org.junit._
import Assert._

class GenericTwoPointsGameProbTest {

  @Test def ace_prob_is_zero {
    assertTuple3(Tuple3(0.25, 0.25, 0.5), GenericTwoPointsGameProb.prob(aceProb = 0, 0.5), 0.0001)

    assertTuple3(Tuple3(1.0, 0.0, 0.0), GenericTwoPointsGameProb.prob(aceProb = 0, 1), 0.0001)
    assertTuple3(Tuple3(0.0, 1.0, 0.0), GenericTwoPointsGameProb.prob(aceProb = 0, 0), 0.0001)
    assertTuple3(Tuple3(0.4899, 0.09, 0.42), GenericTwoPointsGameProb.prob(aceProb = 0, 0.7), 0.0001)
    assertTuple3(Tuple3(0.09, 0.4899, 0.42), GenericTwoPointsGameProb.prob(aceProb = 0, 0.3), 0.0001)
  }

  @Test def ace_prob_is_one {
    assertTuple3(Tuple3(1, 0, 0), GenericTwoPointsGameProb.prob(aceProb = 1, 0.5), 0.0001)

    assertTuple3(Tuple3(1.0, 0.0, 0.0), GenericTwoPointsGameProb.prob(aceProb = 1, 1), 0.0001)
    assertTuple3(Tuple3(1.0, 0, 0), GenericTwoPointsGameProb.prob(aceProb = 1, 0), 0.0001)
    assertTuple3(Tuple3(1, 0, 0), GenericTwoPointsGameProb.prob(aceProb = 1, 0.7), 0.0001)
    assertTuple3(Tuple3(1, 0, 0), GenericTwoPointsGameProb.prob(aceProb = 1, 0.3), 0.0001)
  }

  @Test def ace_prob_is_half {
    assertTuple3(Tuple3(0.5625, 0.0625, 0.375), GenericTwoPointsGameProb.prob(aceProb = 0.5, 0.5), 0.0001)

    assertTuple3(Tuple3(1.0, 0.0, 0.0), GenericTwoPointsGameProb.prob(aceProb = 0.5, 1), 0.0001)
    assertTuple3(Tuple3(0.25, 0.25, 0.5), GenericTwoPointsGameProb.prob(aceProb = 0.5, 0), 0.0001)
    assertTuple3(Tuple3(0.7224, 0.0225, 0.255), GenericTwoPointsGameProb.prob(aceProb = 0.5, 0.7), 0.0001)
    assertTuple3(Tuple3(0.4225, 0.1225, 0.4549), GenericTwoPointsGameProb.prob(aceProb = 0.5, 0.3), 0.0001)
  }

  @Test def ace_prob_is_0_7 {
    assertTuple3(Tuple3(0.7224, 0.0225, 0.255), GenericTwoPointsGameProb.prob(aceProb = 0.7, 0.5), 0.0001)

    assertTuple3(Tuple3(1.0, 0.0, 0.0), GenericTwoPointsGameProb.prob(aceProb = 0.7, 1), 0.0001)
    assertTuple3(Tuple3(0.4899, 0.09, 0.42), GenericTwoPointsGameProb.prob(aceProb = 0.7, 0), 0.0001)
    assertTuple3(Tuple3(0.8281, 0.0081, 0.1638), GenericTwoPointsGameProb.prob(aceProb = 0.7, 0.7), 0.0001)
    assertTuple3(Tuple3(0.6240, 0.0441, 0.3318), GenericTwoPointsGameProb.prob(aceProb = 0.7, 0.3), 0.0001)
  }

  private def assertTuple3(expected: Tuple3[Double, Double, Double], actual: Tuple3[Double, Double, Double], delta: Double) {
    assertEquals("expected/actual:%s/%s".format(expected, actual), expected._1, actual._1, delta)
    assertEquals("expected/actual:%s/%s", expected._2, actual._2, delta)
    assertEquals("expected/actual:%s/%s", expected._3, actual._3, delta)
  }
}
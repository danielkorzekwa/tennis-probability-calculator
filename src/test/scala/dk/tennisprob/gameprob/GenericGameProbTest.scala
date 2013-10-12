package dk.tennisprob.gameprob

import org.junit._
import Assert._

class GenericGameProbTest {

  @Test def ace_prob_is_zero {
    assertEquals(0.5, GenericGameProb.prob(aceProb = 0, 0.5), 0.0001)

    assertEquals(1, GenericGameProb.prob(aceProb = 0, 1), 0.0001)
    assertEquals(0, GenericGameProb.prob(aceProb = 0, 0), 0.0001)
    assertEquals(0.9007, GenericGameProb.prob(aceProb = 0, 0.7), 0.0001)
    assertEquals(0.0992, GenericGameProb.prob(aceProb = 0, 0.3), 0.0001)
  }

  @Test def ace_prob_is_one {
    assertEquals(1, GenericGameProb.prob(aceProb = 1, 0.5), 0.0001)

    assertEquals(1, GenericGameProb.prob(aceProb = 1, 1), 0.0001)
    assertEquals(1, GenericGameProb.prob(aceProb = 1, 0), 0.0001)
    assertEquals(1, GenericGameProb.prob(aceProb = 1, 0.7), 0.0001)
    assertEquals(1, GenericGameProb.prob(aceProb = 1, 0.3), 0.0001)
  }

  @Test def ace_prob_is_half {
    assertEquals(0.9492, GenericGameProb.prob(aceProb = 0.5, 0.5), 0.0001)

    assertEquals(1, GenericGameProb.prob(aceProb = 0.5, 1), 0.0001)
    assertEquals(0.5, GenericGameProb.prob(aceProb = 0.5, 0), 0.0001)
    assertEquals(0.9928, GenericGameProb.prob(aceProb = 0.5, 0.7), 0.0001)
    assertEquals(0.8296, GenericGameProb.prob(aceProb = 0.5, 0.3), 0.0001)
  }

  @Test def ace_prob_is_0_7 {
    assertEquals(0.9928, GenericGameProb.prob(aceProb = 0.7, 0.5), 0.0001)

    assertEquals(1, GenericGameProb.prob(aceProb = 0.7, 1), 0.0001)
    assertEquals(0.9007, GenericGameProb.prob(aceProb = 0.7, 0), 0.0001)
    assertEquals(0.9990, GenericGameProb.prob(aceProb = 0.7, 0.7), 0.0001)
    assertEquals(0.9737, GenericGameProb.prob(aceProb = 0.7, 0.3), 0.0001)
  }
}
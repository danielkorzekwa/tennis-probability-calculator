package dk.tennisprob.deuce

import org.junit._
import Assert._

class GenericDeuceProbTest {

  @Test def ace_prob_is_zero {
    assertEquals(0.5, GenericDeuceProb.prob(aceProb = 0, 0.5), 0.0001)

    assertEquals(1, GenericDeuceProb.prob(aceProb = 0, 1), 0.0001)
    assertEquals(0, GenericDeuceProb.prob(aceProb = 0, 0), 0.0001)
    assertEquals(0.8448, GenericDeuceProb.prob(aceProb = 0, 0.7), 0.0001)
    assertEquals(0.1551, GenericDeuceProb.prob(aceProb = 0, 0.3), 0.0001)
  }

  @Test def ace_prob_is_one {
    assertEquals(1, GenericDeuceProb.prob(aceProb = 1, 0.5), 0.0001)

    assertEquals(1, GenericDeuceProb.prob(aceProb = 1, 1), 0.0001)
    assertEquals(1, GenericDeuceProb.prob(aceProb = 1, 0), 0.0001)
    assertEquals(1, GenericDeuceProb.prob(aceProb = 1, 0.7), 0.0001)
    assertEquals(1, GenericDeuceProb.prob(aceProb = 1, 0.3), 0.0001)
  }

  @Test def ace_prob_is_half {
    assertEquals(0.9, GenericDeuceProb.prob(aceProb = 0.5, 0.5), 0.0001)

    assertEquals(1, GenericDeuceProb.prob(aceProb = 0.5, 1), 0.0001)
    assertEquals(0.5, GenericDeuceProb.prob(aceProb = 0.5, 0), 0.0001)
    assertEquals(0.9697, GenericDeuceProb.prob(aceProb = 0.5, 0.7), 0.0001)
    assertEquals(0.7752, GenericDeuceProb.prob(aceProb = 0.5, 0.3), 0.0001)
  }

  @Test def ace_prob_is_0_7 {
    assertEquals(0.9697, GenericDeuceProb.prob(aceProb = 0.7, 0.5), 0.0001)

    assertEquals(1, GenericDeuceProb.prob(aceProb = 0.7, 1), 0.0001)
    assertEquals(0.8448, GenericDeuceProb.prob(aceProb = 0.7, 0), 0.0001)
    assertEquals(0.9903, GenericDeuceProb.prob(aceProb = 0.7, 0.7), 0.0001)
    assertEquals(0.9340, GenericDeuceProb.prob(aceProb = 0.7, 0.3), 0.0001)
  }

}
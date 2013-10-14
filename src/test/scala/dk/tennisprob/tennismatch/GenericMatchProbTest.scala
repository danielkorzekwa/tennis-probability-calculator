package dk.tennisprob.tennismatch

import org.junit._
import Assert._

class GenericMatchProbTest {

  /**
   *  Tests for best of 3
   */

  @Test def best_of_3_player_always_win_or_lose {
    assertEquals(1, GenericMatchProb.prob(p1AceProb = 1, p1PointProb = 0.3, p2AceProb = 0.0, p2PointProb = 0.0, maxWinSets = 2), 0.0001)
    assertEquals(0, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.0, p2AceProb = 1.0, p2PointProb = 0.5, maxWinSets = 2), 0.0001)
  }

  @Test def best_of_3_even_chances {

    assertEquals(0.5, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.8, p2AceProb = 0.0, p2PointProb = 0.8, maxWinSets = 2), 0.0001)
    assertEquals(0.5, GenericMatchProb.prob(p1AceProb = 0.3, p1PointProb = 0.8, p2AceProb = 0.3, p2PointProb = 0.8, maxWinSets = 2), 0.0001)
  }

  @Test def best_of_3_player1_wins_more_than_player2 {
    assertEquals(0.8910, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.7, p2AceProb = 0.0, p2PointProb = 0.6, maxWinSets = 2), 0.0001)
    assertEquals(0.7741, GenericMatchProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7, maxWinSets = 2), 0.0001)
    assertEquals(0.1367, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.7, p2AceProb = 0, p2PointProb = 0.8, maxWinSets = 2), 0.0001)
  }

  @Test def best_of_3_player2_wins_more_than_player1 {
    assertEquals(0.1089, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.6, p2AceProb = 0.0, p2PointProb = 0.7, maxWinSets = 2), 0.0001)
    assertEquals(0.2258, GenericMatchProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6, maxWinSets = 2), 0.0001)
    assertEquals(0.8632, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.8, p2AceProb = 0, p2PointProb = 0.7, maxWinSets = 2), 0.0001)
  }

  @Test def best_of_3_who_serves_first {
    val p1Prob = GenericMatchProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7, maxWinSets = 2)
    val p2Prob = GenericMatchProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6, maxWinSets = 2)

    assertEquals(1, p1Prob + p2Prob, 0.0000001)
  }

  /**
   * Tests for best of 5
   */

  @Test def best_of_5_player_always_win_or_lose {
    assertEquals(1, GenericMatchProb.prob(p1AceProb = 1, p1PointProb = 0.3, p2AceProb = 0.0, p2PointProb = 0.0, maxWinSets = 3), 0.0001)
    assertEquals(0, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.0, p2AceProb = 1.0, p2PointProb = 0.5, maxWinSets = 3), 0.0001)
  }

  @Test def best_of_5_even_chances {

    assertEquals(0.5, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.8, p2AceProb = 0.0, p2PointProb = 0.8, maxWinSets = 3), 0.0001)
    assertEquals(0.5, GenericMatchProb.prob(p1AceProb = 0.3, p1PointProb = 0.8, p2AceProb = 0.3, p2PointProb = 0.8, maxWinSets = 3), 0.0001)
  }

  @Test def best_of_5_player1_wins_more_than_player2 {
    assertEquals(0.9380, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.7, p2AceProb = 0.0, p2PointProb = 0.6, maxWinSets = 3), 0.0001)
    assertEquals(0.8265, GenericMatchProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7, maxWinSets = 3), 0.0001)
    assertEquals(0.0857, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.7, p2AceProb = 0, p2PointProb = 0.8, maxWinSets = 3), 0.0001)
  }

  @Test def best_of_5_player2_wins_more_than_player1 {
    assertEquals(0.0619, GenericMatchProb.prob(p1AceProb = 0.0, p1PointProb = 0.6, p2AceProb = 0.0, p2PointProb = 0.7, maxWinSets = 3), 0.0001)
    assertEquals(0.1734, GenericMatchProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6, maxWinSets = 3), 0.0001)
    assertEquals(0.9142, GenericMatchProb.prob(p1AceProb = 0, p1PointProb = 0.8, p2AceProb = 0, p2PointProb = 0.7, maxWinSets = 3), 0.0001)
  }

  @Test def best_of_5_who_serves_first {
    val p1Prob = GenericMatchProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7, maxWinSets = 5)
    val p2Prob = GenericMatchProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6, maxWinSets = 5)

    assertEquals(1, p1Prob + p2Prob, 0.0000001)
  }
}
package dk.tennisprob.set

import org.junit._
import Assert._

class GenericSetProbTest {

  @Test def player_always_win_or_lose {
    assertEquals(1, GenericSetProb.prob(p1AceProb = 1, p1PointProb = 0.3, p2AceProb = 0.0, p2PointProb = 0.0), 0.0001)
    assertEquals(0, GenericSetProb.prob(p1AceProb = 0, p1PointProb = 0.0, p2AceProb = 1.0, p2PointProb = 0.5), 0.0001)
  }

  @Test def even_chances {

    assertEquals(0.5, GenericSetProb.prob(p1AceProb = 0.0, p1PointProb = 0.8, p2AceProb = 0.0, p2PointProb = 0.8), 0.0001)
    assertEquals(0.5, GenericSetProb.prob(p1AceProb = 0.3, p1PointProb = 0.8, p2AceProb = 0.3, p2PointProb = 0.8), 0.0001)
  }

  @Test def player1_wins_more_than_player2 {
    assertEquals(0.7948, GenericSetProb.prob(p1AceProb = 0.0, p1PointProb = 0.7, p2AceProb = 0.0, p2PointProb = 0.6), 0.0001)
    assertEquals(0.6922, GenericSetProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7), 0.0001)
    assertEquals(0.9998, GenericSetProb.prob(p1AceProb = 0, p1PointProb = 0.7, p2AceProb = 0, p2PointProb = 0.3), 0.0001)
  }

  @Test def player2_wins_more_than_player1 {
    assertEquals(0.2051, GenericSetProb.prob(p1AceProb = 0.0, p1PointProb = 0.6, p2AceProb = 0.0, p2PointProb = 0.7), 0.0001)
    assertEquals(0.3077, GenericSetProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6), 0.0001)
    assertEquals(0.0001677, GenericSetProb.prob(p1AceProb = 0, p1PointProb = 0.3, p2AceProb = 0, p2PointProb = 0.7), 0.000001)
  }

}
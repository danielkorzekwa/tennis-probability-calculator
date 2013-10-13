package dk.tennisprob.tiebreak

import org.junit._
import Assert._

class GenericTiebreakProbTest {

  @Test def player_always_win_or_lose {
    assertEquals(1, GenericTiebreakProb.prob(p1AceProb = 1, p1PointProb = 0.3, p2AceProb = 0.0, p2PointProb = 0.0), 0.0001)
    assertEquals(0, GenericTiebreakProb.prob(p1AceProb = 0, p1PointProb = 0.0, p2AceProb = 1.0, p2PointProb = 0.5), 0.0001)
  }

  @Test def even_chances {
    assertEquals(0.5, GenericTiebreakProb.prob(p1AceProb = 0.0, p1PointProb = 0.8, p2AceProb = 0.0, p2PointProb = 0.8), 0.0001)
    assertEquals(0.5, GenericTiebreakProb.prob(p1AceProb = 0.3, p1PointProb = 0.8, p2AceProb = 0.3, p2PointProb = 0.8), 0.0001)
  }

  @Test def player1_wins_more_than_player2 {
    assertEquals(0.6338, GenericTiebreakProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7), 0.0001)
    assertEquals(0.9491, GenericTiebreakProb.prob(p1AceProb = 0, p1PointProb = 0.7, p2AceProb = 0, p2PointProb = 0.3), 0.0001)
  }

  @Test def player2_wins_more_than_player1 {
    assertEquals(0.3661, GenericTiebreakProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6), 0.0001)
    assertEquals(0.0508, GenericTiebreakProb.prob(p1AceProb = 0, p1PointProb = 0.3, p2AceProb = 0, p2PointProb = 0.7), 0.0001)
  }

}
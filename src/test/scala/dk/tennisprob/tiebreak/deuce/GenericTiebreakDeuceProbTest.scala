package dk.tennisprob.tiebreak.deuce

import org.junit.Assert.assertEquals
import org.junit.Test

class GenericTiebreakDeuceProbTest {

  @Test def player_always_win_or_lose {
    assertEquals(1, GenericTiebreakDeuceProb.prob(p1AceProb = 1, p1PointProb = 0.3, p2AceProb = 0.0, p2PointProb = 0.0), 0.0001)
    assertEquals(0, GenericTiebreakDeuceProb.prob(p1AceProb = 0, p1PointProb = 0.0, p2AceProb = 1.0, p2PointProb = 0.0), 0.0001)
  }

  @Test def even_chances {
    assertEquals(0.5, GenericTiebreakDeuceProb.prob(p1AceProb = 0.3, p1PointProb = 0.8, p2AceProb = 0.3, p2PointProb = 0.8), 0.0001)
  }

  @Test def player1_wins_more_than_player2 {
    assertEquals(0.5966, GenericTiebreakDeuceProb.prob(p1AceProb = 0.5, p1PointProb = 0.6, p2AceProb = 0.1, p2PointProb = 0.7), 0.0001)
    assertEquals(0.8448, GenericTiebreakDeuceProb.prob(p1AceProb = 0, p1PointProb = 0.7, p2AceProb = 0, p2PointProb = 0.3), 0.0001)
  }

  @Test def player2_wins_more_than_player1 {
    assertEquals(0.4033, GenericTiebreakDeuceProb.prob(p1AceProb = 0.1, p1PointProb = 0.7, p2AceProb = 0.5, p2PointProb = 0.6), 0.0001)
    assertEquals(0.1551, GenericTiebreakDeuceProb.prob(p1AceProb = 0, p1PointProb = 0.3, p2AceProb = 0, p2PointProb = 0.7), 0.0001)
  }

}
package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GameOverDrawRefereeEvaluationTest {
    @Test
    void tells_game_that_current_match_is_draw() {
        Game game = mock(Game.class);

        RefereeEvaluation evaluation = new GameOverDrawRefereeEvaluation();

        evaluation.applyOn(game);

        verify(game).gameOverDraw();
    }
}
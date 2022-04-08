package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProceedToNextActionTest {
    private final Game game = mock(Game.class);
    private BoardGameRule evaluation;

    @BeforeEach
    void setUp() {
        evaluation = new ProceedToNextAction();
    }

    @Test
    void tells_game_to_proceed() {
        evaluation.applyOn(game);

        verify(game).proceed();
    }

    @Test
    void tells_game_to_switch_current_player() {
        evaluation.applyOn(game);

        verify(game).switchPlayer();
    }
}
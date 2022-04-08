package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RepeatActionTest {
    private final Game game = mock(Game.class);
    private BoardGameRule evaluation;

    @BeforeEach
    void setUp() {
        evaluation = new RepeatAction();
    }

    @Test
    void tells_game_to_repeat() {
        evaluation.applyOn(game);

        verify(game).repeat();
    }

    @Test
    void do_not_tell_game_to_switch_current_player() {
        evaluation.applyOn(game);

        verify(game, never()).switchPlayer();
    }
}
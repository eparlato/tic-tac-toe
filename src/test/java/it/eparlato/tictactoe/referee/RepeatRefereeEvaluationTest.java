package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepeatRefereeEvaluationTest {
    private final Game game = mock(Game.class);
    private RefereeEvaluation evaluation;

    @BeforeEach
    void setUp() {
        evaluation = new RepeatRefereeEvaluation();
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
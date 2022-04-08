package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RepeatActionTest {
    private final Game game = mock(Game.class);
    private final Board board = mock(Board.class);
    private final RepeatAction rule = new RepeatAction();

    @Test
    void is_satisfied_by_a_board_where_a_field_has_already_been_taken() {
        when(board.state()).thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_not_satisfied_by_a_board_where_a_field_has_been_taken() {
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        assertThat(rule.isSatisfiedBy(board)).isFalse();
    }

    @Test
    void tells_game_to_repeat() {
        rule.applyOn(game);

        verify(game).repeat();
    }

    @Test
    void do_not_tell_game_to_switch_current_player() {
        rule.applyOn(game);

        verify(game, never()).switchPlayer();
    }
}
package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.BoardState;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProceedToNextActionTest {
    private final Game game = mock(Game.class);
    private final Board board = mock(Board.class);
    private final ProceedToNextAction rule = new ProceedToNextAction();

    @Test
    void is_satisfied_by_a_board_where_a_field_has_been_taken() {
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_not_satisfied_by_a_board_where_a_field_has_not_been_taken() {
        when(board.state()).thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        assertThat(rule.isSatisfiedBy(board)).isFalse();
    }

    @Test
    void tells_game_to_proceed() {
        rule.applyOn(game);

        verify(game).proceed();
    }

    @Test
    void tells_game_to_switch_current_player() {
        rule.applyOn(game);

        verify(game).switchPlayer();
    }
}
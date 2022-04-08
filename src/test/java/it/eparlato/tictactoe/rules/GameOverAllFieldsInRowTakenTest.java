package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameOverAllFieldsInRowTakenTest {
    private final GameOverAllFieldsInRowTaken rule = new GameOverAllFieldsInRowTaken();
    private final Board board = mock(Board.class);

    @Test
    void is_satisfied_by_a_board_with_one_row_taken_by_a_player() {
        Mark[][] boardContentWithRowTakenByPlayerCross = {
                { Mark.EMPTY, Mark.EMPTY, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.NOUGHT },
                { Mark.CROSS, Mark.CROSS, Mark.CROSS },
        };

        when(board.content()).thenReturn(boardContentWithRowTakenByPlayerCross);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_not_satisfied_by_a_board_without_rows_taken_by_any_player() {
        Mark[][] boardContentWithoutRowsTakenByAnyone = {
                { Mark.CROSS, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.NOUGHT },
                { Mark.EMPTY, Mark.EMPTY, Mark.EMPTY },
        };

        when(board.content()).thenReturn(boardContentWithoutRowsTakenByAnyone);

        assertThat(rule.isSatisfiedBy(board)).isFalse();
    }

    @Test
    void tells_game_that_a_player_got_a_row() {
        Game game = mock(Game.class);

        rule.applyOn(game);

        verify(game).gameOverAllFieldsTakenByPlayer();
    }
}
package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GameOverAllFieldsInColumnTakenTest {
    private final Board board = mock(Board.class);
    private final Game game = mock(Game.class);
    private final BoardGameRule rule = new GameOverAllFieldsInColumnTaken();

    @Test
    void is_satisfied_by_a_board_with_one_column_taken_by_a_player() {
        Mark[][] boardContentWithColumnTakenByPlayerCross = {
                { Mark.EMPTY, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.CROSS, Mark.EMPTY },
        };

        when(board.content()).thenReturn(boardContentWithColumnTakenByPlayerCross);
        
        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_not_satisfied_by_a_board_with_no_columns_taken_by_any_player() {
        Mark[][] boardContentWithNoColumnsTakenByAnyPlayer = {
                { Mark.EMPTY, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.CROSS },
                { Mark.NOUGHT, Mark.CROSS, Mark.EMPTY },
        };

        when(board.content()).thenReturn(boardContentWithNoColumnsTakenByAnyPlayer);

        assertThat(rule.isSatisfiedBy(board)).isFalse();
    }

    @Test
    void tells_game_that_one_player_got_a_column() {
        rule.applyOn(game);

        verify(game).gameOverColumnTakenByPlayer();
    }
}

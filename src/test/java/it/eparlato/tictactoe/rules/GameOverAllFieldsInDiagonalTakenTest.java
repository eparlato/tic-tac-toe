package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameOverAllFieldsInDiagonalTakenTest {
    private final Board board = mock(Board.class);
    private final Game game = mock(Game.class);
    private final BoardGameRule rule = new GameOverAllFieldsInDiagonalTaken();

    @Test
    void is_satisfied_by_a_board_with_a_upper_left_lower_right_diagonal_taken_by_a_player() {
        Mark[][] boardContentWithUpperLeftBottomRightDiagonalTakenByPlayer = {
                {Mark.CROSS, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.CROSS, Mark.EMPTY},
                {Mark.NOUGHT, Mark.NOUGHT, Mark.CROSS},
        };
        when(board.content()).thenReturn(boardContentWithUpperLeftBottomRightDiagonalTakenByPlayer);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_satisfied_by_a_board_with_a_upper_right_lower_left_diagonal_taken_by_a_player() {
        Mark[][] boardContentWithUpperRightBottomLeftDiagonalTakenByPlayer = {
                {Mark.EMPTY, Mark.CROSS, Mark.NOUGHT},
                {Mark.EMPTY, Mark.NOUGHT, Mark.EMPTY},
                {Mark.NOUGHT, Mark.CROSS, Mark.CROSS},
        };
        when(board.content()).thenReturn(boardContentWithUpperRightBottomLeftDiagonalTakenByPlayer);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void tells_game_that_a_player_got_a_diagonal() {
        rule.applyOn(game);

        verify(game).gameOverDiagonalTakenByPlayer();
    }
}
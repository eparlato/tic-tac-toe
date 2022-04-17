package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameOverAllFieldsTakenTest {
    private final BoardGameRule rule = new GameOverAllFieldsTaken();
    private final Board board = mock(Board.class);
    private final Game game = mock(Game.class);

    @Test
    void is_satisfied_by_a_board_with_all_fields_taken() {
        Mark[][] boardContentWithAllFieldsTaken = {
                {Mark.NOUGHT, Mark.CROSS, Mark.CROSS},
                {Mark.CROSS, Mark.CROSS, Mark.NOUGHT},
                {Mark.NOUGHT, Mark.NOUGHT, Mark.CROSS}
        };

        when(board.content()).thenReturn(boardContentWithAllFieldsTaken);

        assertThat(rule.isSatisfiedBy(board)).isTrue();
    }

    @Test
    void is_not_satisfied_by_a_board_with_at_least_one_empty_field() {
        Mark[][] boardContentWithOnlyOneEmptyField = {
                {Mark.NOUGHT, Mark.CROSS, Mark.CROSS},
                {Mark.CROSS, Mark.CROSS, Mark.NOUGHT},
                {Mark.NOUGHT, Mark.EMPTY, Mark.CROSS}
        };

        when(board.content()).thenReturn(boardContentWithOnlyOneEmptyField);

        assertThat(rule.isSatisfiedBy(board)).isFalse();
    }

    @Test
    void tells_the_game_that_all_fields_have_been_taken() {
        rule.applyOn(game);

        verify(game).gameOverAllFieldsTaken();
    }
}
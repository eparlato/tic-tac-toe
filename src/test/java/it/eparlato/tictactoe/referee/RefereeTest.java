package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Mark;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RefereeTest {
    private final Board board = mock(Board.class);
    private final Referee referee = new Referee();
    private final Mark[][] emptyBoardContent = {
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
    };

    @Test
    void returns_a_proceed_evaluation_when_a_field_has_been_taken_on_a_board() {
        when(board.content()).thenReturn(emptyBoardContent);
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        referee.check(board);

        assertThat(referee.evaluation()).isInstanceOf(ProceedToNextAction.class);
    }

    @Test
    void returns_a_repeat_evaluation_when_a_field_has_been_already_taken_on_a_board() {
        when(board.content()).thenReturn(emptyBoardContent);
        when(board.state()).thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        referee.check(board);

        assertThat(referee.evaluation()).isInstanceOf(RepeatAction.class);
    }

    @Test
    void returns_a_game_over_all_fields_taken_in_row() {
        Mark[][] boardWithRowTakenByPlayer = {
                { Mark.EMPTY, Mark.EMPTY, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.NOUGHT },
                { Mark.CROSS, Mark.CROSS, Mark.CROSS },
        };

        when(board.content()).thenReturn(boardWithRowTakenByPlayer);

        referee.check(board);

        assertThat(referee.evaluation()).isInstanceOf(GameOverAllFieldsInRowTaken.class);
    }
}
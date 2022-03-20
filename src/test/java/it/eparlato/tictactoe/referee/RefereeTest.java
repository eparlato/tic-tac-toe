package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RefereeTest {
    private final Board board = mock(Board.class);
    private final Referee referee = new Referee();

    @Test
    void returns_a_proceed_evaluation_when_a_field_has_been_taken_on_a_board() {
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        referee.check(board);

        assertThat(referee.evaluation()).isInstanceOf(ProceedRefereeEvaluation.class);
    }

    @Test
    void returns_a_repeat_evaluation_when_a_field_has_been_already_taken_on_a_board() {
        when(board.state()).thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        referee.check(board);

        assertThat(referee.evaluation()).isInstanceOf(RepeatRefereeEvaluation.class);
    }
}
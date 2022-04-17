package it.eparlato.tictactoe.board;

import it.eparlato.tictactoe.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void is_empty_when_created() {
        Mark[][] emptyBoardContent =
                {
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
                };

        assertThat(board.state()).isEqualTo(BoardState.EMPTY);
        assertThat(board.content()).isEqualTo(emptyBoardContent);
    }

    @Test
    void marks_a_field_with_a_mark_if_the_field_is_not_already_taken() {
        Mark[][] boardWithUpperLeftFieldMarkWithCross =
                {
                        {Mark.CROSS, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
                };

        board.takeField(new FieldCoordinates(0, 0), new Player(Mark.CROSS));

        assertThat(board.state()).isEqualTo(BoardState.FIELD_TAKEN);
        assertThat(board.content()).isEqualTo(boardWithUpperLeftFieldMarkWithCross);
    }

    @Test
    void do_not_mark_a_field_already_taken_by_another_player() {
        Mark[][] boardWithLowerLeftFieldMarkWithNought =
                {
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.NOUGHT, Mark.EMPTY}
                };


        board.takeField(new FieldCoordinates(2,1), new Player(Mark.NOUGHT));
        board.takeField(new FieldCoordinates(2,1), new Player(Mark.CROSS));

        assertThat(board.state()).isEqualTo(BoardState.FIELD_ALREADY_TAKEN);
        assertThat(board.content()).isEqualTo(boardWithLowerLeftFieldMarkWithNought);
    }

    @Test
    void do_not_mark_a_field_already_taken_by_the_same_player() {
        Mark[][] boardWithLowerLeftFieldMarkWithNought =
                {
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                        {Mark.EMPTY, Mark.NOUGHT, Mark.EMPTY}
                };


        board.takeField(new FieldCoordinates(2,1), new Player(Mark.NOUGHT));
        board.takeField(new FieldCoordinates(2,1), new Player(Mark.NOUGHT));

        assertThat(board.state()).isEqualTo(BoardState.FIELD_ALREADY_TAKEN);
        assertThat(board.content()).isEqualTo(boardWithLowerLeftFieldMarkWithNought);
    }
}
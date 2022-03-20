package it.eparlato.tictactoe;

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
        String[][] emptyBoardContent =
                    {
                        {"-", "-", "-"},
                        {"-", "-", "-"},
                        {"-", "-", "-"}
                    };

        assertThat(board.state()).isEqualTo(BoardState.EMPTY);
        assertThat(board.content()).isEqualTo(emptyBoardContent);
    }
}
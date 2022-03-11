package it.eparlato.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GameTest {
    private Board board = mock(Board.class);
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(board);
    }

    @Test
    void starts_with_a_new_game_state() {
        assertThat(game.state()).isEqualTo(GameState.NEW_GAME);
    }

    @Test
    void orchestrates_take_field_flow() {
        FieldCoordinates fieldCoordinates = new FieldCoordinates(0, 0);

        game.takeField(fieldCoordinates);

        verify(board).takeField(fieldCoordinates);
    }
}
package it.eparlato.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameTest {
    private Board board = mock(Board.class);
    private Game game;
    public static final FieldCoordinates FIELD_COORDINATES = new FieldCoordinates(0, 0);

    @BeforeEach
    void setUp() {
        game = new Game(board);
    }

    @Test
    void starts_with_a_new_game_state() {
        assertThat(game.state()).isEqualTo(GameState.NEW);
    }

    @Test
    void orchestrates_take_field_flow() {
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        game.takeField(FIELD_COORDINATES);

        verify(board).takeField(FIELD_COORDINATES);
    }

    @Test
    void sets_a_state_when_a_field_is_taken_on_the_board() {
        when(board.state()).thenReturn(BoardState.FIELD_TAKEN);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.state()).isEqualTo(GameState.PROCEEDING);
    }

    @Test
    void sets_a_state_when_a_field_is_already_taken_on_the_board() {

        when(board.state())
                .thenReturn(BoardState.FIELD_TAKEN)
                .thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        game.takeField(FIELD_COORDINATES);
        game.takeField(FIELD_COORDINATES);

        assertThat(game.state()).isEqualTo(GameState.REPEATING);
    }

    @Test
    void switches_player_when_a_field_is_taken_on_the_board() {
        FieldCoordinates differentCoordinates = new FieldCoordinates(0, 1);

        when(board.state())
                .thenReturn(BoardState.FIELD_TAKEN)
                .thenReturn(BoardState.FIELD_TAKEN);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.currentPlayer()).isEqualTo(Player.NOUGHT);

        game.takeField(differentCoordinates);

        assertThat(game.currentPlayer()).isEqualTo(Player.CROSS);
    }

    @Test
    void do_not_switch_player_if_a_field_is_already_taken_on_the_board() {
        when(board.state())
                .thenReturn(BoardState.FIELD_ALREADY_TAKEN);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.currentPlayer()).isEqualTo(Player.CROSS);
    }
}
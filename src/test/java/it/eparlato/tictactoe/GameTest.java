package it.eparlato.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameTest {
    private final Board board = mock(Board.class);
    private final Referee referee = mock(Referee.class);
    private Game game;
    public static final FieldCoordinates FIELD_COORDINATES = new FieldCoordinates(0, 0);

    @BeforeEach
    void setUp() {
        game = new Game(board, referee);
    }

    @Test
    void starts_with_a_new_game_state() {
        assertThat(game.state()).isEqualTo(GameState.NEW);
    }

    @Test
    void orchestrates_take_field_flow() {
        when(referee.evaluation()).thenReturn(RefereeEvaluation.PROCEED);

        game.takeField(FIELD_COORDINATES);

        verify(board).takeField(FIELD_COORDINATES, Player.CROSS);
        verify(referee).check(board);
    }

    @Test
    void sets_state_to_proceeding_when_referee_says_proceed() {
        when(referee.evaluation()).thenReturn(RefereeEvaluation.PROCEED);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.state()).isEqualTo(GameState.PROCEEDING);
    }


    @Test
    void sets_state_to_repeating_when_referee_says_proceed() {
        when(referee.evaluation()).thenReturn(RefereeEvaluation.PROCEED).thenReturn(RefereeEvaluation.REPEAT);

        game.takeField(FIELD_COORDINATES);
        game.takeField(FIELD_COORDINATES);

        assertThat(game.state()).isEqualTo(GameState.REPEATING);
    }

    @Test
    void switches_player_when_referee_says_proceeding() {
        FieldCoordinates differentCoordinates = new FieldCoordinates(0, 1);

        when(referee.evaluation()).thenReturn(RefereeEvaluation.PROCEED);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.currentPlayer()).isEqualTo(Player.NOUGHT);

        game.takeField(differentCoordinates);

        assertThat(game.currentPlayer()).isEqualTo(Player.CROSS);
    }

    @Test
    void do_not_switch_player_if_referee_says_repeat() {
        when(referee.evaluation()).thenReturn(RefereeEvaluation.REPEAT);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.currentPlayer()).isEqualTo(Player.CROSS);
    }

    @Test
    void sets_state_to_draw_game_over_when_referee_says_all_fields_have_been_taken() {
        when(referee.evaluation()).thenReturn(RefereeEvaluation.ALL_FIELDS_TAKEN);

        game.takeField(FIELD_COORDINATES);

        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_DRAW);
    }


}
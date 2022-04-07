package it.eparlato.tictactoe;

import it.eparlato.tictactoe.referee.Referee;
import it.eparlato.tictactoe.referee.RefereeEvaluation;
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
        RefereeEvaluation refereeEvaluation = mock(RefereeEvaluation.class);
        when(referee.evaluation()).thenReturn(refereeEvaluation);

        game.takeField(FIELD_COORDINATES);

        verify(referee).check(board);
        verify(refereeEvaluation).applyOn(game);
    }

    @Test
    void switches_the_current_player() {

        game.switchPlayer();

        assertThat(game.currentPlayer()).isEqualTo(new Player(Mark.NOUGHT));

        game.switchPlayer();

        assertThat(game.currentPlayer()).isEqualTo(new Player((Mark.CROSS)));
    }

    @Test
    void exposes_methods_that_change_its_state() {
        game.gameOverDraw();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_DRAW);

        game.repeat();
        assertThat(game.state()).isEqualTo(GameState.REPEATING);

        game.proceed();
        assertThat(game.state()).isEqualTo(GameState.PROCEEDING);

        game.gameOverAllFieldsTakenByPlayer();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW);
    }
}
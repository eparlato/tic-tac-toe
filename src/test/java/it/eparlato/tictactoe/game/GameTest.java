package it.eparlato.tictactoe.game;

import it.eparlato.tictactoe.Referee;
import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.FieldCoordinates;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.rules.BoardGameRule;
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
        BoardGameRule boardGameRule = mock(BoardGameRule.class);
        when(referee.validGameRule()).thenReturn(boardGameRule);

        game.takeField(FIELD_COORDINATES);

        verify(referee).check(board);
        verify(boardGameRule).applyOn(game);
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
        game.gameOverAllFieldsTaken();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_DRAW);

        game.repeat();
        assertThat(game.state()).isEqualTo(GameState.REPEATING);

        game.proceed();
        assertThat(game.state()).isEqualTo(GameState.PROCEEDING);

        game.gameOverRowTakenByPlayer();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW);

        game.gameOverColumnTakenByPlayer();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_COLUMN);

        game.gameOverDiagonalTakenByPlayer();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_DIAGONAL);

        game.gameOverAllFieldsTaken();
        assertThat(game.state()).isEqualTo(GameState.GAME_OVER_DRAW);
    }

    @Test
    void knows_when_is_over() {
        game = new Game(board, referee);
        assertThat(game.isOver()).isFalse();

        game.gameOverAllFieldsTaken();
        assertThat(game.isOver()).isTrue();

        game.gameOverRowTakenByPlayer();
        assertThat(game.isOver()).isTrue();

        game.gameOverDiagonalTakenByPlayer();
        assertThat(game.isOver()).isTrue();

        game.repeat();
        assertThat(game.isOver()).isFalse();

        game.gameOverColumnTakenByPlayer();
        assertThat(game.isOver()).isTrue();

        game.proceed();
        assertThat(game.isOver()).isFalse();
    }
}
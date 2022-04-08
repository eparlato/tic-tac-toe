package it.eparlato.tictactoe;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.FieldCoordinates;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;
import it.eparlato.tictactoe.game.GameSnapshot;
import it.eparlato.tictactoe.game.GameState;
import it.eparlato.tictactoe.game.Player;
import it.eparlato.tictactoe.rules.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameAcceptanceTest {
    private Game game;
    public static final Player PLAYER_CROSS = new Player(Mark.CROSS);
    public static final Player PLAYER_NOUGHT = new Player(Mark.NOUGHT);

    @BeforeEach
    void setUp() {
        Board board = new Board();

        List<BoardGameRule> gameOverRules = setupGameOverRules();
        List<BoardGameRule> gameFlowRules = setupGameFlowRules();
        Referee referee = new Referee(gameOverRules, gameFlowRules);

        game = new Game(board, referee);
    }

    @Test
    void a_game_has_nine_fields_in_a_3x3_grid() {
        Mark[][] empty3x3Board = {
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
        };

        GameSnapshot snapshot = game.snapshot();

        assertThat(snapshot.boardContent()).isEqualTo(empty3x3Board);
    }

    @Test
    void there_are_two_players_in_the_game_X_and_O() {

        assertThat(getCurrentPlayer()).isEqualTo(PLAYER_CROSS);

        takeFieldAtCoordinates(0, 0);

        assertThat(getCurrentPlayer()).isEqualTo(PLAYER_NOUGHT);
    }

    @Test
    void a_player_can_take_a_field_if_not_already_taken() {
        takeFieldAtCoordinates(1, 0);
        Player aPlayer = getCurrentPlayer();

        takeFieldAtCoordinates(1, 1);

        Player aDifferentPlayer = getCurrentPlayer();

        assertThat(aPlayer).isNotEqualTo(aDifferentPlayer);
        assertThat(game.snapshot().gameState()).isEqualTo(GameState.PROCEEDING);
    }

    @Test
    void a_game_is_over_when_all_fields_in_a_row_are_taken_by_a_player() {
        takeFieldAtCoordinates(1, 0);
        takeFieldAtCoordinates(2, 0);
        takeFieldAtCoordinates(1, 1);
        takeFieldAtCoordinates(2, 1);
        takeFieldAtCoordinates(1, 2);

        GameSnapshot snapshot = game.snapshot();
        assertThat(snapshot.gameState()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW);
        assertThat(snapshot.currentPlayer()).isEqualTo(PLAYER_CROSS);
    }

    @Test
    void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player() {
        takeFieldAtCoordinates(0, 1);
        takeFieldAtCoordinates(0, 0);
        takeFieldAtCoordinates(1, 1);
        takeFieldAtCoordinates(1, 0);
        takeFieldAtCoordinates(2, 2);
        takeFieldAtCoordinates(2, 0);

        GameSnapshot snapshot = game.snapshot();
        assertThat(snapshot.gameState()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_COLUMN);
        assertThat(snapshot.currentPlayer()).isEqualTo(PLAYER_NOUGHT);
    }

    private List<BoardGameRule> setupGameOverRules() {
        List<BoardGameRule> gameOverRules = new ArrayList<>();
        gameOverRules.add(new GameOverAllFieldsInRowTaken());
        gameOverRules.add(new GameOverAllFieldsInColumnTaken());
        return gameOverRules;
    }

    private List<BoardGameRule> setupGameFlowRules() {
        List<BoardGameRule> gameFlowRules = new ArrayList<>();
        gameFlowRules.add(new ProceedToNextAction());
        gameFlowRules.add(new RepeatAction());
        return gameFlowRules;
    }

    private void takeFieldAtCoordinates(int rowIndex, int columnIndex) {
        game.takeField(new FieldCoordinates(rowIndex, columnIndex));
    }

    private Player getCurrentPlayer() {
        GameSnapshot snapshot = game.snapshot();
        return snapshot.currentPlayer();
    }
}

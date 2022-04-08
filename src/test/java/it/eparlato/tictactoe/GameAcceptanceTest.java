package it.eparlato.tictactoe;

import it.eparlato.tictactoe.referee.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameAcceptanceTest {
    private Game game;

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
        Player playerCross = new Player(Mark.CROSS);
        Player playerNought = new Player(Mark.NOUGHT);

        assertThat(getCurrentPlayer()).isEqualTo(playerCross);

        game.takeField(new FieldCoordinates(0,0));

        assertThat(getCurrentPlayer()).isEqualTo(playerNought);
    }

    @Test
    void a_player_can_take_a_field_if_not_already_taken() {
        game.takeField(new FieldCoordinates(1,0));
        Player aPlayer = getCurrentPlayer();

        game.takeField(new FieldCoordinates(1,1));

        Player aDifferentPlayer = getCurrentPlayer();

        assertThat(aPlayer).isNotEqualTo(aDifferentPlayer);
        assertThat(game.snapshot().gameState()).isEqualTo(GameState.PROCEEDING);
    }

    @Test
    void a_game_is_over_when_all_fields_in_a_row_are_taken_by_a_player() {
        game.takeField(new FieldCoordinates(1, 0));
        game.takeField(new FieldCoordinates(2, 0));
        game.takeField(new FieldCoordinates(1, 1));
        game.takeField(new FieldCoordinates(2, 1));
        game.takeField(new FieldCoordinates(1, 2));

        assertThat(game.snapshot().gameState()).isEqualTo(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW);
    }

    private List<BoardGameRule> setupGameOverRules() {
        List<BoardGameRule> gameOverRules = new ArrayList<>();
        gameOverRules.add(new GameOverAllFieldsInRowTaken());
        return gameOverRules;
    }

    private List<BoardGameRule> setupGameFlowRules() {
        List<BoardGameRule> gameFlowRules = new ArrayList<>();
        gameFlowRules.add(new ProceedToNextAction());
        gameFlowRules.add(new RepeatAction());
        return gameFlowRules;
    }

    private Player getCurrentPlayer() {
        GameSnapshot snapshot = game.snapshot();
        return snapshot.currentPlayer();
    }
}

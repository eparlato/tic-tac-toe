package it.eparlato.tictactoe;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.rules.BoardGameRule;
import it.eparlato.tictactoe.rules.GameOverAllFieldsInRowTaken;
import it.eparlato.tictactoe.rules.ProceedToNextAction;
import it.eparlato.tictactoe.rules.RepeatAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RefereeTest {
    private List<BoardGameRule> gameOverRules;
    private List<BoardGameRule> gameFlowRules;
    private final Board board = new Board();

    @BeforeEach
    void setUp() {
        gameOverRules = new ArrayList<>();
        gameFlowRules = new ArrayList<>();
    }

    @Test
    void set_the_first_valid_game_over_rule_as_valid_rule() {
        BoardGameRule gameOverAllFieldsInRowTaken = mock(GameOverAllFieldsInRowTaken.class);

        addToGameOverRules(gameOverAllFieldsInRowTaken);

        when(gameOverAllFieldsInRowTaken.isSatisfiedBy(board)).thenReturn(true);

        Referee referee = new Referee(gameOverRules, gameFlowRules);

        referee.check(board);

        assertThat(referee.validGameRule()).isInstanceOf(GameOverAllFieldsInRowTaken.class);
    }

    @Test
    void set_the_first_valid_game_flow_rule_as_valid_rule() {
        BoardGameRule proceedToNextAction = mock(ProceedToNextAction.class);
        BoardGameRule repeatAction = mock(RepeatAction.class);

        addToGameFlowRules(proceedToNextAction);
        addToGameFlowRules(repeatAction);

        when(proceedToNextAction.isSatisfiedBy(board)).thenReturn(false);
        when(repeatAction.isSatisfiedBy(board)).thenReturn(true);

        Referee referee = new Referee(gameOverRules, gameFlowRules);

        referee.check(board);

        assertThat(referee.validGameRule()).isInstanceOf(RepeatAction.class);
    }

    @Test
    void evaluates_game_over_rules_first() {
        BoardGameRule gameOverAllFieldsInRowTaken = mock(GameOverAllFieldsInRowTaken.class);
        BoardGameRule proceedToNextAction = mock(ProceedToNextAction.class);
        BoardGameRule repeatAction = mock(RepeatAction.class);

        addToGameOverRules(gameOverAllFieldsInRowTaken);
        addToGameFlowRules(proceedToNextAction);
        addToGameFlowRules(repeatAction);

        when(gameOverAllFieldsInRowTaken.isSatisfiedBy(board)).thenReturn(true);
        when(proceedToNextAction.isSatisfiedBy(board)).thenReturn(true);
        when(repeatAction.isSatisfiedBy(board)).thenReturn(false);

        Referee referee = new Referee(gameOverRules, gameFlowRules);

        referee.check(board);

        assertThat(referee.validGameRule()).isInstanceOf(GameOverAllFieldsInRowTaken.class);
    }

    private void addToGameOverRules(BoardGameRule boardGameRule) {
        gameOverRules.add(boardGameRule);
    }

    private void addToGameFlowRules(BoardGameRule boardGameRule) {
        gameFlowRules.add(boardGameRule);
    }
}
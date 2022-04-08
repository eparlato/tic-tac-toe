package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;

import java.util.List;

public class Referee {
    private BoardGameRule validGameRule;
    private final List<BoardGameRule> gameOverRules;
    private final List<BoardGameRule> gameFlowRules;

    public Referee(List<BoardGameRule> gameOverRules, List<BoardGameRule> gameFlowRules) {
        this.gameOverRules = gameOverRules;
        this.gameFlowRules = gameFlowRules;
    }

    public void check(Board board) {
        for (BoardGameRule gameOverRule : gameOverRules) {
            if (gameOverRule.isSatisfiedBy(board)) {
                this.validGameRule = gameOverRule;
                return;
            }
        }

        for (BoardGameRule gameFlowRule : gameFlowRules) {
            if (gameFlowRule.isSatisfiedBy(board)) {
                this.validGameRule = gameFlowRule;
                return;
            }
        }
    }

    public BoardGameRule validGameRule() {
        return validGameRule;
    }
}

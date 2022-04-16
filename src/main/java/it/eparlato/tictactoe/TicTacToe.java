package it.eparlato.tictactoe;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.game.Game;
import it.eparlato.tictactoe.gameloop.*;
import it.eparlato.tictactoe.rules.*;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    public TicTacToe(ApplicationInput applicationInput, ApplicationOutput applicationOutput) {
        List<BoardGameRule> gameOverRules = setupGameOverRules();
        List<BoardGameRule> gameFlowRules = setupGameFlowRules();

        Game game = new Game(new Board(), new Referee(gameOverRules, gameFlowRules));
        GameLoop gameLoop = new GameLoop(applicationInput, applicationOutput);

        gameLoop.start(game);
    }

    public static void main(String[] args) {
        new TicTacToe(new ConsoleApplicationInput(System.in), new ConsoleApplicationOutput(System.out));
    }

    private List<BoardGameRule> setupGameOverRules() {
        List<BoardGameRule> gameOverRules = new ArrayList<>();
        gameOverRules.add(new GameOverAllFieldsInRowTaken());
        gameOverRules.add(new GameOverAllFieldsInColumnTaken());
        gameOverRules.add(new GameOverAllFieldsInDiagonalTaken());
        gameOverRules.add(new GameOverAllFieldsTaken());
        return gameOverRules;
    }

    private List<BoardGameRule> setupGameFlowRules() {
        List<BoardGameRule> gameFlowRules = new ArrayList<>();
        gameFlowRules.add(new ProceedToNextAction());
        gameFlowRules.add(new RepeatAction());
        return gameFlowRules;
    }
}

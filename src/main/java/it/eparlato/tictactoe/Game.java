package it.eparlato.tictactoe;

import it.eparlato.tictactoe.referee.Referee;
import it.eparlato.tictactoe.referee.RefereeEvaluation;

public class Game
{
    private final Board board;
    private final Referee referee;
    private GameState state = GameState.NEW;
    private Player playerCross = new Player(Mark.CROSS);
    private Player playerNought = new Player(Mark.NOUGHT);
    private Player currentPlayer = playerCross;

    public Game(Board board, Referee referee) {
        this.board = board;
        this.referee = referee;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates, currentPlayer);

        referee.check(board);

        RefereeEvaluation refereeEvaluation = referee.evaluation();

        refereeEvaluation.applyOn(this);
    }

    public void gameOverDraw() {
        state = GameState.GAME_OVER_DRAW;
    }

    public void proceed() {
        state = GameState.PROCEEDING;
    }

    public void repeat() {
        state = GameState.REPEATING;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerCross ? playerNought : playerCross);
    }

    public GameState state() {
        return state;
    }
}

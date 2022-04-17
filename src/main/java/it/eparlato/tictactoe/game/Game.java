package it.eparlato.tictactoe.game;

import it.eparlato.tictactoe.Referee;
import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.FieldCoordinates;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.rules.BoardGameRule;

public class Game
{
    private final Board board;
    private final Referee referee;
    private GameState state = GameState.NEW;
    private final Player playerCross = new Player(Mark.CROSS);
    private final Player playerNought = new Player(Mark.NOUGHT);
    private Player currentPlayer = playerCross;

    public Game(Board board, Referee referee) {
        this.board = board;
        this.referee = referee;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates, currentPlayer);

        referee.check(board);

        BoardGameRule boardGameRule = referee.validGameRule();

        boardGameRule.applyOn(this);
    }

    public void gameOverAllFieldsTaken() {
        state = GameState.GAME_OVER_DRAW;
    }

    public void proceed() {
        state = GameState.PROCEEDING;
    }

    public void repeat() {
        state = GameState.REPEATING;
    }

    public void gameOverRowTakenByPlayer() {
        state = GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW;
    }

    public void gameOverColumnTakenByPlayer() {
        state = GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_COLUMN;
    }

    public void gameOverDiagonalTakenByPlayer() {
        this.state = GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_DIAGONAL;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerCross ? playerNought : playerCross);
    }

    public GameState state() {
        return state;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public Mark[][] boardContent() {
        return board.content();
    }

    public boolean isOver() {
        return state.equals(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_COLUMN)
                || state.equals(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_DIAGONAL)
                || state.equals(GameState.GAME_OVER_ALL_FIELDS_TAKEN_ON_ROW)
                || state.equals(GameState.GAME_OVER_DRAW);
    }
}

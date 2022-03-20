package it.eparlato.tictactoe;

public class Game
{
    private final Board board;
    private final Referee referee;
    private GameState state = GameState.NEW;
    private Player currentPlayer = Player.CROSS;

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

    private void gameOverDraw() {
        state = GameState.GAME_OVER_DRAW;
    }

    private void proceed() {
        state = GameState.PROCEEDING;
    }

    private void repeat() {
        state = GameState.REPEATING;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == Player.CROSS ? Player.NOUGHT : Player.CROSS;
    }

    public GameState state() {
        return state;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }
}

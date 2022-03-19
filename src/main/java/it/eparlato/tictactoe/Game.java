package it.eparlato.tictactoe;

/**
 * Hello world!
 *
 */
public class Game
{
    private GameState state = GameState.NEW;
    private Board board;
    private Player currentPlayer = Player.CROSS;

    public Game(Board board) {
        this.board = board;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates, currentPlayer);

        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           state = GameState.REPEATING;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            switchPlayer();
            state = GameState.PROCEEDING;
        }
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

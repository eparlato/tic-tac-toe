package it.eparlato.tictactoe;

/**
 * Hello world!
 *
 */
public class Game
{
    private GameState state = GameState.NEW_GAME;
    private Board board;
    private Player currentPlayer = Player.CROSS;

    public Game(Board board) {
        this.board = board;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates);

        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           state = GameState.PLAYER_COULD_NOT_EXECUTE_ACTION;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            switchPlayer();
            state = GameState.PLAYER_EXECUTED_ACTION;
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

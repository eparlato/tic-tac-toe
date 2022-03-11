package it.eparlato.tictactoe;

/**
 * Hello world!
 *
 */
public class Game
{
    private GameState state = GameState.NEW_GAME;
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates);

        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           state = GameState.PLAYER_COULD_NOT_EXECUTE_ACTION;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            state = GameState.PLAYER_EXECUTED_ACTION;
        }
    }

    public GameState state() {
        return state;
    }
}

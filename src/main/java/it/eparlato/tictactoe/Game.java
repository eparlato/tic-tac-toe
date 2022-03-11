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

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            state = GameState.WAITING_NEXT_PLAYER;
        }
    }

    public GameState state() {
        return state;
    }
}

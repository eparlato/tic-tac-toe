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


    public GameState state() {
        return state;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates);
    }
}

package it.eparlato.tictactoe;

/**
 * Hello world!
 *
 */
public class Game
{
    private GameState state = GameState.NEW;
    private Board board;
    private Referee referee;
    private Player currentPlayer = Player.CROSS;

    public Game(Board board, Referee referee) {
        this.board = board;
        this.referee = referee;
    }

    public void takeField(FieldCoordinates fieldCoordinates) {
        board.takeField(fieldCoordinates, currentPlayer);

        referee.check(board);

        RefereeEvaluation refereeEvaluation = referee.evaluation();

        if (refereeEvaluation.equals(RefereeEvaluation.REPEAT)) {
           state = GameState.REPEATING;
           return;
        }

        if (refereeEvaluation.equals(RefereeEvaluation.CONTINUE)) {
            switchPlayer();
            state = GameState.PROCEEDING;
        }


        if (refereeEvaluation.equals(RefereeEvaluation.ALL_FIELDS_TAKEN)) {
            state = GameState.GAME_OVER_DRAW;
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

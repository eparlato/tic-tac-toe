package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Game;
import it.eparlato.tictactoe.Mark;

public class GameOverAllFieldsInRowTaken implements BoardGameRule {
    public boolean isSatisfiedBy(Board board) {
        Mark[][] boardContent = board.content();

        for (Mark[] row : boardContent) {
            if (row[0].equals(Mark.EMPTY) ||
                    row[1].equals(Mark.EMPTY) ||
                    row[2].equals(Mark.EMPTY)) {
                continue;
            }

            if (row[0].equals(row[1]) &&
                    row[0].equals(row[2])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void applyOn(Game game) {
        game.gameOverAllFieldsTakenByPlayer();
    }
}

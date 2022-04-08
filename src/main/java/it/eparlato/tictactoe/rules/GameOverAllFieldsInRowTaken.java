package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;

public class GameOverAllFieldsInRowTaken implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        Mark[][] boardContent = board.content();

        for (Mark[] row : boardContent) {
            if (row[0].equals(Mark.EMPTY) ||
                    row[1].equals(Mark.EMPTY) ||
                    row[2].equals(Mark.EMPTY)) {
                continue;
            }

            return row[0].equals(row[1]) && row[0].equals(row[2]);
        }

        return false;
    }

    @Override
    public void applyOn(Game game) {
        game.gameOverRowTakenByPlayer();
    }
}

package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;

public class GameOverAllFieldsTaken implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        Mark[][] content = board.content();

        for (Mark[] row : content) {
            for (Mark field : row) {
                if (field.equals(Mark.EMPTY)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void applyOn(Game game) {
        game.gameOverAllFieldsTaken();
    }
}

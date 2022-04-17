package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;

public class GameOverAllFieldsInColumnTaken implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        Mark[][] content = board.content();

        for (int columnIndex = 0; columnIndex < content.length; columnIndex++) {
            if (content[0][columnIndex].equals(Mark.EMPTY) ||
                    content[1][columnIndex].equals(Mark.EMPTY) || content[2][columnIndex].equals(Mark.EMPTY)) {
                continue;
            }

            return content[0][columnIndex].equals(content[1][columnIndex]) &&
             content[0][columnIndex].equals(content[2][columnIndex]);
        }

        return false;
    }

    @Override
    public void applyOn(Game game) {
        game.gameOverColumnTakenByPlayer();
    }
}

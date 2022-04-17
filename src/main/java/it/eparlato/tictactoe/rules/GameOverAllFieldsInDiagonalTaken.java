package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Game;

public class GameOverAllFieldsInDiagonalTaken implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        Mark[][] content = board.content();

        if( content[0][0].equals(content[1][1]) && content[0][0].equals(content[2][2]) && !content[0][0].equals(Mark.EMPTY))
            return true;

        return content[0][2].equals(content[1][1]) && content[0][2].equals(content[2][0]) && !content[0][2].equals(Mark.EMPTY);
    }

    @Override
    public void applyOn(Game game) {
        game.gameOverDiagonalTakenByPlayer();
    }
}

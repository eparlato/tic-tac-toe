package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.game.Game;

public interface BoardGameRule {
    boolean isSatisfiedBy(Board board);

    void applyOn(Game game);
}

package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Game;

public interface BoardGameRule {
    boolean isSatisfiedBy(Board board);

    void applyOn(Game game);
}

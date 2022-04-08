package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public interface BoardGameRule {

    // TODO: condition => isSatisfiedBy
    // TODO action => executeOn
    void applyOn(Game game);
}

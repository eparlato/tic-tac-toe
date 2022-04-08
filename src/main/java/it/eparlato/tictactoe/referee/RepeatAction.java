package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class RepeatAction implements BoardGameRule {
    @Override
    public void applyOn(Game game) {
        game.repeat();
    }
}

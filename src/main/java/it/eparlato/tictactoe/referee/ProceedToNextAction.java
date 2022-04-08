package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class ProceedToNextAction implements BoardGameRule {
    @Override
    public void applyOn(Game game) {
        game.switchPlayer();
        game.proceed();
    }
}

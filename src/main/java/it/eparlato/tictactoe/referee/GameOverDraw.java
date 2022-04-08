package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class GameOverDraw implements BoardGameRule {
    @Override
    public void applyOn(Game game) {
        game.gameOverDraw();
    }
}

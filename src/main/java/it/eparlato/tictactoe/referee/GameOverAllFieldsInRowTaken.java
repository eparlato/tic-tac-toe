package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class GameOverAllFieldsInRowTaken implements BoardGameRule {
    @Override
    public void applyOn(Game game) {
        game.gameOverAllFieldsTakenByPlayer();
    }
}

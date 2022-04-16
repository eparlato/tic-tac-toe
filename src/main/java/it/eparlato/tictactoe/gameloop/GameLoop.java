package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.Game;

public class GameLoop {
    private ApplicationOutput output;

    public GameLoop(ApplicationOutput output) {
        this.output = output;
    }

    public void start(Game game) {
        output.showWelcomeMessage();
        output.showGameSnapshot(game.snapshot());
    }
}

package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.Game;

public class GameLoop {
    private final ApplicationInput input;
    private final ApplicationOutput output;

    public GameLoop(ApplicationInput input, ApplicationOutput output) {
        this.input = input;
        this.output = output;
    }

    public void start(Game game) {
        output.showWelcomeMessage();
        output.showGameSnapshot(game.snapshot());

        while(!game.isOver()) {
            game.takeField(input.getFieldCoordinates());
            output.showGameSnapshot(game.snapshot());
        }

        output.showGameOverMessage();
    }
}
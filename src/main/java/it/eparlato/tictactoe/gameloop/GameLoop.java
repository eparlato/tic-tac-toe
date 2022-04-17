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
        output.showInstructions();
        output.showBoard(game.boardContent());

        while(!game.isOver()) {
            output.showBoard(game.boardContent());
            game.takeField(input.getFieldCoordinates());
        }

        output.showGameOverMessage();
        output.showBoard(game.boardContent());
    }
}

package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.GameSnapshot;

public interface ApplicationOutput {
    void showWelcomeMessage();

    void showGameSnapshot(GameSnapshot snapshot);

    void showGameOverMessage();
}

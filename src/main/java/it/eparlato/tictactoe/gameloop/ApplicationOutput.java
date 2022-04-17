package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.GameSnapshot;
import it.eparlato.tictactoe.game.Player;

public interface ApplicationOutput {
    void showInstructions();

    void showGameSnapshot(GameSnapshot snapshot);

    void showGameOverMessage();

    void showPlayerTakingTurn(Player currentPlayer);
}

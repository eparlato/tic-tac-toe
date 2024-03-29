package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Player;

public interface ApplicationOutput {
    void showInstructions();

    void showClosingMessage();

    void showPlayerTakingTurn(Player currentPlayer);

    void showBoard(Mark[][] boardContent);
}

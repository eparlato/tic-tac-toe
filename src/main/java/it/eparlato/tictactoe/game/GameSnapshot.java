package it.eparlato.tictactoe.game;

import it.eparlato.tictactoe.board.Mark;

public class GameSnapshot {
    private final Mark[][] boardContent;
    private final Player currentPlayer;
    private final GameState gameState;

    public GameSnapshot(Mark[][] boardContent, Player currentPlayer, GameState gameState) {
        this.boardContent = boardContent;
        this.currentPlayer = currentPlayer;
        this.gameState = gameState;
    }

    public Mark[][] boardContent() {
        return boardContent;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public GameState gameState() {
        return gameState;
    }
}

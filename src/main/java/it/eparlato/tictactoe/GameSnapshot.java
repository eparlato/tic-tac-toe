package it.eparlato.tictactoe;

public class GameSnapshot {
    private Mark[][] boardContent;
    private Player currentPlayer;
    private GameState gameState;

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

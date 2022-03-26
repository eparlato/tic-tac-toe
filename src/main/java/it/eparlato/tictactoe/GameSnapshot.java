package it.eparlato.tictactoe;

public class GameSnapshot {
    private Mark[][] boardContent;
    private Player currentPlayer;

    public GameSnapshot(Mark[][] boardContent, Player currentPlayer) {
        this.boardContent = boardContent;
        this.currentPlayer = currentPlayer;
    }

    public Mark[][] boardContent() {
        return boardContent;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }
}

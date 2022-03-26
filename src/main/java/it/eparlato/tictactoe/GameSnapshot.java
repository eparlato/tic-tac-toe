package it.eparlato.tictactoe;

public class GameSnapshot {
    private Mark[][] boardContent;

    public GameSnapshot(Mark[][] boardContent) {
        this.boardContent = boardContent;
    }

    public Mark[][] boardContent() {
        return boardContent;
    }
}

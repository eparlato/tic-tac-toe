package it.eparlato.tictactoe;

public class Player {
    private Mark playerMark;

    public Player(Mark playerMark) {
        this.playerMark = playerMark;
    }

    public Mark mark() {
        return playerMark;
    }
}

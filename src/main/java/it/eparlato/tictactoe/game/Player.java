package it.eparlato.tictactoe.game;

import it.eparlato.tictactoe.board.Mark;

import java.util.Objects;

public class Player {
    private Mark playerMark;

    public Player(Mark playerMark) {
        this.playerMark = playerMark;
    }

    public Mark mark() {
        return playerMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerMark == player.playerMark;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerMark=" + playerMark +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMark);
    }
}

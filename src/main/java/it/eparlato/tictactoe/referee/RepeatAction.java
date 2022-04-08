package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Game;

public class RepeatAction implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        return board.state().equals(BoardState.FIELD_ALREADY_TAKEN);
    }

    @Override
    public void applyOn(Game game) {
        game.repeat();
    }
}

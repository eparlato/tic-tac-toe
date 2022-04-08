package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.BoardState;
import it.eparlato.tictactoe.game.Game;

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

package it.eparlato.tictactoe.rules;

import it.eparlato.tictactoe.board.Board;
import it.eparlato.tictactoe.board.BoardState;
import it.eparlato.tictactoe.game.Game;

public class ProceedToNextAction implements BoardGameRule {
    @Override
    public boolean isSatisfiedBy(Board board) {
        return board.state().equals(BoardState.FIELD_TAKEN);
    }

    @Override
    public void applyOn(Game game) {
        game.switchPlayer();
        game.proceed();
    }
}

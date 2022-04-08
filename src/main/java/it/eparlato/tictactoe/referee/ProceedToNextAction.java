package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Game;

public class ProceedToNextAction implements BoardGameRule {
    public boolean isSatisfiedBy(Board board) {
        return board.state().equals(BoardState.FIELD_TAKEN);
    }

    @Override
    public void applyOn(Game game) {
        game.switchPlayer();
        game.proceed();
    }
}

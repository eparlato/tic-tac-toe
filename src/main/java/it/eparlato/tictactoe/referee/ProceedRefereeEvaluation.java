package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class ProceedRefereeEvaluation implements RefereeEvaluation {
    @Override
    public void applyOn(Game game) {
        game.switchPlayer();
        game.proceed();
    }
}

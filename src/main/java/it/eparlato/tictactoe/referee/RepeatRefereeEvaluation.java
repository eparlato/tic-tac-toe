package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class RepeatRefereeEvaluation implements RefereeEvaluation {
    @Override
    public void applyOn(Game game) {
        game.repeat();
    }
}

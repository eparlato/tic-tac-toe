package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;

public class GameOverAllFieldsInRowTakenByPlayerRefereeEvaluation implements RefereeEvaluation{
    @Override
    public void applyOn(Game game) {
        game.gameOverAllFieldsTakenByPlayer();
    }
}

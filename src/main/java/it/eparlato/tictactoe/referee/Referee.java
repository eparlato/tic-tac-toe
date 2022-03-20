package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;

public class Referee {
    private RefereeEvaluation evaluation;

    public void check(Board board) {
        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           evaluation = new RepeatRefereeEvaluation();
           return;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            evaluation = new ProceedRefereeEvaluation();
        }
    }

    public RefereeEvaluation evaluation() {
        return evaluation;
    }
}

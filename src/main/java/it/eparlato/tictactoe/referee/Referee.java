package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Mark;

public class Referee {
    private RefereeEvaluation evaluation;

    public void check(Board board) {
        if (isARowTakenByPlayer(board.content())) {
            evaluation = new GameOverAllFieldsInRowTakenByPlayerRefereeEvaluation();
            return;
        }

        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           evaluation = new RepeatRefereeEvaluation();
           return;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            evaluation = new ProceedRefereeEvaluation();
        }
    }

    private boolean isARowTakenByPlayer(Mark[][] boardContent) {

        for (Mark[] row : boardContent) {
            if (row[0].equals(Mark.EMPTY) ||
                    row[1].equals(Mark.EMPTY) ||
                    row[2].equals(Mark.EMPTY)) {
                continue;
            }

            if (row[0].equals(row[1]) &&
                    row[0].equals(row[2])) {
                return true;
            }
        }

        return false;
    }

    public RefereeEvaluation evaluation() {
        return evaluation;
    }
}

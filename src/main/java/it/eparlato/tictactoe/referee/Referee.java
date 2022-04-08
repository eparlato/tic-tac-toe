package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.BoardState;
import it.eparlato.tictactoe.Mark;

public class Referee {
    private BoardGameRule boardGameRule;

    public void check(Board board) {
        if (isARowTakenByPlayer(board.content())) {
            boardGameRule = new GameOverAllFieldsInRowTaken();
            return;
        }

        if (board.state().equals(BoardState.FIELD_ALREADY_TAKEN)) {
           boardGameRule = new RepeatAction();
           return;
        }

        if (board.state().equals(BoardState.FIELD_TAKEN)) {
            boardGameRule = new ProceedToNextAction();
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

    public BoardGameRule evaluation() {
        return boardGameRule;
    }
}

package it.eparlato.tictactoe;


public class Board {
    private BoardState state = BoardState.EMPTY;
    private final Mark[][] content = {
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
    };

    public void takeField(FieldCoordinates fieldCoordinates, Mark playerMark) {
        if( isFieldNotEmpty(fieldCoordinates) &&
                isFieldAlreadyTakenByTheOtherPlayer(fieldCoordinates, playerMark)) {
            state = BoardState.FIELD_ALREADY_TAKEN;
            return;
        }

        content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()] = playerMark;
        state = BoardState.FIELD_TAKEN;
    }

    public BoardState state() {
        return state;
    }

    public Mark[][] content() {
        return content;
    }

    private boolean isFieldNotEmpty(FieldCoordinates fieldCoordinates) {
        return !content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()].equals(Mark.EMPTY);
    }

    private boolean isFieldAlreadyTakenByTheOtherPlayer(FieldCoordinates fieldCoordinates, Mark playerMark) {
        return !content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()].equals(playerMark);
    }
}

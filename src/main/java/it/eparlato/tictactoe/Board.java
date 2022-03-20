package it.eparlato.tictactoe;


public class Board {
    private BoardState state = BoardState.EMPTY;
    private Mark[][] content = {
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
    };

    public void takeField(FieldCoordinates fieldCoordinates, Mark playerMark) {
        content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()] = playerMark;
        state = BoardState.FIELD_TAKEN;
    }

    public BoardState state() {
        return state;
    }

    public Mark[][] content() {
        return content;
    }
}

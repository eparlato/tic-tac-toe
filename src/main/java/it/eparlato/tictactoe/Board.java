package it.eparlato.tictactoe;


public class Board {
    private BoardState state = BoardState.EMPTY;
    private Mark[][] content = {
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
    };

    public void takeField(FieldCoordinates fieldCoordinates, Mark playerMark) {
        throw new UnsupportedOperationException("Must be implemented");
    }

    public BoardState state() {
        return state;
    }

    public Mark[][] content() {
        return content;
    }
}

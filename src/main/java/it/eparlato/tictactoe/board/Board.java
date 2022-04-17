package it.eparlato.tictactoe.board;


import it.eparlato.tictactoe.game.Player;

public class Board {
    private BoardState state = BoardState.EMPTY;
    private final Mark[][] content = {
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
            {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
    };

    public void takeField(FieldCoordinates fieldCoordinates, Player player) {
        if (isFieldEmpty(fieldCoordinates)) {
            content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()] = player.mark();
            state = BoardState.FIELD_TAKEN;
            return;
        }

        state = BoardState.FIELD_ALREADY_TAKEN;
    }

    public BoardState state() {
        return state;
    }

    public Mark[][] content() {
        return content;
    }

    private boolean isFieldEmpty(FieldCoordinates fieldCoordinates) {
        return content[fieldCoordinates.rowIndex()][fieldCoordinates.columnIndex()].equals(Mark.EMPTY);
    }
}

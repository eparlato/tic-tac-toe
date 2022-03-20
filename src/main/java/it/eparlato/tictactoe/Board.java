package it.eparlato.tictactoe;


public class Board {
    private BoardState state = BoardState.EMPTY;
    private String[][] content = {
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}
    };

    public void takeField(FieldCoordinates fieldCoordinates, Player player) {
        throw new UnsupportedOperationException("Must be implemented");
    }

    public BoardState state() {
        return state;
    }

    public String[][] content() {
        return content;
    }
}

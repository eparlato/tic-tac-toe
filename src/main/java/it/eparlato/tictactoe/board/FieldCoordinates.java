package it.eparlato.tictactoe.board;

public class FieldCoordinates {
    private final int rowIndex;
    private final int columnIndex;

    public FieldCoordinates(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int rowIndex() {
        return rowIndex;
    }

    public int columnIndex() {
        return columnIndex;
    }
}

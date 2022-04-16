package it.eparlato.tictactoe.board;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldCoordinates that = (FieldCoordinates) o;
        return rowIndex == that.rowIndex && columnIndex == that.columnIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, columnIndex);
    }
}

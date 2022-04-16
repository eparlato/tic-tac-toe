package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.FieldCoordinates;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApplicationInput implements ApplicationInput {
    private final Scanner scanner;
    private final Map<Integer, FieldCoordinates> fieldCoordinatesMap = Map.of(
        1, new FieldCoordinates(0, 0),
        2, new FieldCoordinates(0, 1),
        3, new FieldCoordinates(0, 2),
        4, new FieldCoordinates(1, 0),
        5, new FieldCoordinates(1, 1),
        6, new FieldCoordinates(1, 2),
        7, new FieldCoordinates(2, 0),
        8, new FieldCoordinates(2, 1),
        9, new FieldCoordinates(2, 1)
    );

    public ConsoleApplicationInput(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    @Override
    public FieldCoordinates getFieldCoordinates() {
        int fieldNumber = scanner.nextInt();

        return fieldCoordinatesMap.get(fieldNumber);
    }
}

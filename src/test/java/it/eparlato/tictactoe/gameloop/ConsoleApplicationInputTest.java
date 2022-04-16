package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.FieldCoordinates;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleApplicationInputTest {
    private ApplicationInput input;

    @Test
    void builds_field_coordinates_from_input_stream() {
        String upperLeftFieldCoordinate = "1";

        input = new ConsoleApplicationInput(new ByteArrayInputStream(upperLeftFieldCoordinate.getBytes(StandardCharsets.UTF_8)));

        FieldCoordinates fieldCoordinates = input.getFieldCoordinates();

        assertThat(fieldCoordinates).isEqualTo(new FieldCoordinates(0, 0));
    }
}

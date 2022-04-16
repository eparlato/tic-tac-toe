import it.eparlato.tictactoe.TicTacToe;
import it.eparlato.tictactoe.gameloop.ConsoleApplicationInput;
import it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.GAME_OVER_MESSAGE;
import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.WELCOME_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeE2ETest {
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Test
    void plays_a_game() throws UnsupportedEncodingException {
        String sequenceOfActions = "1\n2\n5\n6\n9\n";
        String expectedBoard =
                "X|O| \n" +
                " |X|O\n" +
                " | |X\n";

        new TicTacToe(new ConsoleApplicationInput(new ByteArrayInputStream(sequenceOfActions.getBytes(StandardCharsets.UTF_8))),
                new ConsoleApplicationOutput(new PrintStream(baos)));

        assertOutputContains(WELCOME_MESSAGE);
        assertOutputContains(expectedBoard);
        assertOutputContains(GAME_OVER_MESSAGE);
    }

    private void assertOutputContains(String text) throws UnsupportedEncodingException {
        assertThat(baos.toString("UTF-8")).contains(text);
    }
}

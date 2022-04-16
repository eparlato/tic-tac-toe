package it.eparlato.tictactoe.gameloop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.WELCOME_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleApplicationOutputTest {
    private ApplicationOutput output;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        output = new ConsoleApplicationOutput(new PrintStream(out));
    }

    @Test
    void shows_a_welcome_message() throws UnsupportedEncodingException {

        output.showWelcomeMessage();

        assertOutputContains(WELCOME_MESSAGE);
    }

    private void assertOutputContains(String text) throws UnsupportedEncodingException {
        assertThat(out.toString("UTF-8")).contains(text);
    }
}

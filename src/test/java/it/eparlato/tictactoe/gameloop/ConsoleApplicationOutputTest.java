package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.GameSnapshot;
import it.eparlato.tictactoe.game.GameState;
import it.eparlato.tictactoe.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.GAME_OVER_MESSAGE;
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

    @Test
    void shows_a_game_over_message() throws UnsupportedEncodingException {
        output.showGameOverMessage();

        assertOutputContains(GAME_OVER_MESSAGE);
    }

    @Test
    void shows_the_game_board() throws UnsupportedEncodingException {
        Mark[][] boardContent = {
                { Mark.EMPTY, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.CROSS },
                { Mark.NOUGHT, Mark.CROSS, Mark.EMPTY },
        };
        String expectedShownBoard =
                " |X| \n" +
                "O| |X\n" +
                "O|X| \n";

        GameSnapshot gameSnapshot = new GameSnapshot(boardContent, new Player(Mark.NOUGHT), GameState.PROCEEDING);

        output.showGameSnapshot(gameSnapshot);

        assertOutputContains(expectedShownBoard);
    }

    private void assertOutputContains(String text) throws UnsupportedEncodingException {
        assertThat(out.toString("UTF-8")).contains(text);
    }
}

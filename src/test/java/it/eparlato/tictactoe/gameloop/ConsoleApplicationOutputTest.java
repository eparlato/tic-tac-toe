package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.GAME_OVER_MESSAGE;
import static it.eparlato.tictactoe.gameloop.ConsoleApplicationOutput.INSTRUCTIONS;
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
    void shows_how_to_play_instructions() throws UnsupportedEncodingException {
        output.showInstructions();

        assertOutputContains(INSTRUCTIONS);
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

        output.showBoard(boardContent);

        assertOutputContains(expectedShownBoard);
    }

    @Test
    void shows_the_player_taking_turn() throws UnsupportedEncodingException {
        Mark[][] boardContent = {
                { Mark.EMPTY, Mark.CROSS, Mark.EMPTY },
                { Mark.NOUGHT, Mark.EMPTY, Mark.CROSS },
                { Mark.NOUGHT, Mark.CROSS, Mark.EMPTY },
        };

        output.showPlayerTakingTurn(new Player(Mark.NOUGHT));

        assertOutputContains("Player O takes turn");
    }

    private void assertOutputContains(String text) throws UnsupportedEncodingException {
        assertThat(out.toString("UTF-8")).contains(text);
    }
}

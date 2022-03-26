package it.eparlato.tictactoe;

import it.eparlato.tictactoe.referee.Referee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameAcceptanceTest {
    private final Board board = new Board();
    private final Referee referee = new Referee();
    private final Game game = new Game(board, referee);

    @Test
    void a_game_has_nine_fields_in_a_3x3_grid() {
        Mark[][] empty3x3Board = {
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
        };

        GameSnapshot snapshot = game.snapshot();

        assertThat(snapshot.boardContent()).isEqualTo(empty3x3Board);
    }
}

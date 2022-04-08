package it.eparlato.tictactoe.referee;

import it.eparlato.tictactoe.Game;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GameOverAllFieldsInRowTakenTest {
    @Test
    void tells_game_that_a_player_got_a_row() {
        Game game = mock(Game.class);
        GameOverAllFieldsInRowTaken evaluation =
                new GameOverAllFieldsInRowTaken();

        evaluation.applyOn(game);

        verify(game).gameOverAllFieldsTakenByPlayer();
    }
}
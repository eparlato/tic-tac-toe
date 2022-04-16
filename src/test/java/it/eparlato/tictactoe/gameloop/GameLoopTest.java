package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameLoopTest {
    private GameLoop gameLoop;
    private final ApplicationOutput output = mock(ApplicationOutput.class);
    private final Game game = mock(Game.class);

    @BeforeEach
    void setUp() {
        gameLoop = new GameLoop(output);
    }

    @Test
    void displays_a_welcome_message_with_a_game_snapshot() {
        gameLoop.start(game);

        verify(output).showWelcomeMessage();
        verify(output).showGameSnapshot(game.snapshot());
    }
}

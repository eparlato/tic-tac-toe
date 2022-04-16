package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.FieldCoordinates;
import it.eparlato.tictactoe.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameLoopTest {
    private GameLoop gameLoop;
    private final ApplicationOutput output = mock(ApplicationOutput.class);
    private final ApplicationInput input = mock(ApplicationInput.class);
    private final Game game = mock(Game.class);

    @BeforeEach
    void setUp() {
        gameLoop = new GameLoop(input, output);
    }

    @Test
    void displays_a_welcome_message_with_a_game_snapshot() {
        when(game.isOver()).thenReturn(true);

        gameLoop.start(game);

        verify(output).showWelcomeMessage();
        verify(output).showGameSnapshot(game.snapshot());
    }

    @Test
    void sends_field_coordinates_from_input_to_game_until_the_game_is_over() {
        FieldCoordinates firstFieldCoordinates = new FieldCoordinates(0, 0);
        FieldCoordinates secondFieldCoordinates = new FieldCoordinates(0, 1);
        when(input.getFieldCoordinates())
                        .thenReturn(firstFieldCoordinates)
                        .thenReturn(secondFieldCoordinates);

        when(game.isOver())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        gameLoop.start(game);

        verify(input, times(2)).getFieldCoordinates();
        verify(game).takeField(firstFieldCoordinates);
        verify(game).takeField(secondFieldCoordinates);
        verify(output, times(3)).showGameSnapshot(game.snapshot());
    }

    @Test
    void shows_a_message_when_the_game_is_over() {
        when(game.isOver()).thenReturn(true);

        gameLoop.start(game);

        verify(output).showGameOverMessage();
    }
}

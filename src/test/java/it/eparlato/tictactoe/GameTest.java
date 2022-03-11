package it.eparlato.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void starts_with_a_new_game_state() {
        Game game = new Game();

        GameState gameState = game.state();

        assertThat(gameState).isEqualTo(GameState.NEW_GAME);
    }
}
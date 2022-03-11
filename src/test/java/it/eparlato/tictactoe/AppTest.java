package it.eparlato.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void uses_junit_correctly() {
        assertTrue(true);
    }

    @Test
    void uses_assertj_correctly() {
        assertThat(true).isEqualTo(true);
    }

}
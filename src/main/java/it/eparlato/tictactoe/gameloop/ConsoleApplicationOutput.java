package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.game.GameSnapshot;

import java.io.PrintStream;

public class ConsoleApplicationOutput implements ApplicationOutput {
    public final static String WELCOME_MESSAGE = "Welcome to Tic Tac Toe\n\n";
    private final PrintStream printStream;

    public ConsoleApplicationOutput(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void showWelcomeMessage() {
        printStream.print(WELCOME_MESSAGE);
    }

    @Override
    public void showGameSnapshot(GameSnapshot snapshot) {

    }

    @Override
    public void showGameOverMessage() {

    }
}

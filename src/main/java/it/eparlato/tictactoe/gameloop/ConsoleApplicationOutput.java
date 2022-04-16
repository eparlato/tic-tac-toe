package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.GameSnapshot;

import java.io.PrintStream;
import java.util.Map;

public class ConsoleApplicationOutput implements ApplicationOutput {
    public final static String WELCOME_MESSAGE = "Welcome to Tic Tac Toe\n\n";
    public static final String GAME_OVER_MESSAGE = "The Game is over, goodbye\n";
    private final PrintStream printStream;
    private final Map<Mark, String> symbolMap =
                Map.of(Mark.EMPTY, " ",
                        Mark.CROSS, "X",
                        Mark.NOUGHT, "O");

    public ConsoleApplicationOutput(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void showWelcomeMessage() {
        printStream.print(WELCOME_MESSAGE);
    }

    @Override
    public void showGameSnapshot(GameSnapshot snapshot) {
        showBoard(snapshot.boardContent());
    }

    @Override
    public void showGameOverMessage() {
        printStream.print(GAME_OVER_MESSAGE);
    }

    private void showBoard(Mark[][] boardContent) {
        StringBuilder sb = new StringBuilder();

        for (Mark[] row : boardContent) {
            sb.append(symbolMap.get(row[0])).append("|").append(symbolMap.get(row[1])).append("|").append(symbolMap.get(row[2])).append("\n");
        }

        printStream.print(sb);
    }
}

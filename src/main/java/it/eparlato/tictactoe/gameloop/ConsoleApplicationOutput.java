package it.eparlato.tictactoe.gameloop;

import it.eparlato.tictactoe.board.Mark;
import it.eparlato.tictactoe.game.GameSnapshot;
import it.eparlato.tictactoe.game.Player;

import java.io.PrintStream;
import java.util.Map;

public class ConsoleApplicationOutput implements ApplicationOutput {
    private final PrintStream printStream;
    private final Map<Mark, String> symbolMap =
                Map.of(Mark.EMPTY, " ",
                        Mark.CROSS, "X",
                        Mark.NOUGHT, "O");

    public final static String INSTRUCTIONS =
            "How to play: when a player takes turn, it writes the number of the field on the board to place its mark on it\n\n" +
            "1|2|3\n" +
            "4|5|6\n" +
            "7|8|9\n\n";
    private static final String LINE_SEPARATOR = "------";
    public static final String GAME_OVER_MESSAGE = "The Game is over, goodbye\n";

    public ConsoleApplicationOutput(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void showInstructions() {
        printStream.print(INSTRUCTIONS);
        printStream.print(LINE_SEPARATOR);
    }

    @Override
    public void showGameSnapshot(GameSnapshot snapshot) {
        showBoard(snapshot.boardContent());
        printStream.print(LINE_SEPARATOR);
    }

    @Override
    public void showGameOverMessage() {
        printStream.print(GAME_OVER_MESSAGE);
    }

    @Override
    public void showPlayerTakingTurn(Player currentPlayer) {
        printStream.printf("Player %s takes turn\n", symbolMap.get(currentPlayer.mark()));
    }

    private void showBoard(Mark[][] boardContent) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (Mark[] row : boardContent) {
            sb.append(symbolMap.get(row[0])).append("|").append(symbolMap.get(row[1])).append("|").append(symbolMap.get(row[2])).append("\n");
        }
        sb.append("\n");

        printStream.print(sb);
    }
}

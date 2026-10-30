package game;

import static game.util.IConstants.BOARD_INITIAL_SIZE;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.ui.BoardPanel;

public class TicMain {

    public static void main(String[] pArgs) {
        SwingUtilities.invokeLater(() -> {
            BoardPanel board = new BoardPanel();
            board.setPreferredSize(new Dimension(BOARD_INITIAL_SIZE, BOARD_INITIAL_SIZE));

            JFrame frame = new JFrame("Tic Tac Toe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(board);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

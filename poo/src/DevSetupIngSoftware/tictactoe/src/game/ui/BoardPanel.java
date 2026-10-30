package game.ui;

import static game.util.IConstants.BAR_COLOR_1;
import static game.util.IConstants.BAR_COLOR_2;
import static game.util.IConstants.BAR_COLOR_3;
import static game.util.IConstants.BAR_COLOR_4;
import static game.util.IConstants.BAR_THICKNESS;
import static game.util.IConstants.BOARD_BACKGROUND_COLOR;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics pG) {
        super.paintComponent(pG);
        Graphics2D graphics = (Graphics2D) pG;
        int width = getWidth();
        int height = getHeight();

        graphics.setColor(BOARD_BACKGROUND_COLOR);
        graphics.fillRect(0, 0, width, height);

        int left = width / 3 - BAR_THICKNESS / 2;
        int right = 2 * width / 3 - BAR_THICKNESS / 2;
        int top = height / 3 - BAR_THICKNESS / 2;
        int bottom = 2 * height / 3 - BAR_THICKNESS / 2;

        graphics.setColor(BAR_COLOR_1);
        graphics.fillRect(left, 0, BAR_THICKNESS, height);
        graphics.setColor(BAR_COLOR_2);
        graphics.fillRect(right, 0, BAR_THICKNESS, height);

        graphics.setColor(BAR_COLOR_3);
        graphics.fillRect(0, top, width, BAR_THICKNESS);
        graphics.setColor(BAR_COLOR_4);
        graphics.fillRect(0, bottom, width, BAR_THICKNESS);
    }
}

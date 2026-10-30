package game.ui;

import static game.util.IConstants.BAR_COLOR_1;
import static game.util.IConstants.BAR_COLOR_2;
import static game.util.IConstants.BAR_COLOR_3;
import static game.util.IConstants.BAR_COLOR_4;
import static game.util.IConstants.BAR_THICKNESS;
import static game.util.IConstants.BOARD_BACKGROUND_COLOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

class BoardPanelTest {

    private static final int SMALL = 300;
    private static final int LARGE = 600;

    @Test
    void pintaCuatroBarras() {
        BufferedImage image = paint(SMALL, SMALL);

        assertPixel(BAR_COLOR_1, image, 100, 150);
        assertPixel(BAR_COLOR_2, image, 200, 150);
        assertPixel(BAR_COLOR_3, image, 150, 100);
        assertPixel(BAR_COLOR_4, image, 150, 200);
    }

    @Test
    void coloresDeBarraSonDistintos() {
        Color[] colors = { BAR_COLOR_1, BAR_COLOR_2, BAR_COLOR_3, BAR_COLOR_4, BOARD_BACKGROUND_COLOR };

        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                assertNotEquals(colors[i].getRGB(), colors[j].getRGB());
            }
        }
    }

    @Test
    void nueveZonasConFondo() {
        BufferedImage image = paint(SMALL, SMALL);
        int[] centers = { 50, 150, 250 };

        for (int x : centers) {
            for (int y : centers) {
                assertPixel(BOARD_BACKGROUND_COLOR, image, x, y);
            }
        }
    }

    @Test
    void barraVerticalOcupaAltura() {
        BufferedImage image = paint(SMALL, SMALL);

        assertPixel(BAR_COLOR_1, image, 100, 0);
        assertPixel(BAR_COLOR_1, image, 100, SMALL - 1);
    }

    @Test
    void barraHorizontalOcupaAncho() {
        BufferedImage image = paint(SMALL, SMALL);

        assertPixel(BAR_COLOR_3, image, 0, 100);
        assertPixel(BAR_COLOR_3, image, SMALL - 1, 100);
    }

    @Test
    void barrasSeReubicanAlRedimensionar() {
        BufferedImage image = paint(LARGE, LARGE);

        assertPixel(BAR_COLOR_1, image, 200, 300);
        assertPixel(BAR_COLOR_2, image, 400, 300);
        assertPixel(BAR_COLOR_3, image, 300, 200);
        assertPixel(BAR_COLOR_4, image, 300, 400);
    }

    @Test
    void grosorDeBarra() {
        BufferedImage image = paint(SMALL, SMALL);
        int start = 100 - BAR_THICKNESS / 2;

        assertPixel(BAR_COLOR_1, image, start, 150);
        assertPixel(BOARD_BACKGROUND_COLOR, image, start - 1, 150);
    }

    private BufferedImage paint(int pWidth, int pHeight) {
        BoardPanel panel = new BoardPanel();
        panel.setSize(new Dimension(pWidth, pHeight));
        BufferedImage image = new BufferedImage(pWidth, pHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        panel.paintComponent(graphics);
        graphics.dispose();
        return image;
    }

    private void assertPixel(Color pExpected, BufferedImage pImage, int pX, int pY) {
        assertEquals(pExpected.getRGB() & 0xFFFFFF, pImage.getRGB(pX, pY) & 0xFFFFFF,
                "pixel (" + pX + ", " + pY + ")");
    }
}

package screen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapPanel extends JPanel implements ComponentUI {

	private final char[][] map;

	public MapPanel(char[][] map) {
		this.map = map;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawWorld(g);
	}

	private void drawWorld(Graphics g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				drawTile(g, map[i][j], i, j);
			}
		}
	}

	private void drawTile(Graphics g, char tile, int x, int y) {
		int xPos = x * TILE_SIZE;
		int yPos = y * TILE_SIZE;

		g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, TILE_SIZE, TILE_SIZE);

		g.setColor(Color.GRAY);
		g.drawRect(xPos, yPos, TILE_SIZE, TILE_SIZE);

		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(tile), xPos + TILE_SIZE / 2 - 4, yPos + TILE_SIZE / 2 + 4);
	}
}

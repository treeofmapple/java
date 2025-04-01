package screen;

import javax.swing.JFrame;

public class GameUI extends JFrame implements ComponentUI {

    private char[][] worldMap;

    public GameUI(char[][] map) {
        this.worldMap = map;
        initUI(worldMap);
    }

    private void initUI(char[][] map) {
        setTitle("Map View");
        setSize(map.length * TILE_SIZE, map[0].length * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MapPanel(map));
    }
}

package mapGen;

import java.util.stream.IntStream;

public class WorldGen implements WorldSize {
	
	public char[][] map;
	private WorldComponents components;
	
	public WorldGen() {
		map = new char[WIDTH][HEIGHT];
		components = new WorldComponents(map);
		generateFullWorld();
	}

	private void generateFullWorld() {
		generateWorld();
		components.generateLake(3);
	}

	private void generateWorld() {
		IntStream.range(0, WIDTH).forEach(i -> IntStream.range(0, HEIGHT).forEach(j -> map[i][j] = '.'));
	}
	
    public char[][] getMap() {
        return map;
    }
	
}

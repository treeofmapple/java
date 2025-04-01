package mapGen;

import java.util.Random;

public class WorldComponents extends WorldGen implements WorldSize {

	private Random aleatory = new Random();
	private char[][] map;

	public WorldComponents(char[][] map) {
		this.map = map;
	}

	protected void generateLake(int quantity) {
		int startX, startY;
		while (quantity > 0) {
			do {
				startX = aleatory.nextInt(WorldSize.WIDTH - 3);
				startY = aleatory.nextInt(WorldSize.HEIGHT - 3);
			} while (!canPlaceLake(startX, startY));

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (startX + i < WorldSize.WIDTH && startY + j < WorldSize.HEIGHT) {
						map[startX + i][startY + j] = '~';
					}
				}
			}
			quantity--;
		}
	}

	private boolean canPlaceLake(int startX, int startY) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[startX + i][startY + j] != '.') {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * 
	 * protected char[][] generateObstacles(int startX, int startY) {
	 * 
	 * }
	 * 
	 * protected char[][] generateObstaclesCustom(int startX, int startY, int
	 * obstaclesWidth, int obstaclesHeight) {
	 * 
	 * }
	 * 
	 * protected char[][] generateBushes(int startX, int startY) {
	 * 
	 * }
	 * 
	 * protected char[][] generateBushesCustom(int startX, int startY, int
	 * bushesWidth, int bushesHeight) {
	 * 
	 * }
	 * 
	 * protected char[][] generateTrees(int startX, int startY) {
	 * 
	 * }
	 * 
	 * protected char[][] generateTreesCustom(int startX, int startY, int
	 * treesWidth, int treesHeight) {
	 * 
	 * }
	 * 
	 * private boolean canPlaceObstacles() { // 1x1 < 20% # return true; }
	 * 
	 * private boolean canPlaceTrees() { // 1x1 < 40% Y return true; }
	 * 
	 * private boolean canPlaceBush() { // 1x1 n return true; }
	 * 
	 */
}

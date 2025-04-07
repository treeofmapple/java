package Game;

import Engine.Core.Systems;

public class Game extends Systems {
	
	private final static String title = "PaperMache";
	private final static int FPS = 60;
	private final static int UPS = 60;
	private final static int width = 1280;
	private final static int height = 720;
	
	public static void main(String[] args) {
		new Game().start(title, FPS, UPS, width, height, true);
	}
}

package Game;

import Window.Windows;

public class Game implements Runnable {
	public Thread game;
	public static Windows windows;
	public static final int WIDTH = 1280, HEIGHT = 760;

	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public static void init() {
		windows = new Windows(WIDTH, HEIGHT, "Game");
		windows.create();
	}
	
	public void run() {
		init();
		while (!windows.shouldClose()) {
			update();
			render();
		} 
	}
	
	private void update() {
		windows.update();
	}
	
	private void render() {
		windows.swapBuffers();
	}

	public static void main(String[] args) {
		new Game().start();
	}
}

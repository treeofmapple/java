package Game;

import org.lwjgl.glfw.GLFW;

import Engine.Util.Input;
import Window.Windo;

public class Game implements Runnable {
	public Thread game;
	public Windo window;
	public final int WIDTH = 1280, HEIGHT = 760;
	
	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public void init() {
		window = new Windo(WIDTH, HEIGHT, "Game");
		window.setBackgroundColor(1.0f, 0, 0);
		window.create();
	}
	
	public void run() {
		init();
		while (!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
			update();
			render();
			if (Input.isKeyDown(GLFW.GLFW_KEY_F11)) window.setFullscreen(!window.isFullscreen());
		}
		window.destroy();
	}
	
	private void update() {
		window.update();
		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("X: " + Input.getScrollX() + ", Y: " + Input.getScrollY());
	}
	
	private void render() {
		window.swapBuffers();
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}

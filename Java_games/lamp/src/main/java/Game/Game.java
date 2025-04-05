package Game;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F11;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT;

import Engine.Util.Input;
import Window.Windows;

public class Game implements Runnable {
	public Thread game;
	public static Windows screen;
	public static final int WIDTH = 1280, HEIGHT = 760;

	public void start() {
		game = new Thread(this, "game");
		game.start();
	}

	private void init() {
		screen = new Windows(WIDTH, HEIGHT, "Game");
		screen.setBackgroundColor(1.0f, 0, 0);
		screen.create();
	}

	public void run() {
		init();
		while (!screen.shouldClose() && Input.isKeyDown(GLFW_KEY_ESCAPE)) {
			update();
			render();
			if (Input.isKeyDown(GLFW_KEY_F11)) {
				screen.setFullscreen(!screen.isFullScreen());
			}
		}
		screen.destroy();

	}

	private void update() {
		screen.update();
		if (Input.isButtonDown(GLFW_MOUSE_BUTTON_LEFT)) {
			System.out.println("X: " + Input.getMouseX() + ", Y: " + Input.getMouseY());
		}
	}

	private void render() {
		screen.swapBuffers();
	}

	public static void main(String[] args) {
		new Game().start();
	}
}

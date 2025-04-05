package Engine.Core;

import Engine.Render.Render;
import Game.Scene.Scene;
import Windows.Windows2;

public class Engine extends Render {

	public static final int TARGET_UPS = 30;
	private final IAppLogic appLogic;
	private final Windows2 screen;
	private Render render;
	private boolean running;
	private Scene scene;
	private int targetFps;
	private int targetUps;

	public Engine(String windowTitle, Windows2.WindowOptions opts, IAppLogic appLogic) {
		screen = new Windows2(windowTitle, opts, () -> {
			resize();
			return null;
		});
		targetFps = opts.fps;
		targetUps = opts.ups;
		this.appLogic = appLogic;
		org.lwjgl.opengl.GL.createCapabilities();
		render = new Render();
		scene = new Scene();
		appLogic.init(screen, scene, render);
		running = true;
	}

	private void cleanup() {
		appLogic.cleanup();
		render.cleanup();
		scene.cleanup();
		screen.cleanup();
	}

	private void resize() {
		// Nothing to be done yet
	}

	private void run() {
		long initialTime = System.currentTimeMillis();
		float timeU = 1000.0f / targetUps;
		float timeR = targetFps > 0 ? 1000.0f / targetFps : 0;
		float deltaUpdate = 0;
		float deltaFps = 0;

		long updateTime = initialTime;
		while (running && !screen.windowShouldClose()) {
			screen.pollEvents();

			long now = System.currentTimeMillis();
			deltaUpdate += (now - initialTime) / timeU;
			deltaFps += (now - initialTime) / timeR;

			if (targetFps <= 0 || deltaFps >= 1) {
				appLogic.input(screen, scene, now - initialTime);
			}

			if (deltaUpdate >= 1) {
				long diffTimeMillis = now - updateTime;
				appLogic.update(screen, scene, diffTimeMillis);
				updateTime = now;
				deltaUpdate--;
			}

			if (targetFps <= 0 || deltaFps >= 1) {
				render.render(screen, scene);
				deltaFps--;
				screen.update();
			}
			initialTime = now;
		}

		cleanup();
	}

	public void start() {
		running = true;
		run();
	}

	public void stop() {
		running = false;
	}

}

package Engine.Core;

import Engine.Render.Render;
import Game.Scene.Scene;
import Windows.Screen;
import Windows.ScreenOptions;

public class Engine {

	private final IAppLogic appLogic;
	private final Screen screen;
	private final Render render;
	private Scene scene;
	private boolean running;
	private int targetFPS;
	private int targetUPS;
	
	public Engine(ScreenOptions options, IAppLogic appLogic) {
		screen = new Screen(options, () -> {
			resize();
			return null;
		});
		targetFPS = options.fps();
		targetUPS = options.ups();
        this.appLogic = appLogic;
        render = new Render();
        scene = new Scene();
        appLogic.init(screen, scene, render);
        running = true;
	}
	
	private void resize() {
		
	}
	
	private void run() {
        long initialTime = System.currentTimeMillis();
        float timeU = 1000.0f / targetUPS;
        float timeR = targetFPS > 0 ? 1000.0f / targetFPS : 0;
        float deltaUpdate = 0;
        float deltaFps = 0;

        long updateTime = initialTime;
        while (running && !screen.windowShouldClose()) {
            screen.pollEvents();

            long now = System.currentTimeMillis();
            deltaUpdate += (now - initialTime) / timeU;
            deltaFps += (now - initialTime) / timeR;

            if (targetFPS <= 0 || deltaFps >= 1) {
                appLogic.input(screen, scene, now - initialTime);
            }

            if (deltaUpdate >= 1) {
                long diffTimeMillis = now - updateTime;
                appLogic.update(screen, scene, diffTimeMillis);
                updateTime = now;
                deltaUpdate--;
            }

            if (targetFPS <= 0 || deltaFps >= 1) {
                render.render(screen, scene);
                deltaFps--;
                screen.update();
            }
            initialTime = now;
        }

        cleanup();
	}
	
	private void cleanup() {
		appLogic.cleanup();
		render.cleanup();
		scene.cleanup();
		screen.cleanup();
	}
	
	public void start() {
		running = true;
		run();
	}
	
	public void stop() {
		running = false;	
	}
	
}

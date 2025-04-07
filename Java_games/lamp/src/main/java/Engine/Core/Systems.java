package Engine.Core;

import Engine.Render.Render;
import Game.Scene.Scene;
import Windows.Screen;
import Windows.ScreenOptions;

public class Systems implements IAppLogic {

	Systems system = new Systems();
	
	protected void start(String title, int FPS, int UPS, int width, int height, boolean abs) {
		Engine gameEngine = new Engine(new ScreenOptions(title, FPS, UPS, width, height, abs), system);
		gameEngine.start();
	}
	
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void init(Screen screen, Scene scene, Render render) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void input(Screen screen, Scene scene, long diffTimeMillis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Screen screen, Scene scene, long diffTimeMillis) {
		// TODO Auto-generated method stub
		
	}

}

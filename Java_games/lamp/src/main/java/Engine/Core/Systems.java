package Engine.Core;

import Engine.Render.Render;
import Game.Config.Configuration;
import Game.Scene.Scene;
import Windows.Screen;
import Windows.ScreenOptions;

public class Systems implements IAppLogic {

	private Configuration config = new Configuration();
	
	protected void start() {
		Engine gameEngine = new Engine(new ScreenOptions(config.getTitle(), config.getFps(), config.getUps(), config.getWidth(), config.getHeight(), true));
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

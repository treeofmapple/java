package Engine.Core;

import Engine.Render.Render;
import Game.Scene.Scene;
import Windows.Screen;

public interface IAppLogic {

	void cleanup();
	
    void init(Screen screen, Scene scene, Render render);

    void input(Screen screen, Scene scene, long diffTimeMillis);

    void update(Screen screen, Scene scene, long diffTimeMillis);
	
}

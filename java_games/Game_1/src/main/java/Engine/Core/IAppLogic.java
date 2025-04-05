package Engine.Core;

import Engine.Render.Render;
import Game.Scene.Scene;
import Windows.Windows2;

public interface IAppLogic {

    void cleanup();

    void init(Windows2 window, Scene scene, Render render);

    void input(Windows2 window, Scene scene, long diffTimeMillis);

    void update(Windows2 window, Scene scene, long diffTimeMillis);
}
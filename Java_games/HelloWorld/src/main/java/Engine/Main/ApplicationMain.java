package Engine.Main;

import Engine.Window.Screen;

public class ApplicationMain extends Screen{

    public void run() {
        init();
        loop();
        cleanup();
    }

    public static void main(String[] args) {
        new ApplicationMain().run();
    }
}

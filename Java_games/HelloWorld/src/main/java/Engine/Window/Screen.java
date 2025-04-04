package Engine.Window;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import Engine.Core.Util.SystemTime;

public class Screen {

    private long window;
    private boolean fullscreen = false;
    private int windowedWidth = 800;
    private int windowedHeight = 600;
    private int windowPosX, windowPosY;

    protected void run() {
        init();
        loop();
        cleanup();
    }

    protected void keepRunning() {
    	while(keepOnRunning) {
    		input();
    		update();
    		render();
	        if (GLFW.glfwWindowShouldClose(window)) {
	            keepOnRunning = false;
	        }
    	}
    }
    
    
    
    
    
    
    protected void init() {
    	lastLoopTime = SystemTime.getTime();
        GLFWErrorCallback.createPrint(System.err).set();

        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        
        createWindow();
    }
    
    protected void loop() {
        GL.createCapabilities();

        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();

            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_F11) == GLFW.GLFW_PRESS) {
                toggleFullscreen();
                while (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_F11) == GLFW.GLFW_PRESS) {
                    GLFW.glfwPollEvents();
                }
            }
        }
    }
    
    protected void cleanup() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }
    
    protected void toggleFullscreen() {
    	fullscreen = !fullscreen;
    	long oldWindow = window;
    	GLFW.glfwHideWindow(oldWindow);
    	GLFW.glfwDestroyWindow(oldWindow);
    	createWindow();
    	GL.createCapabilities();
    }
    
    private void createWindow() {
        long monitor = fullscreen ? GLFW.glfwGetPrimaryMonitor() : 0;
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

        if (fullscreen) {
            windowedWidth = vidMode.width();
            windowedHeight = vidMode.height();
        } else {
            windowedWidth = (int)(vidMode.width() * 0.75);
            windowedHeight = (int)(vidMode.height() * 0.75);
        }

        window = GLFW.glfwCreateWindow(windowedWidth, windowedHeight, "LWJGL Window", monitor, 0);

        if (window == 0) {
            throw new RuntimeException("Failed to create GLFW window");
        }

        if (!fullscreen) {
            windowPosX = (vidMode.width() - windowedWidth) / 2;
            windowPosY = (vidMode.height() - windowedHeight) / 2;
            GLFW.glfwSetWindowPos(window, windowPosX, windowPosY);
        }

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
    }
    
}

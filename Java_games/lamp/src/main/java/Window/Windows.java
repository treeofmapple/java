package Window;


import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowTitle;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import org.lwjgl.glfw.GLFWVidMode;

import Engine.Util.Input;

public class Windows {
	private int width, height;
	private String title;
	private long window;
	public int frames;
	public Input input;
	public static long time;
	
	public Windows(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	public void create() {
		if (!glfwInit()) {
			System.err.println("ERROR: GLFW wasn't initializied");
			return;
		}
		
		input = new Input();
		window = glfwCreateWindow(width, height, title, 0, 0);
		
		if (window == 0) {
			System.err.println("ERROR: Window wasn't created");
			return;
		}
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		glfwMakeContextCurrent(window);
	
		glfwSetKeyCallback(window, input.getKeyboardCallback());
	    glfwSetCursorPosCallback(window, input.getMouseMoveCallback());
	    glfwSetMouseButtonCallback(window, input.getMouseButtonsCallback());
	    
	    glfwShowWindow(window);
	    
	    glfwSwapInterval(1);
	    
	    time = System.currentTimeMillis();
	}
	
	public void update() {
		glfwPollEvents();
		frames++;
		if (System.currentTimeMillis() > time + 1000) {
			glfwSetWindowTitle(window, title + " | FPS: " + frames);
			time = System.currentTimeMillis();
			frames = 0;
		}
	}
	
	public void swapBuffers() {
		glfwSwapBuffers(window);
	}
	
	public boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}
	
	public void destroy() {
		input.destroy();
		glfwWindowShouldClose(window);
		glfwDestroyWindow(window);
		glfwTerminate();
	}
	
}

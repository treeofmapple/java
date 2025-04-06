package Window;

import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetScrollCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowMonitor;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowSizeCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowTitle;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import Engine.Util.Input;

public class Windows {
	private int width, height;
	private String title;
	private long window;
	private int frames;
	private Input input;
	private GLFWWindowSizeCallback sizeCallback;
	private float backgroundR, backgroundG, backgroundB;
	private boolean isResized;
	private boolean isFullscreen;
	private int[] windowPosX = new int[1], windowPosY = new int[1];

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
		window = GLFW.glfwCreateWindow(width, height, title, isFullscreen ? glfwGetPrimaryMonitor() : 0, 0);
		
		if (window == 0) {
			System.err.println("ERROR: Window wasn't created");
			return;
		}

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		windowPosX[0] = (videoMode.width() - width) / 2;
		windowPosY[0] = (videoMode.height() - height) / 2;
		glfwSetWindowPos(window, windowPosX[0], windowPosY[0]);
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		
		createCallbacks();
		glfwShowWindow(window);
		glfwSwapInterval(1);

		time = System.currentTimeMillis();
	}

	public void update() {
		if (isResized) {
			GL11.glViewport(0, 0, width, height);
			isResized = false;
		}
		GL11.glClearColor(backgroundR, backgroundG, backgroundB, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		glfwPollEvents();
		frames++;
		if (System.currentTimeMillis() > time + 1000) {
			glfwSetWindowTitle(window, title + " | FPS: " + frames);
			time = System.currentTimeMillis();
			frames = 0;
		}
	}

	private void createCallbacks() {
		sizeCallback = new GLFWWindowSizeCallback() {
			public void invoke(long window, int w, int h) {
				width = w;
				height = h;
				isResized = true;
			}
		};

		glfwSetKeyCallback(window, input.getKeyboardCallback());
		glfwSetCursorPosCallback(window, input.getMouseMoveCallback());
		glfwSetMouseButtonCallback(window, input.getMouseButtonsCallback());
		glfwSetScrollCallback(window, input.getMouseScrollCallBack());
		glfwSetWindowSizeCallback(window, sizeCallback);
	}

	public void setFullscreen(boolean isFullscreen) {
		this.isFullscreen = isFullscreen;
		isResized = true;
		if (isFullscreen) {
			glfwGetWindowPos(window, windowPosX, windowPosY);
			glfwSetWindowMonitor(window, glfwGetPrimaryMonitor(), 0, 0, width, height, 0);
		} else {
			glfwSetWindowMonitor(window, 0, windowPosX[0], windowPosY[0], width, height, 0);
		}
	}

	public void destroy() {
		input.destroy();
		sizeCallback.free();
		glfwWindowShouldClose(window);
		glfwDestroyWindow(window);
		glfwTerminate();
	}

	public void setBackgroundColor(float r, float g, float b) {
		backgroundR = r;
		backgroundG = g;
		backgroundB = b;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}

	public long getWindow() {
		return window;
	}
	
	public boolean isFullscreen() {
		return isFullscreen;
	}
	
	public void swapBuffers() {
		glfwSwapBuffers(window);
	}

	public boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}

}

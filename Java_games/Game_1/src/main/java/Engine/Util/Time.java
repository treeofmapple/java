package Engine.Util;

import org.lwjgl.glfw.GLFW;

public class Time {

	private double lastLoopTime; 

	public static double getTime() {
	    return GLFW.glfwGetTime();
	}
	
	public static float getDelta() {
		double time = getTime();
		float delta = (float) (time - lastLoopTime);
		lastLoopTime = time;
		timeCount += delta;
		return delta;
	}
	
}

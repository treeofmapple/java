package Engine.Render;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import org.lwjgl.opengl.GL;

public class Render {

	public Render() {
		GL.createCapabilities();
	}
	
	public void cleanup() {
		
	}
	
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
}

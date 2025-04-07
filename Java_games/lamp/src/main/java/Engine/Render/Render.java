package Engine.Render;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import Game.Scene.Scene;
import Windows.Screen;

public class Render {

	public Render() {
		GL.createCapabilities();
	}
	
	public void cleanup() {
		
	}
	
	public void render(Screen screen, Scene scene) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
}

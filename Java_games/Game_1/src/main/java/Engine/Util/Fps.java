package Engine.Util;

public class Fps {
	
	float timeCount;
	int fps;
	int fpsCount;
	int ups;
	int upsCount;
	
	public void updateFPS() {
	    fpsCount++;
	}

	public void updateUPS() {
	    upsCount++;
	}
	
	public void systemFPS() {
	    if (timeCount > 1f) {
	        fps = fpsCount;
	        fpsCount = 0;

	        ups = upsCount;
	        upsCount = 0;

	        timeCount -= 1f;
	    }
	}
}

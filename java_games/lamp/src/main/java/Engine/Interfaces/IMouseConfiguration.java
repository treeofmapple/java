package Engine.Interfaces;

import Game.Config.GameConfiguration;

public interface IMouseConfiguration {

	IMouseConfiguration configuration = new GameConfiguration();
	
	boolean isInvertRotation();
    void setInvertRotation(boolean invertRotation);
    boolean isInvertMouseClick();
    void setInvertMouseClick(boolean invertMouseClick);
    
}

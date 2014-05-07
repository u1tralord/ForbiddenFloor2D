package forbiddenfloor;

import core.Game;
import core.components.Component;
import core.components.Wall;
import core.display.Display;

public class ForbiddenFloor extends Game {
	String gameTitle = "Forbidden Floor";
	String gameVersion = "0.0.1";
	static Wall w = new Wall(32, 56);
	
	public ForbiddenFloor() {
		super(10, 640, 480);
		components.add(w);
		start();
	}
	
	public static void main(String[] args){
		Display window = new Display("Forbidden Floor", "0.0.1", 640, 480);
		ForbiddenFloor f = new ForbiddenFloor();
		window.add(f);
		f.saveFrame();
	}
}

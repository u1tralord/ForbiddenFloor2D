package core.components;

import core.display.Screen;
import core.util.Sprite;


public abstract class Component {
	int x, y;
	Sprite sprite;
	boolean solid;
	
	public void draw(Screen screen){
		screen.render(x, y, sprite);
	}
}

package core.components;

import core.util.ResourceLoader;
import core.util.Sprite;

public class Wall extends Component{
	
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
		solid = true;
		sprite = new Sprite("res\\right3.png");
	}
	
	public void move(int x0, int y0){
		x = x0;
		y = y0;
	}
}

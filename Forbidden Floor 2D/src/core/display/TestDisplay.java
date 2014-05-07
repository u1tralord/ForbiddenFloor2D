package core.display;

import javax.swing.JFrame;

public class TestDisplay {
	public static void main(String[] args){
		TestComponent tc = new TestComponent(640, 480);
		Display window = new Display("Game Engine Test", "0.0.1");
		window.add(tc);
		tc.saveFrame();
		window.repaint();
	}
}

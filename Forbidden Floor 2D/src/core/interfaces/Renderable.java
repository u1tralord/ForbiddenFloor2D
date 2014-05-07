package core.interfaces;

import core.display.Screen;

public interface Renderable {
	public int getWidth();

	public int getHeight();

	public int[][] getPixels();

	public void render(int x, int y, Screen frame);
}

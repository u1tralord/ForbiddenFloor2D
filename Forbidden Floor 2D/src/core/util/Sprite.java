package core.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import core.display.Screen;
import core.interfaces.Renderable;

public class Sprite implements Renderable {
	BufferedImage image;
	double scale = 1; //need to implement
	int[][] pixels;
	int width, height;

	public Sprite(BufferedImage img) {
		this.image = img;
		create();
	}

	public Sprite(String path) {
		this.image = ResourceLoader.getImage(path);
		create();
	}

	public void create() {
		this.width = image.getWidth();
		this.height = image.getHeight();
		pixels = new int[width][height];

		for (int x = 0; x < width - 1; x++) {
			for (int y = 0; y < height - 1; y++) {
				pixels[x][y] = image.getRGB(x, y);
			}
		}
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public void render(int x, int y, Screen frame) {
		frame.render(x, y, this);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getPixels() {
		return pixels;
	}
}

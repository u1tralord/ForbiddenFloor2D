package core.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	BufferedImage spriteSheet;
	int spriteSize = -1;
	int rows, cols;
	
	public SpriteSheet(String path, int spriteSize, int rows, int cols) {
		spriteSheet = ResourceLoader.getImage(path);
		this.spriteSize = spriteSize;
		this.rows = rows;
		this.cols = cols;
	}
	
	public BufferedImage getSprite(int row, int col) {
		BufferedImage sprite = null;
		if(row > -1 && row < rows && col > -1 && col < cols)
			sprite = spriteSheet.getSubimage(row*spriteSize, col*spriteSize, spriteSize, spriteSize);
		else{
			System.err.println("Image requested is out of bounds!");
		}
		return sprite;
	}
}

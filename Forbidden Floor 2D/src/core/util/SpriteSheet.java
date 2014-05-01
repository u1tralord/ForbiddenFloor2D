package core.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	BufferedImage spriteSheet;
	int spriteSize = -1;
	int rows, cols;
	
	public SpriteSheet(String sheetName, int spriteSize, int rows, int cols) {
		File file = new File(sheetName);
		
		try {
			spriteSheet = ImageIO.read(file);
		} 
		catch (IOException e) {e.printStackTrace();}
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

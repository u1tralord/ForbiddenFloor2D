package core.util;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader {
	
	public static BufferedImage getImage(String path){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new FileInputStream(path));
			System.out.println("resource loaded successfully");
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
		return img;
	}
}

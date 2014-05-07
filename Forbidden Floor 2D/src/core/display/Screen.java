package core.display;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.interfaces.Renderable;

public class Screen {
	private int width, height;
	private double scale = 1.0;
	private int[][] pixels;
	
	public Screen(int w, int h){
		this.width = w;
		this.height = h;
		this.pixels = new int[width][height];
		System.out.println(w);
		System.out.println(h);
		clear();
	}
		
	public void clear(){
		clear(Color.RED);
	}
	
	public void clear(Color color){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				pixels[x][y] = color.getRGB();
			}
		}
	}
	
	public void render(int x, int y, Renderable render){
		int[][] renderPix = render.getPixels();
		for(int xx = x; xx < x + render.getWidth(); xx++){
			for(int yy = y; yy < y + render.getHeight(); yy++){
				pixels[xx][yy] = renderPix[xx-x][yy-y];
				//pixels[xx][yy] = Color.RED.getRGB();
			}
		}
	}
	
	public BufferedImage getFrame(){
		BufferedImage frameImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				frameImg.setRGB(x, y, pixels[x][y]);
			}
		}
		
		clear();
		return frameImg;
	}
	
	public void saveFrame(String location) {
		try {
	    	File outputfile = new File(location + "\\pic.png");
			ImageIO.write(getFrame(), "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

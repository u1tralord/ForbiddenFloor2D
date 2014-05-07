package core.display;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import core.components.Wall;
import core.interfaces.Renderable;
import core.util.Sprite;

public class TestComponent extends JComponent{
	Screen frame;
	BufferedImage img;
	Sprite s;
	
	public TestComponent(int width, int height){
		this.setBounds(0, 0, width, height);
		
		frame = new Screen(width, height);
		Wall w = new Wall(624, 464);
		Wall w2 = new Wall(10, 10);
		w.draw(frame);
		w2.draw(frame);
		//s = new Sprite("res\\right5.png");
		//s.render(10, 20, frame);
		img = frame.getFrame();
	}
	
	public void draw(int x, int y, Renderable r){
		frame.render(x, y, r);
	}
	
	public void nextFrame(){
		img = frame.getFrame();
		//frame.clear();
	}
	
	public void saveFrame(){
		frame.saveFrame("C:\\Users\\Jacob\\git\\ForbiddenFloor2D\\Forbidden Floor 2D\\res");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, 0, 0, img.getWidth()-8, img.getHeight()-30, null);
		System.out.println("Painted");
	}
}

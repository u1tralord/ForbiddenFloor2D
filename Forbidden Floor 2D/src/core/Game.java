package core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.Timer;

import core.components.Component;
import core.display.Display;
import core.display.Screen;
import core.input.Keyboard;
import core.input.Mouse;

public class Game extends JComponent implements Runnable, ActionListener {
	Thread gameLoop;
	Timer timer;
	boolean running = false;

	public ArrayList<Component> components;
	public Keyboard keyInput;
	public Mouse mouseInput;
	
	Screen screen;
	BufferedImage frame;

	public Game(int tickLength, int width, int height) {
		setBounds(0, 0, width, height);
		
		screen = new Screen(width, height);
		frame = screen.getFrame();
		
		timer = new Timer(tickLength, this);
		keyInput = new Keyboard();
		mouseInput = new Mouse();
		gameLoop = new Thread(this, "Main Loop");
		components = new ArrayList<Component>();
	}

	public void start() {
		running = true;
		gameLoop.start();
		timer.start();
	}

	public void pause() {
		running = false;
		timer.stop();
	}

	public void stop() {
		running = false;
		timer.stop();
		try {
			gameLoop.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void gameLoop() {
		renderComponents();
		frame = screen.getFrame();
		repaint();
		// constant processes
		/*
		 * Get Keyboard Input
		 * Get Mouse Input
		 * Render all components
		 * Get image from frame/screen
		 * repaint();
		 * 
		 */
	}

	public void tick() {
		/*
		 * Process input
		 * Move entities
		 * Switch entities 
		 * 
		 */
	}

	public void run() {
		while (running) {
			gameLoop();
		}
	}

	public void actionPerformed(ActionEvent e) {
		tick();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);  
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(frame, 0, 0, frame.getWidth(), frame.getHeight(), null);
	}
	
	public void saveFrame(){
		screen.saveFrame("C:\\Users\\Jacob\\git\\ForbiddenFloor2D\\Forbidden Floor 2D\\res");
	}
	
	public void renderComponents(){
		for(Component c: components){
			c.draw(screen);
		}
	}
	
	public void addComponent(Component c){
		components.add(c);
	}
	
	public void removeComponent(Component c){
		components.remove(c);
	}

}

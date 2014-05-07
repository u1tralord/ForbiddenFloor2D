package core;

public class Game implements Runnable{
	Thread gameLoop;
	boolean running = false;
	
	public Game(){
		gameLoop = new Thread(this, "Main Loop");
	}
	
	public void start(){
		running = true;
		gameLoop.start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		while(running){
			//Main Loop
			/**
			 * 
			 * 
			 */
		}
	}
}

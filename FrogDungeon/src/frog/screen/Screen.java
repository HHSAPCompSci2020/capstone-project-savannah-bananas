package frog.screen;

import frog.DrawingSurface;

public abstract class Screen {
	
	//Fields
	public final int DRAWING_WIDTH = 800;
	public final int DRAWING_HEIGHT = 600;
	protected DrawingSurface surface;
	
	//Constructor
	public Screen(DrawingSurface surface) {
		this.surface = surface;
	}
	
	//Methods
	/**
	 * The statements in the setup() function execute once when the program begins
	 */
	public void setup() {
		
	}
	
	/**
	 * The statements in draw() are executed until the 
	 * program is stopped. Each statement is executed in 
	 * sequence and after the last line is read, the first 
	 * line is executed again.
	 */
	public void draw() {
		
	}
	
	/**
	 * 
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * 
	 */
	public void mouseMoved() {
		
	}
	
	/**
	 * 
	 */
	public void mouseDragged() {
		
	}
	
	/**
	 * 
	 */
	public void mouseReleased() {
		
	}
}

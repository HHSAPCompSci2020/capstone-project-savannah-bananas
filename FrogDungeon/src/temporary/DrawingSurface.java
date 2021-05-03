package temporary;

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	//Fields
	private FrogDungeon dungeon;
	private ArrayList<Integer> keys;
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	//Constructors
	public DrawingSurface(FrogDungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	//Methods
	/**
	 * 
	 */
	public void draw() {
		
	}
	
	/**
	 * 
	 */
	public void keyPressed() {
		
	}
	
	/**
	 * 
	 */
	public void keyReleased() {
		
	}
	
	/**
	 * 
	 * @param code
	 * @return true if key is pressed, false otherwise
	 */
	public boolean isPressed(Integer code) {
		return false;
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
	
	/**
	 * 
	 * @param assumed
	 * @return
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return null;
	}
	
	/**
	 * 
	 * @param actual
	 * @return
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return null;
	}
	
	/**
	 * 
	 * @param i
	 */
	@Override public void switchScreen(int i) {
		
	}

}

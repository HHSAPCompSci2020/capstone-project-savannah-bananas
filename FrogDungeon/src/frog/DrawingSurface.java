package frog;

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import frog.ScreenSwitcher;
import frog.screen.FrogDungeon;
import frog.screen.Screen;

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	//Fields
	
	/**
	 * List of keys that are currently being pressed
	 */
	private ArrayList<Integer> keys;
	
	/**
	 * Screen object that is currently being drawn/updated
	 */
	private Screen activeScreen;
	
	/**
	 * ArrayList of all Screens that this DrawingSurface contains.
	 * 
	 * IMPORTANT!! Index of the Screen inside of this ArrayList corresponds to the
	 * code in the ScreenSwitcher superclass. For instance, screen.get(MENU_SCREEN) would
	 * run screen.get(0), and the Screen at index 0 should be the MenuScreen object.
	 */
	private ArrayList<Screen> screens;
	
	//Constructors
	public DrawingSurface() {
		
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
	 * Switches the current active Screen to the one at the given index.
	 * Ex: myDrawingSurface.switchScreen(ScreenSwitcher.MENU_SCREEN) should switch to the Menu Screen
	 * @param i Index of the Screen that this DrawingSurface should end displaying.
	 */
	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}

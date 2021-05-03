package frog;

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import frog.ScreenSwitcher;
import frog.screen.FrogDungeon;
import frog.screen.MenuScreen;
import frog.screen.PauseScreen;
import frog.screen.Screen;

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	//Fields
	
	/**
	 * ratioX and ratioY are the current scale of the game
	 */
	public float ratioX, ratioY;
	
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
		//adding all the screens, in order
		screens = new ArrayList<Screen>();
		
		MenuScreen menuScreen = new MenuScreen(this);
		screens.add(menuScreen);
		
		FrogDungeon gameScreen = new FrogDungeon(this);
		screens.add(gameScreen);
		
		PauseScreen pauseScreen = new PauseScreen(this);
		screens.add(pauseScreen);
		
		//setting current active screen to be the Main Menu
		activeScreen = screens.get(MENU_SCREEN);
		
		keys = new ArrayList<Integer>();
	}

	
	
	
	//Methods
	public void draw() {
		ratioX = (float) width / activeScreen.DRAWING_WIDTH;
		ratioY = (float) height / activeScreen.DRAWING_HEIGHT;
		
		pushMatrix();
		scale(ratioX, ratioY);
		activeScreen.draw();
		popMatrix();
		
		
	}
	
	public void keyPressed() {
		keys.add(keyCode);
	}
	
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}
	
	/**
	 * Checks if the given key is currently held down or not
	 * @param code The KeyCode of the key being checked
	 * @return true if key is pressed, false otherwise
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/**
	 * Assumed coordinates are the raw mouseX and mouseY values, which are then converted to the actual x and y expected post-scaling
	 * @param assumed
	 * @return
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int) (assumed.getX() / ratioX), (int) (assumed.getY() / ratioY));
	}
	
	public Point assumedCoordinatesToActual(int x, int y) {
		return assumedCoordinatesToActual(new Point(x, y));
	}
	
	/**
	 * Assumed coordinates are the raw mouseX and mouseY values, which are then converted to the actual x and y expected post-scaling
	 * @param actual
	 * @return
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int) (actual.getX() * ratioX), (int) (actual.getY() * ratioY));
	}
	
	public Point actualCoordinatesToAssumed(int x, int y) {
		return actualCoordinatesToAssumed(new Point(x, y));
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

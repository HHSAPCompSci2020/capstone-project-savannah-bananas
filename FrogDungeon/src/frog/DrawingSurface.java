package frog;

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import frog.ScreenSwitcher;
import frog.entities.Frog;
import frog.entities.Shopkeeper;
import frog.screen.BossGui;
import frog.screen.FrogDungeon;
import frog.screen.GameOverScreen;
import frog.screen.InfoScreen;
import frog.screen.MenuScreen;
import frog.screen.PauseScreen;
import frog.screen.Screen;
import frog.screen.ShopkeeperGui;

/**
 * Drawing surface that contains screens, and passes along mouse events to the active screen.
 * Most of this code is copied from Mr. Shelby's "ProcessingScreenSwitching" demo.
 * @author Justin Hwang
 *
 */
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
		
	}
	
	public void setup() {
		frameRate(60);
		// adding all the screens, in order
		screens = new ArrayList<Screen>();

		MenuScreen menuScreen = new MenuScreen(this);
		screens.add(menuScreen);

		FrogDungeon gameScreen = new FrogDungeon(this);
		screens.add(gameScreen);
		gameScreen.getFrog().setHealth(0);

		PauseScreen pauseScreen = new PauseScreen(this);
		screens.add(pauseScreen);

		InfoScreen infoScreen = new InfoScreen(this);
		screens.add(infoScreen);
		
		BossGui bossGui = new BossGui(this);
		screens.add(bossGui);
		
		ShopkeeperGui shopkeepGUI = new ShopkeeperGui(this);
		screens.add(shopkeepGUI);
		
		GameOverScreen gameOverScreen = new GameOverScreen(this);
		screens.add(gameOverScreen);
		//setting current active screen to be the Main Men
		activeScreen = screens.get(MENU_SCREEN);

		keys = new ArrayList<Integer>();
		

		surface.setResizable(false);
		
	}
	
	
	
	//Methods
	private long lastTime = 0;
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
	 * This will replace the current instance of FrogDungeon (the Screen) with a new instance of FrogDungeon
	 * @param screen
	 */
	public void resetGame() {
		screens.set(GAME_SCREEN, new FrogDungeon(this));
		
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
	
	public Screen getScreen(int i) {
		return screens.get(i);
	}

	public Frog getFrog() {
		Screen dungeon = screens.get(1);
		return ((FrogDungeon) dungeon).getFrog();
	}
}

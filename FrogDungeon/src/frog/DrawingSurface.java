package frog;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import processing.core.PApplet;
import frog.ScreenSwitcher;
import frog.entities.Frog;
import frog.entities.Shopkeeper;
import frog.screen.BossGui;
import frog.screen.BossRoom;
import frog.screen.FrogDungeon;
import frog.screen.GameOverScreen;
import frog.screen.InfoScreen;
import frog.screen.LoadGameScreen;
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
		
		BossRoom bossScreen = new BossRoom(this);
		screens.add(bossScreen);
		
		LoadGameScreen loadScreen = new LoadGameScreen(this);
		screens.add(loadScreen);
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
		activeScreen.keyPressed();
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
	
	public void loadGameFromFile(String filePath) {
		screens.set(GAME_SCREEN, new FrogDungeon(this, new File(filePath)));
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
	
	public void setMessage(String msg) {
		Screen dungeon = screens.get(1);
		((FrogDungeon) dungeon).setMessage(msg);
	}
	
	/**
	 * Sets the LoadGameScreen to be a new one, that contains all the files currently in the directory
	 */
	public void reloadSaveFiles() {
		screens.set(LOAD_GAME_SCREEN, new LoadGameScreen(this));
	}
	
	
	//Funky file stuff
	
	/**
	 * Saves the current FrogDungeon to file called <saveName>.yml inside folder "saves".
	 * If "saves" does not exist, this method will create it.
	 * If a file exists at saves/<saveName>.yml, this will overwrite.
	 * @param saveName Destination, without ".yml" at the end. For instance, "mySave" is valid, while "mySave.yml" is not.
	 * @return true is write was successful, false if not.
	 */
	public boolean saveToFile(String saveName) {
		ensureDirExists("saves");
		FrogDungeon gameScreen = (FrogDungeon) getScreen(GAME_SCREEN);
		
		/*
		File saveDir = new File("saves/" + saveName);
		if(saveDir.exists())
			removeDir(saveDir);
		ensureDirExists(saveDir);
		*/
		
		//deletes the current file at the destination if it exists, and creates a new empty file.
		File outputFile = new File("saves/" + saveName + ".yml");
		if(outputFile.exists()) {
			outputFile.delete();
		}
		
		try {
			outputFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//writes this object to the output file
		PrintWriter writer;
		try {
			writer = new PrintWriter(outputFile);
			Yaml yaml = new Yaml();
			//yaml.setBeanAccess(BeanAccess.FIELD);
			yaml.dump(gameScreen.asMap(), writer);
			//yaml.dump(gameScreen.getFrog(), writer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private boolean ensureDirExists(String path) {
		File file = new File(path);
		return ensureDirExists(file);
	}
	
	private boolean ensureDirExists(File file) {
		if(!file.exists())
			return file.mkdir();
		else
			return false;
	}
	
	private boolean removeDir(File directory) {
		File[] contents = directory.listFiles();
		if(contents != null) {
			for(File file : contents) {
				removeDir(file);
			}
		}
		return directory.delete();
	}
}

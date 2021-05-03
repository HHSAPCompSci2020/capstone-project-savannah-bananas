package frog.screen;

import java.util.ArrayList;

import frog.util.Button;
import processing.core.PApplet;
import frog.DrawingSurface;
import frog.entities.Frog;
import frog.entities.Monster;
import frog.misc.Wall;

public class FrogDungeon extends Screen {
	
	//Fields
	private Frog player;
	private ArrayList<Monster> monsters;
	private Button pauseButton;
	private boolean gamePaused;
	private ArrayList<Wall> walls;
	//private ArrayList<Interactable> interactables //chests, shopkeepers, signs, etc
	
	//Constructors
	/**
	 * Constructs a new FrogDungeon screen
	 * @param surface The DrawingSurface that the FrogDungeon Screen exists inside of
	 */
	public FrogDungeon (DrawingSurface surface) {
		super(surface);
		
		//TODO: Create pauseButton and add to "buttons" arraylist inherited from Screen superclass
	}
	
	//Methods
	
	/**
	 * Draws everything
	 */
	public void draw() {
		surface.background(0);
		surface.textAlign(PApplet.CENTER, PApplet.CENTER);
		surface.text("Game screen", 400, 300);
	}
	
	/**
	 * Is called when a Button is pressed
	 */
	@Override
	public void buttonPressed(Button button) {
		if(button.equals(pauseButton)) {
			//doStuff
		}
	}
	
	/**
	 * Generates maze.
	 */
	public void generateMaze() {
		
	}
	
	/**
	 * Draws monsters onto Maze.
	 */
	public void drawMonsters() {
		
	}
	
	/**
	 * Draws walls.
	 */
	public void drawWalls() {
		
	}
}

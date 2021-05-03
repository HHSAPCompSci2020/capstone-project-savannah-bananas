package frog.screen;

import java.awt.Button;
import java.util.ArrayList;

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
	}
	
	//Methods
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

package frog.screen;

import java.awt.event.KeyEvent;
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
		
		//adds all the walls to the maze
		walls = new ArrayList<Wall>();
		double mazeSize = 10.0;
		for(double x = 0; x <= mazeSize; x += 0.5) {
			if((int) x == x) { //if x is a whole number
				for(double y = 0.5; y < mazeSize; y++)
					walls.add(new Wall(x, y));
			} else { //x is not a whole number, walls are horizontal
				for(double y = 0; y <= mazeSize; y++)
					walls.add(new Wall(x, y));
			}
		}
		
		player = new Frog(300, 300, 50, 50, 100);
		
		pauseButton = new Button(20, 20, 150, 100);
		pauseButton.setText("Pause Game");
		pauseButton.setButtonListener(this);
		buttons.add(pauseButton);
		
		//TODO: Create pauseButton and add to "buttons" arraylist inherited from Screen superclass
	}
	
	//Methods
	
	/**
	 * Draws everything
	 */
	public void draw() {
		surface.background(0);
		surface.pushStyle();
		surface.textAlign(PApplet.CENTER, PApplet.CENTER);
		surface.text("Game screen", 400, 300);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.popStyle();
		
		player.draw(surface);
		
		if (surface.isPressed(KeyEvent.VK_W)) {
			//player.accelerate(0, -0.5);
			player.moveTo(player.getX(), player.getY()-5);
		}
		if (surface.isPressed(KeyEvent.VK_A)) {
			//player.accelerate(-0.5, 0);
			player.moveTo(player.getX()-5, player.getY());
		}
		if (surface.isPressed(KeyEvent.VK_S)) {
			//player.accelerate(0, 0.5);
			player.moveTo(player.getX(), player.getY()+5);
		}
		if (surface.isPressed(KeyEvent.VK_D)) {
			//player.accelerate(0.5, 0);
			player.moveTo(player.getX()+5, player.getY());
		}
		//player.accelerate(0, 1);
		player.move();
		
		for(Wall wall : walls) {
			wall.draw(surface);
		}
	}
	
	/**
	 * Is called when a Button is pressed
	 */
	@Override
	public void buttonPressed(Button button) {
		if(button.equals(pauseButton)) {
			surface.switchScreen(surface.PAUSE_SCREEN);
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

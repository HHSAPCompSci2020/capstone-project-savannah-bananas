package frog.screen;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import frog.util.Button;
import processing.core.PApplet;
import frog.DrawingSurface;
import frog.entities.Fly;
import frog.entities.Frog;
import frog.entities.Monster;
import frog.misc.*;

public class FrogDungeon extends Screen {
	
	//Fields
	private Frog player;
	private ArrayList<Monster> monsters;
	private Button pauseButton;
	private boolean gamePaused;
	private ArrayList<Wall> walls;
	private ArrayList<Item> items;
	private int ticks;
	public static final int MAZE_SIZE = 10; //Maze will be MAZE_SIZE by MAZE_SIZE tiles
	
	//private ArrayList<Interactable> interactables //chests, shopkeepers, signs, etc
	
	//Constructors
	/**
	 * Constructs a new FrogDungeon screen
	 * @param surface The DrawingSurface that the FrogDungeon Screen exists inside of
	 */
	public FrogDungeon (DrawingSurface surface) {
		super(surface);
		
		generateMaze(); //adds all the walls
		
		player = new Frog(300, 300, 50, 50, 100);
		items = new ArrayList<Item>();
		items.add(new HealthPotion(100, 100, 50, 50));
		items.add(new SpeedPotion(350, 500, 50, 50));
		items.add(new StrengthPotion(500, 350, 50, 50));
		
		monsters = new ArrayList<Monster>();
		monsters.add(new Fly(100, 300, 50, 50, 50));
		
		pauseButton = new Button(620, 20, 150, 100);
		pauseButton.setText("Pause Game");
		pauseButton.setButtonListener(this);
		buttons.add(pauseButton);
		
		ticks = 0;
		//TODO: Create pauseButton and add to "buttons" arraylist inherited from Screen superclass
	}
	
	//Methods
	
	/**
	 * Draws everything
	 */
	public void draw() {
		
		
		surface.pushMatrix();
		surface.background(0);
		surface.translate(0 - (int) player.getX() + 400, 0 - (int) player.getY() + 300); 
		
		surface.pushStyle();
		surface.textAlign(PApplet.CENTER, PApplet.CENTER);
		surface.fill(256, 256, 256);
		surface.text("Game screen", 400, 300);
		
		surface.popStyle();
		
		player.draw(surface);
		
		if (surface.isPressed(KeyEvent.VK_W)) {
			//player.accelerate(0, -0.5);
			player.moveTo(player.getX(), player.getY()-(5*player.getSpeed()));
		}
		if (surface.isPressed(KeyEvent.VK_A)) {
			//player.accelerate(-0.5, 0);
			player.moveTo(player.getX()-(5*player.getSpeed()), player.getY());
		}
		if (surface.isPressed(KeyEvent.VK_S)) {
			//player.accelerate(0, 0.5);
			player.moveTo(player.getX(), player.getY()+(5*player.getSpeed()));
		}
		if (surface.isPressed(KeyEvent.VK_D)) {
			//player.accelerate(0.5, 0);
			player.moveTo(player.getX()+(5*player.getSpeed()), player.getY());
		}
		//player.accelerate(0, 1);
		player.move();
		
		//WALLS DRAWING
		for(Wall wall : walls) {
			wall.draw(surface);
		}
		
		//ITEMS DRAWING
		for(int i = 0; i < items.size(); i++) {
			Rectangle hb = new Rectangle((int)(items.get(i).getX()), (int)(items.get(i).getY()), (int)(items.get(i).getWidth()), (int)(items.get(i).getHeight()));
			if(player.isTouching(hb)) {
				items.get(i).doAction(this);
				items.remove(i);
				i--;
			}
			else {
				items.get(i).draw(surface);
			}
			
		}
		
		//MONSTER DRAWINGS
		for(int i = 0; i < monsters.size(); i++) {
			if(monsters.get(i).getHealth() > 0) {
				
				monsters.get(i).draw(surface);
				Rectangle hb = new Rectangle((int)(monsters.get(i).getX()), (int)(monsters.get(i).getY()), (int)(monsters.get(i).getWidth()), (int)(monsters.get(i).getHeight()));
				if(player.isTouching(hb)) {
					//PUT THE DAMAGE METHOD HERE
					if(ticks % 60 == 0) {
						player.setHealth(player.getHealth()-5);
					}
					
					
				}
				
			}
			else {
				monsters.remove(i);
			}
		}
		
		
		surface.popMatrix();
		
		surface.fill(255);
		surface.rect(20, 20, 150, 100);
		surface.fill(0);
		surface.text("Health: " + player.getHealth() + "\nSpeed: " + player.getSpeed() + "\nStrength: " + player.getStrength(), 30, 50);

		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		ticks++;
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
	 * Generates a new maze.
	 * @post walls field will be populated with all walls
	 */
	public void generateMaze() {
		// adds all the walls to the maze
		walls = new ArrayList<Wall>();
		for (double x = 0; x <= MAZE_SIZE; x += 0.5) {
			if ((int) x == x) { // if x is a whole number
				for (double y = 0.5; y < MAZE_SIZE; y++)
					walls.add(new Wall(x, y));
			} else { // x is not a whole number, walls are horizontal
				for (double y = 0; y <= MAZE_SIZE; y++)
					walls.add(new Wall(x, y));
			}
		}
		
		ArrayList<Wall> wallsToProcess = new ArrayList<Wall>();
		ArrayList<Point> tilesAlreadyAdded = new ArrayList<Point>();
		
		tilesAlreadyAdded.add(new Point(0, 0)); //starts in upper left hand corner
		wallsToProcess.addAll(getNeighboringWalls(new Point(0, 0))); //adds four walls to start with
		
		while(wallsToProcess.size() > 0) {
			Wall wall = wallsToProcess.get((int) (Math.random() * wallsToProcess.size()));
			Point[] possibleTiles = wall.getBothNeighbors();
			
			Point newTile = null;
			
			if(!listContainsPoint(tilesAlreadyAdded, possibleTiles[0]) && isTileInMaze(possibleTiles[0])) {
				newTile = possibleTiles[0];
			} else if(!listContainsPoint(tilesAlreadyAdded, possibleTiles[1]) && isTileInMaze(possibleTiles[1])) {
				newTile = possibleTiles[1];
			}
			
			if(newTile != null) {
				tilesAlreadyAdded.add(newTile);
				
				//randomly generates if wall should be empty or a doorway. Doorway 1/3 of time, empty 2/3 of time
				int num = (int) (Math.random() * 3);
				if(num == 0)
					wall.setType(Wall.DOORWAY);
				else
					wall.setType(Wall.EMPTY);
				ArrayList<Wall> newWalls = getNeighboringWalls(newTile);
				for(Wall w : newWalls)
					if(!wallsToProcess.contains(w))
						wallsToProcess.add(w);
			}
			
			wallsToProcess.remove(wall);
		}
	}
	
	/**
	 * Returns true if point is within the maze, false if not
	 * @param point
	 * @return true if tile is in maze, false if tile is not within maze
	 */
	private boolean isTileInMaze(Point point) {
		return (point.x >= 0 && point.x < MAZE_SIZE && point.y >= 0 && point.y < MAZE_SIZE);
	}
	
	/**
	 * Returns true if an equivalent Point exists within the list, false if otherwise.
	 * (This must be used instead of list.contains(), because that searches for the same object, not for equivalent copies of the object)
	 */
	private boolean listContainsPoint(ArrayList<Point> list, Point point) {
		for(Point p : list)
			if(p.x == point.x && p.y == point.y)
				return true;
		return false;
	}
	
	/**
	 * Returns all Walls around the given tile
	 * @return ArrayList of Walls. Max length is 4, min length is 0 if no walls exist.
	 */
	private ArrayList<Wall> getNeighboringWalls(Point p) {
		ArrayList<Wall> neighbors = new ArrayList<Wall>();
		neighbors.add(getWallAt(p.x, p.y + 0.5));
		neighbors.add(getWallAt(p.x + 1, p.y + 0.5));
		neighbors.add(getWallAt(p.x + 0.5, p.y));
		neighbors.add(getWallAt(p.x + 0.5, p.y + 1));
		
		for(int i = neighbors.size() - 1; i >= 0; i--)
			if(neighbors.get(i) == null)
				neighbors.remove(i);
		
		return neighbors;
	}
	
	/**
	 * Returns the Wall at the given coordinates if it exists, null if it does not exist.
	 */
	private Wall getWallAt(double x, double y) {
		for(Wall wall : walls) {
			if(wall.getX() == x && wall.getY() == y)
				return wall;
		}
		return null;
	}
	
	public Frog getFrog() {
		return player;
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
	
	public void mousePressed() {
		for(int i = 0; i < monsters.size(); i++) {

			Rectangle hb = new Rectangle((int)(monsters.get(i).getX()), (int)(monsters.get(i).getY()), (int)(monsters.get(i).getWidth()), (int)(monsters.get(i).getHeight()));
			if(player.isTouching(hb)) {
				player.meleeAttack(monsters.get(i));
					
			}		
		}
	}
	
}

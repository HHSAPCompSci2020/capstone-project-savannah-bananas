package frog.misc;

import java.awt.Point;

import processing.core.PApplet;

public class Wall {

	//Fields
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public static final int DOORWAY = 2;
	private double x, y;
	private int type;
	
	//Constructor
	public Wall(double x, double y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	//Methods
	/**
	 * Returns an array of the points neighboring this tile.
	 * @return Point[], the list of points around this tile.
	 */
	public Point[] getNeighborTiles() {
		return null;
	}
	
	/**
	 * Draws this tile.
	 * @param marker, the PApplet to draw this tile on.
	 */
	public void draw(PApplet marker) {
		
	}
}

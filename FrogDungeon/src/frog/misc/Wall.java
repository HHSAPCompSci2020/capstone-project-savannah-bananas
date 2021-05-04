package frog.misc;

import java.awt.Color;
import java.awt.Point;

import processing.core.PApplet;

public class Wall {

	//Fields
	
	/**
	 * Color of default walls.
	 */
	public static final Color WALL_COLOR = new Color(0, 96, 255);
	
	/**
	 * The type field denotes which type of wall this is.
	 */
	private int type;
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public static final int DOORWAY = 2;
	
	/**
	 * Wall coordinates are weird. See explanation at
	 * https://drive.google.com/file/d/1D2pyQAjGkIvmENjzkDhlAM6YxHwHwzLL/view?usp=sharing
	 */
	private double x, y;
	
	/**
	 * Width and height will usually be set to the default width and height
	 */
	private int width, height;
	
	/**
	 * WALL_WIDTH should be greater than WALL_HEIGHT
	 * Original values of WALL_WIDTH and WALL_HEIGHT are 400 and 20, respectively
	 */
	public static final int WALL_WIDTH = 400;
	public static final int WALL_HEIGHT = 20;
	
	//Constructor
	/**
	 * Wall coordinates are weird. See example at
	 * https://drive.google.com/file/d/1D2pyQAjGkIvmENjzkDhlAM6YxHwHwzLL/view?usp=sharing
	 * Default type = WALL
	 * @param x
	 * @param y
	 */
	public Wall(double x, double y) {
		this.x = x;
		this.y = y;
		this.type = WALL;
		
		if(isHorizontal()) {
			this.width = WALL_WIDTH;
			this.height = WALL_HEIGHT;
		} else {
			this.width = WALL_HEIGHT;
			this.height = WALL_WIDTH;
		}
	}
	
	//Methods
	/**
	 * Returns the Point of the tile on the opposite side of the wall. Returned Point (tile) may be out of bounds
	 * @return Point of the tile on opposite side of the wall as the given one. If the given one does not neighbor the wall, then null is returned.
	 */
	public Point getTileOnOtherSide(Point p) {
		if(!neighborsTile(p))
			return null;
		
		if(isHorizontal()) {
			if(p.y == this.y)
				return new Point(p.x, p.y - 1);
			else // if(p.y == this.y + 1)
				return new Point(p.x, p.y + 1);
		} else { // is vertical
			if(p.x == this.x)
				return new Point(p.x - 1, p.y);
			else // if(p.x == this.x + 1)
				return new Point(p.x + 1, p.y);
		}
	}
	
	/**
	 * Returns two Points of tiles on either side of this wall. May be out of bounds.
	 * @return Array of two Points (always exactly 2 Points, no more, no less) of the neighboring tiles.
	 */
	public Point[] getBothNeighbors() {
		Point point1 = new Point((int) this.x, (int) this.y);
		return new Point[] {point1, getTileOnOtherSide(point1)};
	}
	
	/**
	 * Returns true if the Point (tile coordinates) neighbors this wall, false if not
	 */
	private boolean neighborsTile(Point p) {
		if(p.x == this.x || p.x == this.x + 1 || p.y == this.y || p.y == this.y + 1)
			return true;
		else
			return false;
	}
	
	/**
	 * Draws this tile.
	 * @param marker, the PApplet to draw this tile on.
	 * @post marker ends with same style as it starts with
	 */
	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.fill(WALL_COLOR.getRed(), WALL_COLOR.getGreen(), WALL_COLOR.getBlue());
		marker.noStroke();

		Point centerPoint = wallCoordsToPixelCoords(this.x, this.y);
		
		int width = this.width;
		int height = this.height;
		if(isHorizontal())
			width += this.height;
		else
			height += this.width;
		
		if(type == WALL) {
			marker.rect(centerPoint.x - width/2, centerPoint.y - height/2, width, height);
		} else if(type == DOORWAY) {
			if(isHorizontal()) {
				marker.rect(centerPoint.x - width/2, centerPoint.y - height/2, width/2 - height, height);
				marker.rect(centerPoint.x + height, centerPoint.y - height/2, width/2 - height, height);
			} else {
				marker.rect(centerPoint.x - width/2, centerPoint.y - height/2, width, height - height/2 - width);
				marker.rect(centerPoint.x - width/2, centerPoint.y + width, width, height - height/2 - width);
			}
		}
			
		marker.popStyle();
	}
	
	/**
	 * Returns Point that contains the pixel coordinates of the CENTER of the wall. NOT the upper left corner.
	 * @param x X-coordinate (in wall coords) of the wall
	 * @param y Y-coordinate (in wall coords) of the wall
	 * @return Point containing pixel coordinates of the CENTER of the wall, NOT the upper left corner
	 */
	public static Point wallCoordsToPixelCoords(double x, double y) {
		double newX = x * WALL_WIDTH;
		double newY = y * WALL_WIDTH;
		
		return new Point((int) newX, (int) newY);
	}
	
	/**
	 * Returns whether or not this tile is horizontal
	 * @return True if horizontal, false if vertical
	 */
	public boolean isHorizontal() {
		if(this.y == (int) this.y)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns whether or not this tile is vertical
	 * @return True if vertical, false if horizontal
	 */
	public boolean isVertical() {
		return !isHorizontal();
	}
	
	/**
	 * Sets wall type (wall, door, or empty)
	 */
	public void setType(int x) {
		this.type = x;
	}
	
	/**
	 * Gets wall type
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * Gets x
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Gets y
	 */
	public double getY() {
		return this.y;
	}
}

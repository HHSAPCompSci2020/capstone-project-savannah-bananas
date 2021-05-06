package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

/**
 * Abstract class that represents all consumable items, it has a method that allows it to do its funtion.
 * @author Jeremy Mills
 *
 */
public abstract class Item {
	//Fields
	protected double x, y;
	protected double width, height;
	
	//Constructor
	public Item(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//Methods
	/**
	 * Abstract method for all Items to draw themselves.
	 * @param marker, the PApplet to draw the item on
	 */
	public abstract void draw(PApplet marker);
	
	/**
	 * Abstract method for all items to do their intended feature.
	 * @param x, the FrogDungeon to access its fields for its effects.
	 */
	public abstract void doAction(FrogDungeon x);
	
	//Getters & Setters
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
}

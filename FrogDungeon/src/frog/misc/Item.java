package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

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
	public abstract void draw(PApplet marker);
	
	public abstract void doAction(FrogDungeon x);
	
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

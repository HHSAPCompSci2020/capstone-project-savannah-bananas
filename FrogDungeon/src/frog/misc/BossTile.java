package frog.misc;

import processing.core.PApplet;

public class BossTile {

	//Fields
	private double x, y;
	
	//Constructor
	public BossTile(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.fill(256, 0, 0);
		marker.rect((float)x, (float)y, 50f, 50f);
	}
	
	public void changeScreen() {
		
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	
}

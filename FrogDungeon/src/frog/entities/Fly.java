package frog.entities;

import processing.core.PApplet;

public class Fly extends Monster{

	//Fields
	public static final double FLY_DAMAGE = 0.0;
	
	//Constructors
	public Fly(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, FLY_DAMAGE);
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.fill(0, 0, 256);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
	}
}

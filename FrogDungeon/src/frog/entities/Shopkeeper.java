package frog.entities;

import processing.core.PApplet;

public class Shopkeeper extends Entity{

	public Shopkeeper(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
	}
	
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
		
	}

}

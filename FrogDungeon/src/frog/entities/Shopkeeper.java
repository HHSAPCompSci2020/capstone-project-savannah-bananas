package frog.entities;

import frog.DrawingSurface;
import processing.core.PApplet;

public class Shopkeeper extends Entity{

	public Shopkeeper(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
	}
	
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
		
	}

	public void changeScreen(DrawingSurface surface) {
		//System.out.println("yaya");
		surface.switchScreen(surface.SHOPKEEPER_GUI);
	}
}

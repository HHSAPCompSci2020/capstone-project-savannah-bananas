package frog.entities;

import frog.DrawingSurface;
import processing.core.PApplet;

/**
 * Represents a shopkeeper which you can interact with to bring up a shop GUI.
 * @author Jeremy Mills
 *
 */
public class Shopkeeper extends Entity{

	public Shopkeeper(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
	}
	
	/**
	 * Draws the Shopkeeper in the Grid
	 */
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
		
	}

	/**
	 * Changes the screen to the Shopkeeper GUI
	 * @param surface, the drawingsurface to switch screens.
	 */
	public void changeScreen(DrawingSurface surface) {
		//System.out.println("yaya");
		surface.switchScreen(surface.SHOPKEEPER_GUI);
	}
}

package frog.misc;

import frog.DrawingSurface;
import processing.core.PApplet;

/**
 * Represents the Boss Tile, where if you interact with it, it asks you if you want to go to the boss room.
 * @author Jeremy Mills
 *
 */
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
	
	public void changeScreen(DrawingSurface surface) {
		surface.switchScreen(surface.BOSS_GUI);
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public boolean isInsideTile(double x, double y) {
		if (this.x <= x && this.y <= y && (this.x + 50f) > x && (this.y + 50f) > y) 
			return true;
		
		return false;
	}
	
	
}

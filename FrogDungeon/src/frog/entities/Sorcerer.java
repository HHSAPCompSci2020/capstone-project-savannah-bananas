package frog.entities;

import processing.core.PApplet;

/**
 * Represents the Sorcerer final boss. Extends Monster.
 * @author Mikaela Kwan
 *
 */
public class Sorcerer extends Monster {

	//Fields
	public static final double SORCERER_DAMAGE = 20.0;
	public static final double SORCERER_RANGE = 500.0;
	public static final double SORCERER_SPEED = 10.0;
	public static final int SORCERER_COIN_VALUE = 15;
	
	//Constructors
	public Sorcerer(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, SORCERER_DAMAGE, SORCERER_RANGE, SORCERER_SPEED, SORCERER_COIN_VALUE);
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
		
	}
}

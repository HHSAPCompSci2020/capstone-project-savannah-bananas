package frog.entities;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a lower level fly monster that extends the Monster class.
 * @author Mikaela Kwan
 *
 */
public class Fly extends Monster{

	//Fields
	public static final double FLY_DAMAGE = 10.0;
	public static final double FLY_RANGE = 500.0;
	public static final double FLY_SPEED = 10.0;
	public static final int FLY_COIN_VALUE = 5;
	
	//Constructors
	public Fly(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, FLY_DAMAGE, FLY_RANGE, FLY_SPEED, FLY_COIN_VALUE);
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.pushStyle();
		
		PImage image = marker.loadImage("resources/fly.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
		
		
		//marker.fill(0, 0, 256);
		//marker.ellipse((float)x + (float)width/2, (float)y + (float)height/2, (float)width, (float)height);
		
		marker.noFill();
		marker.stroke(228, 74, 74);
		marker.rect((float) x, (float) y, (float) width, (float) height);
		marker.popStyle();
		
		super.draw(marker);
	}
}

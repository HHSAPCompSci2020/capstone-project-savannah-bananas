package frog.entities;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a higher level snake monster that extends the Monster class.
 * @author Mikaela Kwan
 *
 */
public class Snake extends Monster{

	//Fields
	public static final double SNAKE_DAMAGE = 15.0;
	public static final double SNAKE_RANGE = 500.0;
	public static final double SNAKE_SPEED = 15.0;
	public static final int SNAKE_COIN_VALUE = 10;
	private PImage snakeImage;
	
	//Constructors
	public Snake(double x, double y, double width, double height, double health, PApplet marker) {
		super(x, y, width, height, health, SNAKE_DAMAGE, SNAKE_RANGE, SNAKE_SPEED, SNAKE_COIN_VALUE);
		snakeImage = marker.loadImage("resources/knife.png");
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.pushStyle();
		
		marker.image(snakeImage, (float)x, (float)y, (float)width, (float)height);
		
		
		//marker.fill(0, 0, 256);
		//marker.ellipse((float)x + (float)width/2, (float)y + (float)height/2, (float)width, (float)height);
		
		marker.noFill();
		marker.stroke(228, 74, 74);
		marker.rect((float) x, (float) y, (float) width, (float) height);
		marker.popStyle();
		
		super.draw(marker);
	}
}

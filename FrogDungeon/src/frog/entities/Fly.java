package frog.entities;

import java.util.HashMap;
import java.util.Map;

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
	public static final double FLY_RANGE = 300.0;
	public static final double FLY_SPEED = 10.0;
	public static final int FLY_COIN_VALUE = 5;
	private PImage flyImage;
	
	//Constructors
	public Fly(double x, double y, double width, double height, double health, PApplet marker) {
		super(x, y, width, height, health, FLY_DAMAGE, FLY_RANGE, FLY_SPEED, FLY_COIN_VALUE);
		flyImage = marker.loadImage("resources/fly.png");
	}
	
	public Fly(Map<String, Object> map, PApplet marker) {
		super(map, FLY_DAMAGE, FLY_RANGE, FLY_SPEED, FLY_COIN_VALUE);
		flyImage = marker.loadImage("resources/fly.png");
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.pushStyle();
		
		marker.image(flyImage, (float)x, (float)y, (float)width, (float)height);
		
		
		//marker.fill(0, 0, 256);
		//marker.ellipse((float)x + (float)width/2, (float)y + (float)height/2, (float)width, (float)height);
		
		marker.noFill();
		marker.stroke(228, 74, 74);
		marker.rect((float) x, (float) y, (float) width, (float) height);
		marker.popStyle();
		
		super.draw(marker);
	}
	
	public Map<String, Object> asMap() {
		Map<String, Object> data = super.asMap();
		data.put("type", "Fly");
		return data;
	}
}

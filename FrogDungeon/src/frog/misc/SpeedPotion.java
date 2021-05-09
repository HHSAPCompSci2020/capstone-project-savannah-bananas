package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

/**
 * Represents a SpeedPotion that increases the speed of the player by a percentage when the player touches the potion.
 * @author Jeremy Mills
 *
 */
public class SpeedPotion extends Item{
	
	//Fields
	public static final double SPEED_BUFF = 0.05;
	
	//Constructors
	public SpeedPotion(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	//Methods
	public void draw(PApplet marker) {
		image = marker.loadImage("resources/speedpotion.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
	}

	public void doAction(FrogDungeon x) {
		x.getFrog().increaseSpeed(SPEED_BUFF);
		
	}

}

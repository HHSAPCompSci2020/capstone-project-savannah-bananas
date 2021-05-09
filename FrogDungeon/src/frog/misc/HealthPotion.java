package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

/**
 * Represents a HealthPotion that increases the health of the player. If the player runs over this potion, it increases the player's health by a constant.
 * @author Jeremy Mills
 *
 */
public class HealthPotion extends Item {

	public static final double POTION_HEALTH = 15;
	
	public HealthPotion(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	/**
	 * Draws this HealthPotion
	 * @param marker, the PApplet to draw the HealthPotion on.
	 */
	public void draw(PApplet marker) {
		image = marker.loadImage("resources/healthpotion.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
		//marker.fill(256, 0, 0);
		//marker.ellipse((float)x, (float)y, (float)width, (float)height);
	}
	
	/**
	 * Increases the players health by a constant
	 * @param x, the FrogDungeon that allows us to access its fields.
	 */
	public void doAction(FrogDungeon x) {
		x.getFrog().setHealth(x.getFrog().getHealth()+POTION_HEALTH);
	}

}

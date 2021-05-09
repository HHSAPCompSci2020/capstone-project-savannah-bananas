package frog.weapons;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A hammer class, that extends Melee Weapon, and deals a constant damage. To use, give the player this weapon in their meleeweapon field.
 * @author Jeremy Mills
 *
 */
public class Hammer extends MeleeWeapon{

	//Fields
	public static final double HAMMER_DAMAGE = 0.0;
	
	//Constructors
	public Hammer() {
		super(HAMMER_DAMAGE);
	}
	
	//Methods
	/**
	 * Draws this Hammer.
	 * @param marker, the PApplet to draw the Hammer on. 
	 */
	public void draw(PApplet marker, double x, double y, double width, double height) {
		PImage image = marker.loadImage("resources/hammer.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
	}
}

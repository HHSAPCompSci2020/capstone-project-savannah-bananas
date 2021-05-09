package frog.weapons;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A sword class, that extends Melee Weapon, and deals a constant damage. To use, give the player this weapon in their meleeweapon field.
 * @author Jeremy Mills
 *
 */
public class Sword extends MeleeWeapon{

	//Fields
	public static final double SWORD_DAMAGE = 0.0;
	
	//Constructors
	public Sword() {
		super(SWORD_DAMAGE);
	}
	
	//Methods
	/**
	 * Draws this Sword.
	 * @param marker, the PApplet to draw the Sword on. 
	 */
	public void draw(PApplet marker, double x, double y, double width, double height) {
		PImage image = marker.loadImage("resources/sword.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
	}
}

package frog.weapons;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A knife class, that extends Melee Weapon, and deals a constant amount of damage. To use, give the player this weapon in their meleeweapon field.
 * @author Jeremy Mills
 *
 */
public class Knife extends MeleeWeapon{

	//Fields
	public static final double KNIFE_DAMAGE = 25;
	private PImage knifeImage;
	
	//Constructors
	public Knife(PApplet marker) {
		super(KNIFE_DAMAGE);
		knifeImage = marker.loadImage("resources/knife.png");
	}
	
	//Methods
	/**
	 * Draws this Knife.
	 * @param marker, the PApplet to draw the Knife on. 
	 */
	public void draw(PApplet marker, double x, double y, double width, double height) {
		marker.image(knifeImage, (float)x, (float)y, (float)width, (float)height);
	}
	
	
}

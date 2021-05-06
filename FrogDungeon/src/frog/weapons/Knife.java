package frog.weapons;

import processing.core.PApplet;

/**
 * A knife class, that extends Melee Weapon, and deals a constant amount of damage. To use, give the player this weapon in their meleeweapon field.
 * @author Jeremy Mills
 *
 */
public class Knife extends MeleeWeapon{

	//Fields
	public static final double KNIFE_DAMAGE = 25;
	
	//Constructors
	public Knife() {
		super(KNIFE_DAMAGE);
	}
	
	//Methods
	/**
	 * Draws this Knife.
	 * @param marker, the PApplet to draw the Knife on. 
	 */
	public void draw(PApplet marker) {
		
	}
	
	
}

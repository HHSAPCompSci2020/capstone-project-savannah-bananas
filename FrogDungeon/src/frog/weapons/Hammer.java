package frog.weapons;

import processing.core.PApplet;

/**
 * A hammer class, that extends Melee Weapon
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
	public void draw(PApplet marker) {
		
	}
}

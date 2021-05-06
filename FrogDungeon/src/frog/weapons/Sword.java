package frog.weapons;

import processing.core.PApplet;

/**
 * A sword class, that extends Melee Weapon, and deals a constant damage.
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
	public void draw(PApplet marker) {
		
	}
}

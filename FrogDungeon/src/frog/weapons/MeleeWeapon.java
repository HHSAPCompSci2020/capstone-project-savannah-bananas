package frog.weapons;

import processing.core.PApplet;

/**
 * Abstract class that represents a melee weapon. All melee weapons will extend this class.
 * @author Jeremy Mills
 *
 */
public abstract class MeleeWeapon {

	//Fields
	private double damage;
	
	//Constructors
	public MeleeWeapon(double damage) {
		this.damage = damage;
	}
	
	//Methods
	/**
	 * Draws this MeleeWeapon.
	 * @param marker, the PApplet to draw the MeleeWeapon on. 
	 */
	public void draw(PApplet marker) {
		
	}
	
	public double getDamage() {
		return damage;
	}
}

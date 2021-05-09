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
	public abstract void draw(PApplet marker, double x, double y, double width, double height);
	
	public double getDamage() {
		return damage;
	}
}

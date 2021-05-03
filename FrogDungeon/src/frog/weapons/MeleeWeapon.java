package frog.weapons;

import processing.core.PApplet;

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
}

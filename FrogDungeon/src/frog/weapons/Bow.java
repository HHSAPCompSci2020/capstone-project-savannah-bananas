package frog.weapons;

import processing.core.PApplet;

public class Bow extends ProjectileWeapon {
	
	//Fields
	public static final double BOW_DAMAGE = 0.0;
	public static final double BOW_RANGE = 0.0;
	public static final double BOW_SPEED = 0.0;
	
	//Constructors
	public Bow() {
		super(BOW_DAMAGE, BOW_RANGE, BOW_SPEED);
	}
		
	//Methods
	/**
	 * Draws this bow.
	 * @param draw, the PApplet to draw the bow on.
	 */
	public void draw(PApplet draw) {
		
	}
	
	/**
	 * Shoots this bow to the point (x, y)
	 * @param x, the x coordinate of the target
	 * @param y, the y coordinate of the target
	 */
	public void shoot(int x, int y) {
		
	}
}

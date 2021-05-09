package frog.weapons;

import processing.core.PApplet;

/**
 * A pistol class that extends Projectile Weapon
 * @author Mikaela Kwan
 *
 */

public class Pistol extends ProjectileWeapon{

	//Fields
	public static final double PISTOL_DAMAGE = 0.0;
	public static final double PISTOL_RANGE = 0.0;
	public static final double PISTOL_SPEED = 0.0;
	
	//Constructors
	public Pistol() {
		super(PISTOL_DAMAGE, PISTOL_RANGE, PISTOL_SPEED);
	}
	
	//Methods
	/**
	 * Draws this pistol.
	 * @param draw, the PApplet to draw the pistol on.
	 */
	public void draw(PApplet marker, double x, double y, double width, double height) {
		
	}
	
	/**
	 * Shoots this pistol to the point (x, y)
	 * @param x, the x coordinate of the target
	 * @param y, the y coordinate of the target
	 */
	public void shoot(int x, int y) {
		
	}
}

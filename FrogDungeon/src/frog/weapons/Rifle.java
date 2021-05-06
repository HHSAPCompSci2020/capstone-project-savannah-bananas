package frog.weapons;

import processing.core.PApplet;


/**
 * A rifle class that extends Projectile Weapon
 * @author Mikaela Kwan
 *
 */

public class Rifle extends ProjectileWeapon{
	
	//Fields
	public static final double RIFLE_DAMAGE = 0.0;
	public static final double RIFLE_RANGE = 0.0;
	public static final double RIFLE_SPEED = 0.0;
	
	//Constructors
	public Rifle() {
		super(RIFLE_DAMAGE, RIFLE_RANGE, RIFLE_SPEED);
	}
	
	//Methods
	/**
	 * Draws this rifle.
	 * @param draw, the PApplet to draw the rifle on.
	 */
	public void draw(PApplet draw) {
		
	}
	
	/**
	 * Shoots this rifle to the point (x, y)
	 * @param x, the x coordinate of the target
	 * @param y, the y coordinate of the target
	 */
	public void shoot(int x, int y) {
		
	}
}

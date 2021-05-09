package frog.weapons;

import processing.core.PApplet;

/**
 * An abstract class that represents a projectile weapon. All projectile weapons will extend this class.
 * @author Mikaela Kwan
 *
 */

public abstract class ProjectileWeapon {

	//Fields
	private double damage;
	private double range;
	private double shootingSpeed;
	
	//Constructors
	public ProjectileWeapon(double damage, double range, double speed) {
		this.damage = damage;
		this.range = range;
		this.shootingSpeed = speed;
	}
	
	//Methods
	/**
	 * Draws this projectile weapon.
	 * @param draw, the PApplet to draw the projectile weapon on.
	 */
	public abstract void draw(PApplet marker, double x, double y, double width, double height);
	
	/**
	 * Shoots this projectile weapon to the point (x, y)
	 * @param x, the x coordinate of the target
	 * @param y, the y coordinate of the target
	 */
	public void shoot(int x, int y) {
		
	}
}

package frog.weapons;

/**
 * A class that represents a projectile fired from a projectile weapon.
 * @author Mikaela Kwan
 *
 */

public class Projectile {

	//Fields
	private double x, y;
	private double range;
	private double damage;
	private double shootingSpeed;
	
	
	
	//Constructor
	public Projectile(double x, double y, double damage, double range, double shootingSpeed) {
		this.x = x;
		this.y = y;
		this.damage = damage;
		this.range = range;
		this.shootingSpeed = shootingSpeed;
	}
	
	//Methods
	public void move(double x, double y) {
		
	}
	
	public void moveTo(double tX, double tY) {
		
	}
}

package frog.weapons;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A bow class that extends Projectile Weapon
 * @author Mikaela Kwan
 *
 */
public class Bow extends ProjectileWeapon {
	
	//Fields
	public static final double BOW_DAMAGE = 7.0;
	public static final double BOW_RANGE = 300.0;
	public static final double BOW_SPEED = 3;
	
	//Constructors
	public Bow() {
		super(BOW_DAMAGE, BOW_RANGE, BOW_SPEED);
	}
		
	//Methods
	/**
	 * Draws this bow.
	 * @param draw, the PApplet to draw the bow on.
	 */
	public void draw(PApplet marker, double x, double y, double width, double height) {
		PImage image = marker.loadImage("resources/bow.png");
		marker.image(image, (float)x, (float)y, (float)width, (float)height);
	}
	
	/**
	 * Shoots this bow to the point (x, y)
	 * @param x, the x coordinate of the target
	 * @param y, the y coordinate of the target
	 */
	public void shoot(int startX, int startY, int endX, int endY) {
		super.shoot(startX, startY, endX, endY);
		
	}
}

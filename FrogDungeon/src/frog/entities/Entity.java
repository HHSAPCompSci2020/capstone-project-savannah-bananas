package frog.entities;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Entity {
	//Fields
	protected double x, y, width, height;
	protected double vX, vY;
	protected double health;
	protected PImage image;
	
	//Constructors
	public Entity(double x, double y, double width, double height, double health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		vX = 0;
		vY = 0;
	}
	
	//Methods
	/**
	 * Detects if this entity is touching another entity.
	 * @param other, the entity that is tested with this entity.
	 * @return boolean, true if they are touching, false if not.
	 */
	public boolean isTouching(Entity other) {
		return false;
	}
	
	/**
	 * Moves the entity based on its velocity.
	 */
	public void move() {
		x += vX;
		y += vY;
	}
	
	/**
	 * Changes the entity's velocity by accelerating.
	 * @param aX, the value to add to the x velocity.
	 * @param aY, the value to add to the y velocity
	 */
	public void accelerate(double aX, double aY) {
		vX += aX;
		vY += aY;
	}
	
	/**
	 * Moves the entity to the point (x, y).
	 * @param x, The x coordinate of the new location.
	 * @param y, The y coordinate of the new location.
	 */
	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Deals damage to the entity by a specific amount.
	 * @param amount, the amount of health that is being lost.
	 */
	public void damage(double amount) {
		
	}
	
	/**
	 * Draws the Entity's image
	 * @param marker, the PApplet to draw the entity on.
	 */
	public void draw(PApplet marker) {
		
	}
	
	//Getters
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public double getHealth() {
		return health;
	}
	
}

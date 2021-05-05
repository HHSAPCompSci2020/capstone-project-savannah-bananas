package frog.entities;

import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Entity {
	//Fields
	protected double x, y, width, height;
	protected double vX, vY;
	protected double health;
	protected double speedMultiplyer, strengthMultiplyer;
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
	 * Detects if this entity is touching a rectangle belonging to another entity/item/projectile.
	 * @param other, the rectangle hitbox of another entity/item/projectile.
	 */
	public boolean isTouching(Rectangle other) {
		Rectangle r1 = new Rectangle((int)x, (int)y, (int)width, (int)height);
		if(r1.contains(new Point((int)other.getX(), (int)other.getY()))) {
			return true;
		}
		else if(r1.contains(new Point((int)(other.getX() + other.getWidth()), (int)other.getY()))) {
			return true;
		}
		else if(r1.contains(new Point((int)other.getX(), (int)(other.getY() + other.getHeight())))) {
			return true;
		}
		else if(r1.contains(new Point((int)(other.getX() + other.getWidth()), (int)(other.getY() + other.getHeight())))) {
			return true;
		}
		
		if(other.contains(new Point((int)x, (int)y))) {
			return true;
		}
		else if(other.contains(new Point((int)(x + width), (int)y))) {
			return true;
		}
		else if(other.contains(new Point((int)x, (int)(y + height)))) {
			return true;
		}
		else if(other.contains(new Point((int)(x + width), (int)(y + height)))) {
			return true;
		}
		
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
	public void setHealth(double amount) {
		health = amount;
	}
	public double getSpeed() {
		return speedMultiplyer;
	}
	public double getStrength() {
		return strengthMultiplyer;
	}
	public void increaseSpeed(double amount) {
		speedMultiplyer += amount;
	}
	public void increaseStrength(double amount) {
		strengthMultiplyer += amount;
	}
}

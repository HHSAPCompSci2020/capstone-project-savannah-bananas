package frog.weapons;

import java.util.ArrayList;

import frog.entities.Monster;
import frog.misc.Wall;
import processing.core.PApplet;

/**
 * A class that represents a projectile fired from a projectile weapon.
 * @author Mikaela Kwan
 *
 */

public class Projectile {

	//Fields
	private double x, y;
	private double deltaX, deltaY;
	private double range;
	private double damage;
	private double shootingSpeed;
	private double dir;
	private double distanceTraveled;
	
	
	//Constructor
	public Projectile(double startX, double startY, double endX, double endY, double damage, double range, double shootingSpeed) {
		// KAELA'S CODE AS OF 5/10/2021, 12:23 AM
		/*this.x = startX;
		this.y = startY;
		this.deltaX = endX - startX;
		this.deltaY = endY - startY;
		this.damage = damage;
		this.range = range;
		this.shootingSpeed = shootingSpeed;
			
		dir = Math.atan(deltaY / deltaX);
		System.out.println(dir);*/

		//JUSTIN'S CODE
		this.x = startX;
		this.y = startY;
		this.deltaX = endX - startX;
		this.deltaY = startY - endY; //flipped because downwards Y is positive
		this.damage = damage;
		this.range = range;
		this.shootingSpeed = shootingSpeed;
		this.distanceTraveled = 0;
			
		dir = Math.atan(deltaY / deltaX);
		if(deltaX < 0)
			dir = Math.PI + dir;
		//System.out.println(dir);
	}
	
	//Methods
	
	public void draw(PApplet surface) {
		surface.fill(255);
		surface.circle((float)x, (float)y, 10);
	}
	
	public void move() {
		
		x += (shootingSpeed * Math.cos(dir));
		y -= (shootingSpeed * Math.sin(dir)); //flipped because downwards Y is positive
		distanceTraveled += shootingSpeed;
		/*
		double temp = dir * (shootingSpeed + x) + intercept;
		x += shootingSpeed;
		y = temp;
		*/

	}
	
	/*
	public void setHasTarget(boolean hasTargetIn)
	{
	    if (hasTargetIn)
	    {
	        deltaX = getTargetX() - getX();
	        deltaY = getTargetY() - getY();
	        direction = Math.atan(deltaY / deltaX); // Math.atan2(deltaY, deltaX) does the same thing but checks for deltaX being zero to prevent divide-by-zero exceptions
	        speed = 5.0;
	    }
	    hasTarget = hasTargetIn;
	}

	public void setNext()
	{
	    setX(getX() + (speed * Math.cos(direction)));
	    setY(getY() + (speed * Math.sin(direction)));
	}
	*/
	public void moveTo(double tX, double tY) {
		this.x = tX;
		this.y = tY;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean shouldDie() {
		return distanceTraveled > range;
	}
}

package frog.entities;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import frog.DrawingSurface;
import frog.misc.Wall;
import frog.weapons.*;
import processing.core.PApplet;

/**
 * Represents a frog that extends Entity. Contains one melee and one projectile weapon.
 * @author Jeremy Mills
 *
 */

public class Frog extends Entity{
	
	//Fields
	private MeleeWeapon melee;
	private ProjectileWeapon ranged;
	
	//Constructors
	public Frog(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
		speedMultiplyer = 1;
		strengthMultiplyer = 1;
		melee = new Knife();
	}

	//Methods
	/**
	 * Moves the Frog through the maze. Also handles user input.
	 * @param walls, the Walls that are in the maze.
	 * @param surface The DrawingSurface that the Frog is drawn in.
	 */
	public void move(ArrayList<Wall> walls, DrawingSurface surface) {
		
		double baseSpeed = 5.0;
		
		if (surface.isPressed(KeyEvent.VK_W))
			vY = 0 - (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_A))
			vX = 0 - (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_S))
			vY = (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_D))
			vX = (baseSpeed * getSpeed());

		if(!surface.isPressed(KeyEvent.VK_W) && !surface.isPressed(KeyEvent.VK_S))
			vY = 0;
		if(!surface.isPressed(KeyEvent.VK_A) && !surface.isPressed(KeyEvent.VK_D))
			vX = 0;
		
		super.move();
	}
	
	/**
	 * Detects if this Frog is touching the given wall.
	 * @param wall, the Wall that is being tested.
	 * @return boolean, true if they are touching, false if they are not.
	 */
	public boolean isTouchingWall(Wall wall) {
		return false;
	}
	
	/**
	 * Shoots the ranged weapon that this frog has.
	 * @param x, the x coordinate of where the frog is shooting.
	 * @param y, the y coordinate of where the frog is shooting.
	 */
	public void shootRangedWeapon(int x, int y) {
		
	}
	
	/**
	 * Attacks using the melee weapon that the frog has.
	 * @param monster, the Monster which is taking the damage
	 */
	public void meleeAttack(Monster monster) {
		monster.setHealth(monster.getHealth() - melee.getDamage());
	}
	
	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.fill(0, 256, 0);
		marker.ellipse((float)(x+width/4), (float)(y), (float)width, (float)height);
		marker.fill(0);
		marker.text("Frog", (float)x, (float)y);
		marker.popStyle();
	}

	
}

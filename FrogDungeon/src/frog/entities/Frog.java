package frog.entities;

import java.util.ArrayList;

import frog.misc.Wall;
import frog.weapons.*;
import processing.core.PApplet;

public class Frog extends Entity{
	
	//Fields
	private MeleeWeapon melee;
	private ProjectileWeapon ranged;
	
	//Constructors
	public Frog(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
	}

	//Methods
	/**
	 * Moves the Frog through the maze.
	 * @param walls, the Walls that are in the maze.
	 */
	public void move(ArrayList<Wall> walls) {
		
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
	 * @param x, the x coordinate of where the frog is attacking.
	 * @param y, the y coordinate of where the frog is attacking.
	 */
	public void meleeAttack(int x, int y) {
		
	}
	
	
}

package frog.entities;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A monster class where all monsters extend this class.
 * @author Jeremy Mills
 *
 */
public abstract class Monster extends Entity {

	//Fields
	protected double damage;
	
	//Constructors
	public Monster(double x, double y, double width, double height, double health, double damage) {
		super(x, y, width, height, health);
		this.damage = damage;
		
	}
		
	//Methods
	/**
	 * Attacks the Frog given using its damage field.
	 * @param player, the Frog that is going to take the damage.
	 */
	public void attackPlayer(Frog player) {
		
	}
}

package frog.entities;


/**
 * Represents the Sorcerer final boss. Extends Monster.
 * @author Mikaela Kwan
 *
 */
public class Sorcerer extends Monster {

	//Fields
	public static final double SORCERER_DAMAGE = 0.0;
	public static final double SORCERER_RANGE = 0.0;
	public static final double SORCERER_SPEED = 0.0;
	
	//Constructors
	public Sorcerer(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, SORCERER_DAMAGE, SORCERER_RANGE, SORCERER_SPEED);
	}
	
	//Methods
}

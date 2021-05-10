package frog.entities;

/**
 * Represents a higher level snake monster that extends the Monster class.
 * @author Mikaela Kwan
 *
 */
public class Snake extends Monster{

	//Fields
	public static final double SNAKE_DAMAGE = 0.0;
	public static final double SNAKE_RANGE = 0.0;
	public static final double SNAKE_SPEED = 0.0;
	public static final int SNAKE_COIN_VALUE = 10;
	
	//Constructors
	public Snake(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, SNAKE_DAMAGE, SNAKE_RANGE, SNAKE_SPEED, SNAKE_COIN_VALUE);
	}
	
	//Methods
}

package frog.entities;

public class Snake extends Monster{

	//Fields
	public static final double SNAKE_DAMAGE = 0.0;
	
	//Constructors
	public Snake(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, SNAKE_DAMAGE);
	}
	
	//Methods
}

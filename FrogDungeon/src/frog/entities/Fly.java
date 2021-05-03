package frog.entities;

public class Fly extends Monster{

	//Fields
	public static final double FLY_DAMAGE = 0.0;
	
	//Constructors
	public Fly(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health, FLY_DAMAGE);
	}
	
	//Methods
}

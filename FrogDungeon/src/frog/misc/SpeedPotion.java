package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

public class SpeedPotion extends Item{
	
	//Fields
	public static final double SPEED_BUFF = 0.05;
	
	//Constructors
	public SpeedPotion(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	//Methods
	public void draw(PApplet marker) {
		marker.fill(135,206,250);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
	}

	public void doAction(FrogDungeon x) {
		x.getFrog().increaseSpeed(SPEED_BUFF);
		
	}

}

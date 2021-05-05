package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

public class StrengthPotion extends Item{

	//Fields
	public static final double STRENGTH_BUFF = 0.2;
	
	//Constructors
	public StrengthPotion(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	//Methods
	public void draw(PApplet marker) {
		marker.fill(128,0,0);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
	}
	
	public void doAction(FrogDungeon x) {
		x.getFrog().increaseStrength(STRENGTH_BUFF);
	}

}

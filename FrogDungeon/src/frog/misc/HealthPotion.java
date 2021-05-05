package frog.misc;

import frog.screen.FrogDungeon;
import processing.core.PApplet;

public class HealthPotion extends Item {

	public HealthPotion(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	public void draw(PApplet marker) {
		marker.fill(256, 0, 0);
		marker.ellipse((float)x, (float)y, (float)width, (float)height);
	}
	
	public void doAction(FrogDungeon x) {
		x.getFrog().setHealth(x.getFrog().getHealth()+15);
	}

}

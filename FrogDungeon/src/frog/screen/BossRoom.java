package frog.screen;

import frog.DrawingSurface;
import frog.entities.Frog;
import frog.util.Button;
import processing.core.PApplet;

public class BossRoom extends Screen {

	private Frog player;
	public BossRoom(DrawingSurface surface) {
		super(surface);
		player = this.surface.getFrog();
	}

	public void draw(PApplet marker) {
		System.out.println("draw");
		surface.background(0);
		player.move();
		
		surface.pushMatrix();
		//surface.background(0);
		surface.translate(0 - (float) player.getX() - (float) player.getWidth()/2 + 400, 0 - (float) player.getY() - (float) player.getHeight()/2 + 300); 
		player.draw(marker);
		surface.popMatrix();
	}
	public void buttonPressed(Button button) {
		
	}

}

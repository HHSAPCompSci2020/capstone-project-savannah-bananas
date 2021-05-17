package frog.screen;

import frog.DrawingSurface;
import frog.entities.Frog;
import frog.entities.Sorcerer;
import frog.util.Button;
import processing.core.PApplet;
import processing.core.PImage;

public class BossRoom extends Screen {

	private Frog player;
	private Sorcerer boss;
	private PImage frame1;
	private PImage frame2;
	private int ticks;
	
	public BossRoom(DrawingSurface surface) {
		super(surface);
		player = this.surface.getFrog();
		player.moveTo(100, 100);
		//player.setHealth(100);
		boss = new Sorcerer(600, 600, 100, 100, 500);
		
		frame1 = surface.loadImage("resources/frame1.png");
		frame2 = surface.loadImage("resources/frame2.png");
		ticks = 0;
	}

	public void draw() {
		
		surface.background(28, 29, 30);
		player.move(null, surface);
		//surface.background(0);
		//surface.translate(0 - (float) player.getX() - (float) player.getWidth()/2 + 400, 0 - (float) player.getY() - (float) player.getHeight()/2 + 300); 
		player.draw(surface);
		boss.move(null, player.getX(), player.getY());
		boss.draw(surface);
		
		surface.fill(255);
		surface.image(frame1, -5, -10, 200, 150);
		//surface.rect(20, 20, 150, 100);
		surface.fill(0);
		surface.text("Health: " + player.getHealth() + "\nSpeed: " + player.getSpeed() + "\nStrength: " + player.getStrength() + "\nCoins: " + player.getCoins(), 50, 45);
		surface.fill(255);
		surface.rect(200, 30, 200, 35);
		surface.fill(228, 74, 74);
		surface.rect(200, 30, (float)((player.getHealth()/100)*200), 35);
		surface.fill(255);
		
		//System.out.println(currentMessages.size());
		surface.pushStyle();
		

		
		surface.popStyle();
			
		
		surface.image(frame2, 425, -10, 180, 150);
		
		if(player.getMelee() != null) {
			player.getMelee().draw(surface, 450, 40, 50, 50);
		}
		if(player.getProjectile() != null) {
			player.getProjectile().draw(surface, 525, 40, 50, 50);
		}
		
		
		ticks++;
		
	}
	public void buttonPressed(Button button) {
		
	}

}

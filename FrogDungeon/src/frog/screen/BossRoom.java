package frog.screen;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import frog.DrawingSurface;
import frog.entities.Frog;
import frog.entities.Monster;
import frog.entities.Sorcerer;
import frog.util.Button;
import frog.weapons.Projectile;
import processing.core.PApplet;
import processing.core.PImage;

public class BossRoom extends Screen {

	private Sorcerer boss;
	private double bossMaxHealth;
	private PImage frame1;
	private PImage frame2;
	private int ticks;
	
	public BossRoom(DrawingSurface surface) {
		super(surface);
		//double health = surface.getFrog().getHealth();
		
		surface.getFrog().moveTo(0, 0);
		//player.setHealth(health);
		boss = new Sorcerer(600, 600, 100, 100, 1000);
		bossMaxHealth = boss.getHealth();
		
		frame1 = surface.loadImage("resources/frame1.png");
		frame2 = surface.loadImage("resources/frame2.png");
		ticks = 0;
	}

	public void draw() {
		
		surface.background(28, 29, 30);
		surface.getFrog().move(null, surface);
		//surface.background(0);
		//surface.translate(0 - (float) player.getX() - (float) player.getWidth()/2 + 400, 0 - (float) player.getY() - (float) player.getHeight()/2 + 300); 
		surface.getFrog().draw(surface);
		boss.move(null, surface.getFrog().getX(), surface.getFrog().getY());
		boss.draw(surface);
		
		ArrayList<Projectile> p = surface.getFrog().getProjectile().getProjectiles();
		if (p.size() > 0)
		for (int i = 0; i < p.size(); i++) {
			ArrayList<Monster> m = new ArrayList<Monster>();
			m.add(boss);
			if(p.get(i).shouldDie() || p.get(i).hitMonster(m)) {
				p.remove(i);
				i--;
			} else {
				p.get(i).move();
				p.get(i).draw(surface);
			}
		}
		
		
		surface.fill(255);
		surface.image(frame1, -5, -10, 200, 150);
		//surface.rect(20, 20, 150, 100);
		surface.fill(0);
		surface.text("Health: " + surface.getFrog().getHealth() + "\nSpeed: " + surface.getFrog().getSpeed() + "\nStrength: " + surface.getFrog().getStrength() + "\nCoins: " + surface.getFrog().getCoins(), 50, 45);
		surface.fill(255);
		surface.rect(200, 30, 200, 35);
		surface.fill(228, 74, 74);
		surface.rect(200, 30, (float)((surface.getFrog().getHealth()/100)*200), 35);
		surface.fill(228, 74, 74);
		surface.rect(200,  500,  (float)(boss.getHealth()/bossMaxHealth*300), 45);
		
		surface.fill(255);
		
		//System.out.println(currentMessages.size());

			
		
		surface.image(frame2, 425, -10, 180, 150);
		
		if(surface.getFrog().getMelee() != null) {
			surface.getFrog().getMelee().draw(surface, 450, 40, 50, 50);
		}
		if(surface.getFrog().getProjectile() != null) {
			surface.getFrog().getProjectile().draw(surface, 525, 40, 50, 50);
		}
		
		
		ticks++;
		
	}
	public void buttonPressed(Button button) {
		
	}

	public void mousePressed() {
		
		if (surface.mouseButton == surface.LEFT) {

			Rectangle hb = new Rectangle((int)(boss.getX()), (int)(boss.getY()), (int)boss.getWidth(), (int)boss.getHeight());
				if(surface.getFrog().isTouching(hb)) {
					surface.getFrog().meleeAttack(boss);
						
				}		
		}
		else if (surface.mouseButton == surface.RIGHT) {
				//System.out.println("Click X = " + surface.mouseX + ", Click Y = " + surface.mouseY);
				Point p = surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY);
				surface.getFrog().shootRangedWeapon(p.x,  p.y, surface);

		}
		
	}
}

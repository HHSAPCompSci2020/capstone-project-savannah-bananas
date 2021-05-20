package frog.screen;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import frog.DrawingSurface;
import frog.entities.Fly;
import frog.entities.Frog;
import frog.entities.Monster;
import frog.entities.Sorcerer;
import frog.misc.Wall;
import frog.util.Button;
import frog.weapons.Projectile;
import processing.core.PApplet;
import processing.core.PImage;

public class BossRoom extends Screen {

	private Sorcerer boss;
	private ArrayList<Monster> monsters;
	private double bossMaxHealth;
	private PImage frame1;
	private PImage frame2;
	private int ticks;
	private ArrayList<Wall> walls;
	
	public BossRoom(DrawingSurface surface) {
		super(surface);
		//double health = surface.getFrog().getHealth();
		walls = new ArrayList<Wall>();
		walls.add(new Wall(-20.0, -20.0, 840.0, 20.0, true));
		walls.add(new Wall(-20.0, -20.0, 20.0, 840.0, false));
		walls.add(new Wall(800.0, -20.0, 20.0, 840.0, false));
		walls.add(new Wall(-20.0, 800.0, 840.0, 20.0, true));
		//surface.getFrog().moveTo(50, 50);
		//((FrogDungeon)(surface.getScreen(DrawingSurface.GAME_SCREEN))).getFrog().moveTo(50, 50);
		//player.setHealth(health);
		boss = new Sorcerer(600, 600, 100, 100, 1000);
		bossMaxHealth = boss.getHealth();
		
		monsters = new ArrayList<Monster>();
		monsters.add(boss);
		
		frame1 = surface.loadImage("resources/frame1.png");
		frame2 = surface.loadImage("resources/frame2.png");
		ticks = 0;
	}
	
	public void resetPlayerPosition() {
		surface.getFrog().moveTo(20, 20);
	}

	public void draw() {
		surface.background(28, 29, 30);
		surface.getFrog().move(walls, surface);
		//surface.background(0);
		//surface.translate(0 - (float) player.getX() - (float) player.getWidth()/2 + 400, 0 - (float) player.getY() - (float) player.getHeight()/2 + 300); 
		surface.getFrog().draw(surface);
		
		for(int i = 0; i < monsters.size(); i++) {
			monsters.get(i).draw(surface);
		}
		
		
		ArrayList<Projectile> p = surface.getFrog().getProjectile().getProjectiles();
		if (p.size() > 0)
		for (int i = 0; i < p.size(); i++) {
			if(p.get(i).shouldDie() || p.get(i).hitMonster(monsters)) {
				p.remove(i);
				i--;
			} else {
				p.get(i).move();
				p.get(i).draw(surface);
			}
		}
		
		ArrayList<Projectile> pBoss = boss.getBow().getProjectiles();
		if (pBoss.size() > 0) {
			for (int i = 0; i < pBoss.size(); i++) {
				if(pBoss.get(i).shouldDie()) {
					monsters.add(new Fly(pBoss.get(i).getX(), pBoss.get(i).getY(), 50, 50, 50, surface));
				}
				if(pBoss.get(i).shouldDie() || pBoss.get(i).hitPlayer(surface.getFrog())) {
					pBoss.remove(i);
					surface.getFrog().setHealth(surface.getFrog().getHealth()-10);
					i--;
				} else {
					pBoss.get(i).move();
					pBoss.get(i).draw(surface);
				}
			}
		}
		
		for(int i = 0; i < monsters.size(); i++) {
			monsters.get(i).move(walls, monsters, surface.getFrog().getX(), surface.getFrog().getY());
			Rectangle hb = new Rectangle((int)monsters.get(i).getX(), (int)monsters.get(i).getY(), (int)monsters.get(i).getWidth(), (int)monsters.get(i).getHeight());
			if(surface.getFrog().isTouching(hb) && ticks%60 == 0) {
				surface.getFrog().setHealth(surface.getFrog().getHealth()-boss.getDamage());
			}
			
			if(monsters.get(i).getHealth() <= 0) {
				monsters.remove(i);
			}
		}
		
		
		if(boss.getHealth() <= 0) {
			surface.switchScreen(surface.VICTORY_SCREEN);
		}
		
		if(ticks % 300 == 0) {
			boss.shootRangedWeapon((int)surface.getFrog().getX(), (int)surface.getFrog().getY(), this);
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
		surface.rect(250,  500,  (float)(boss.getHealth()/bossMaxHealth*300), 45);
		
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
			
				//Point p = surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY);
				//surface.getFrog().shootRangedWeapon(p.x,  p.y, surface);
			surface.getFrog().shootRangedWeapon(surface.mouseX, surface.mouseY, this);

		}
		
	}
}

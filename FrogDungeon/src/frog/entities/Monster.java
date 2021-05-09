package frog.entities;

import java.awt.Rectangle;
import java.util.ArrayList;

import frog.misc.*;
import frog.screen.FrogDungeon;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * A monster class where all monsters extend this class.
 * @author Jeremy Mills
 *
 */
public abstract class Monster extends Entity {

	//Fields
	protected double damage;
	protected Item dropItem;
	protected double range;
	protected double speed;
	
	//Constructors
	public Monster(double x, double y, double width, double height, double health, double damage, double range, double speed) {
		super(x, y, width, height, health);
		this.damage = damage;
		this.range = range;
		this.speed = speed;
		
		int i = (int)(Math.random()*10);
		System.out.println(i);
		if(i == 1) {
			dropItem = new HealthPotion(this.x, this.y, 50, 50);
		}
		else if(i == 2) {
			dropItem = new StrengthPotion(this.x, this.y, 50, 50);
		}
		else if(i == 3) {
			dropItem = new SpeedPotion(this.x, this.y, 50, 50);
		}
		else {
			dropItem = null;
		}
		
	}
		
	//Methods
	/**
	 * Attacks the Frog given using its damage field.
	 * @param player, the Frog that is going to take the damage.
	 */
	public void attackPlayer(Frog player) {
		
	}
	
	//Moves towards the player
	public void move(ArrayList<Wall> walls, FrogDungeon game) {
	   int targetX = (int)game.getFrog().getX();
       int targetY = (int)game.getFrog().getY();

        //calculating the angle
        double changeX = targetX - x;
        double changeY = y - targetY;

        double hyp = Math.sqrt(changeX * changeX + changeY * changeY);

        if(hyp != 0 && hyp < range) {
            double refAngle = Math.asin(changeY/hyp);
            double cosAngle = Math.acos(changeX/hyp);

            if(cosAngle > Math.PI/2) {
                refAngle = Math.PI - refAngle;
            }

            x = x + (1.5 * Math.cos(refAngle));
            y = y - (1.5 * Math.sin(refAngle));
            if(dropItem != null) {
            	dropItem.setX(dropItem.getX() + (1.5 * Math.cos(refAngle)));
            	dropItem.setY(dropItem.getY() - (1.5 * Math.sin(refAngle)));
            }
        }

        
        //COLLISIONS
        
	}
	
	public Item getItem() {
		return dropItem;
	}
	public double getDamage() {
		return damage;
	}
}

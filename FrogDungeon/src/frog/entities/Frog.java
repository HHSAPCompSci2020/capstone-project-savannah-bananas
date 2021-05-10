package frog.entities;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import frog.DrawingSurface;
import frog.misc.Wall;
import frog.weapons.*;
import processing.core.PApplet;

/**
 * Represents a frog that extends Entity. Contains one melee and one projectile weapon.
 * @author Jeremy Mills
 *
 */

public class Frog extends Entity{
	
	//Fields
	private MeleeWeapon melee;
	private ProjectileWeapon ranged;
	private int coins;
	
	//Constructors
	public Frog(double x, double y, double width, double height, double health) {
		super(x, y, width, height, health);
		speedMultiplyer = 1;
		strengthMultiplyer = 1;
		melee = new Knife();
	    ranged = new Bow();
	}

	//Methods
	/**
	 * Moves the Frog through the maze. Also handles user input.
	 * @param walls, the Walls that are in the maze.
	 * @param surface The DrawingSurface that the Frog is drawn in.
	 */
	public void move(ArrayList<Wall> walls, DrawingSurface surface) {
		
		double baseSpeed = 5.0;
		double maxSpeed = baseSpeed * getSpeed();
		
		/*if (surface.isPressed(KeyEvent.VK_W))
			vY = 0 - (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_A))
			vX = 0 - (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_S))
			vY = (baseSpeed * getSpeed());
		if (surface.isPressed(KeyEvent.VK_D))
			vX = (baseSpeed * getSpeed());

		if(!surface.isPressed(KeyEvent.VK_W) && !surface.isPressed(KeyEvent.VK_S))
			vY = 0;
		if(!surface.isPressed(KeyEvent.VK_A) && !surface.isPressed(KeyEvent.VK_D))
			vX = 0;*/
		
		if (surface.isPressed(KeyEvent.VK_W)) {
			if(vY > (0-maxSpeed/2))
				vY -= maxSpeed/6;
			else
				vY -= (maxSpeed + vY)/6;
		}
		if (surface.isPressed(KeyEvent.VK_A)) {
			if(vX > (0-maxSpeed/2))
				vX -= maxSpeed/6;
			else
				vX -= (maxSpeed + vX)/6;
		}
		if (surface.isPressed(KeyEvent.VK_S)) {
			if(vY < (maxSpeed/2))
				vY += maxSpeed/6;
			else
				vY += (maxSpeed - vY)/6;
		}
		if (surface.isPressed(KeyEvent.VK_D)) {
			if(vX < (maxSpeed/2))
				vX += maxSpeed/6;
			else
				vX += (maxSpeed - vX)/6;
		}
		

		double deceleration = 0.8;
		if(!surface.isPressed(KeyEvent.VK_W) && !surface.isPressed(KeyEvent.VK_S)) {
			if(vY > deceleration)
				vY -= deceleration;
			else if(vY < 0-deceleration)
				vY += deceleration;
			else if(vY < deceleration && vY > 0 || vY > 0-deceleration && vY < 0)
				vY = 0;
		}
		if(!surface.isPressed(KeyEvent.VK_A) && !surface.isPressed(KeyEvent.VK_D)) {
			if(vX > deceleration)
				vX -= deceleration;
			else if(vX < 0-deceleration)
				vX += deceleration;
			else if(vX < deceleration && vX > 0 || vX > 0-deceleration && vX < 0)
				vX = 0;
		}
		
		
		//makes a list of all rectangles that make up the walls
		ArrayList<Rectangle> wallRectangles = new ArrayList<Rectangle>();
		for(Wall wall : walls)
			wallRectangles.addAll(wall.getRectangles());
		
		//moves by the new vX and vY. This will be undone if a collision happens.
		super.move();
		
		//saves some values for later use
		double oldX = x;
		double oldY = y;
		double shiftX = Integer.MAX_VALUE;
		double shiftY = Integer.MAX_VALUE;
		
		for(Rectangle r : wallRectangles) {
			if(isTouching(r)) {
				double thisLeft = this.x;
				double thisRight = this.x + this.width;
				double rectLeft = r.x;
				double rectRight = r.x + r.width;
				
				if((rectLeft - thisRight > 0) != (rectRight - thisLeft > 0)) {
					if(Math.min(thisRight - rectLeft, rectRight - thisLeft) < shiftX && vX != 0)
						shiftX = Math.min(thisRight - rectLeft, rectRight - thisLeft);
				}
				
				double thisTop = this.y;
				double thisBottom = this.y + this.height;
				double rectTop = r.y;
				double rectBottom = r.y + r.height;
				
				if((rectTop - thisBottom > 0) != (rectBottom - thisTop > 0)) {
					if(Math.min(thisBottom - rectTop, rectBottom - thisTop) < shiftY && vY != 0)
						shiftY = Math.min(thisBottom - rectTop, rectBottom - thisTop);
				}
			}
		}
		
		if(shiftX != Integer.MAX_VALUE && shiftX < 1.1*(baseSpeed*this.getSpeed())) {
			shiftX++;
			if(vX < 0)
				shiftX = 0 - shiftX;
			super.moveBy(0 - shiftX, 0);
			vX = 0.0;
		}
		
		if(shiftY != Integer.MAX_VALUE && shiftY < 1.1*(baseSpeed*this.getSpeed())) {
			shiftY++;
			if(vY < 0)
				shiftY = 0 - shiftY;
			super.moveBy(0, 0 - shiftY);
			vY = 0.0;
		}
		
		/*if(shiftX != Integer.MAX_VALUE || shiftY != Integer.MAX_VALUE) {
			if(shiftX < shiftY) {
				shiftX++;
				if(vX < 0)
					shiftX = 0 - shiftX;
				super.moveBy(0 - shiftX, 0);
				vX = 0.0;
			} else {
				shiftY++;
				if(vY < 0)
					shiftY = 0 - shiftY;
				super.moveBy(0, 0 - shiftY);
				vY = 0.0;
			}
		}*/
		
	}
		
	//}
	
	/**
	 * Detects if this Frog is touching the given wall.
	 * @param wall, the Wall that is being tested.
	 * @return boolean, true if they are touching, false if they are not.
	 */
	public boolean isTouchingWall(Wall wall) {
		for(Rectangle r : wall.getRectangles())
			if(isTouching(r))
				return true;
		return false;
	}
	
	/**
	 * Shoots the ranged weapon that this frog has.
	 * @param x, the x coordinate of where the frog is shooting.
	 * @param y, the y coordinate of where the frog is shooting.
	 * @param surface, the DrawingSurface that the Projectile will exist inside of
	 */
	public void shootRangedWeapon(int x, int y, DrawingSurface surface) {
		int offsetX = (int) ((float) this.getX() + (float) this.getWidth()/2 - 400); //this is the X amount the screen is shifted
		int offsetY = (int) ((float) this.getY() + (float) this.getHeight()/2 - 300); //this is the Y amount the screen is shifted
		
		offsetY += 20; //idk why but mouseY includes the height of the window
		Point actualMousePoint = surface.assumedCoordinatesToActual(x, y);
		ranged.shoot((int)this.getX() + (int) (this.width/2), (int)this.getY() + (int) (this.height/2), actualMousePoint.x + offsetX, actualMousePoint.y + offsetY);
	}
	
	/**
	 * Attacks using the melee weapon that the frog has.
	 * @param monster, the Monster which is taking the damage
	 */
	public void meleeAttack(Monster monster) {
		monster.setHealth(monster.getHealth() - melee.getDamage());
	}
	
	public void draw(PApplet marker) {
		marker.pushStyle();
		marker.fill(0, 256, 0);
		marker.ellipse((float)(x+width/2), (float)(y+height/2), (float)width, (float)height);
		marker.fill(0);
		marker.textAlign(PApplet.CENTER);
		marker.text("Frog", (float)x+(float)width/2, (float)y+(float)height/2);
		
		marker.noFill();
		marker.stroke(255, 0, 0);
		marker.rect((float) this.x, (float) this.y, (float) this.width, (float) this.height);
		marker.popStyle();
	}

	public MeleeWeapon getMelee() {
		return melee;
	}
	
	public ProjectileWeapon getProjectile() {
		return ranged;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void incrementCoins(int amount) {
		coins += amount;
	}
	
}

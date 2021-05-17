package frog.entities;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import frog.DrawingSurface;
import frog.misc.Wall;
import frog.weapons.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a frog that extends Entity. Contains one melee and one projectile weapon.
 * @author Jeremy Mills, Justin Hwang
 *
 */

public class Frog extends Entity{
	
	//Fields
	private MeleeWeapon melee;
	private ProjectileWeapon ranged;
	private int coins;
	
	private ArrayList<PImage> idleLeftImages, idleRightImages, runningRightImages, runningLeftImages, damageImages;
	/**
	 * This variable will either point to runningRightImages or runningLeftImages, depending on which way he should be facing.
	 */
	private ArrayList<PImage> runningImages, idleImages;
	private int state;
	private int timeInState;
	private static final int IDLE = 0;
	private static final int RUNNING = 1;
	private static final int DAMAGE = 2;
	
	//Constructors
	public Frog(double x, double y, double width, double height, double health, PApplet marker) {
		super(x, y, width, height, health);
		speedMultiplyer = 1;
		strengthMultiplyer = 1;
		melee = new Knife(marker);
	    ranged = new Bow(marker);
	    coins = 999;
	    
	    runningRightImages = new ArrayList<PImage>();
	    runningLeftImages = new ArrayList<PImage>();
	    idleRightImages = new ArrayList<PImage>();
	    idleLeftImages = new ArrayList<PImage>();
	    damageImages = new ArrayList<PImage>();
	    runningImages = runningRightImages;
	    idleImages = idleRightImages;
	    timeInState = 0;
	    state = IDLE;
	}
	
	public Frog(Map<String, Object> map, PApplet marker) {
		super(map);
		Map<String, Object> mMap = (Map<String, Object>) map.get("melee");
		String mType = (String) mMap.get("type");
		if(mType.equals("Sword"))
			melee = new Sword(marker);
		else if(mType.equals("Knife"))
			melee = new Knife(marker);
		else if(mType.equals("Hammer"))
			melee = new Hammer(marker);

		Map<String, Object> rMap = (Map<String, Object>) map.get("ranged");
		String rType = (String) rMap.get("type");
		if(rType.equals("Rifle"))
			ranged = new Rifle(marker);
		else if(rType.equals("Pistol"))
			ranged = new Pistol(marker);
		else if(rType.equals("Bow"))
			ranged = new Bow(marker);
		
	    coins = (int) map.get("coins");
	    
	    runningRightImages = new ArrayList<PImage>();
	    runningLeftImages = new ArrayList<PImage>();
	    idleRightImages = new ArrayList<PImage>();
	    idleLeftImages = new ArrayList<PImage>();
	    damageImages = new ArrayList<PImage>();
	    runningImages = runningRightImages;
	    idleImages = idleRightImages;
	    timeInState = (int) map.get("timeInState");
	    state = (int) map.get("state");
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
				vY -= maxSpeed/24;
			else
				vY -= (maxSpeed + vY)/24;
		}
		if (surface.isPressed(KeyEvent.VK_A)) {
			if(vX > (0-maxSpeed/2))
				vX -= maxSpeed/24;
			else
				vX -= (maxSpeed + vX)/24;
		}
		if (surface.isPressed(KeyEvent.VK_S)) {
			if(vY < (maxSpeed/2))
				vY += maxSpeed/24;
			else
				vY += (maxSpeed - vY)/24;
		}
		if (surface.isPressed(KeyEvent.VK_D)) {
			if(vX < (maxSpeed/2))
				vX += maxSpeed/24;
			else
				vX += (maxSpeed - vX)/24;
		}
		
		//System.out.println(vX + " " + vY);
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
		if(walls != null) {
			
			for(Wall wall : walls)
				wallRectangles.addAll(wall.getRectangles());
		}
			//moves by the new vX and vY. This will be undone if a collision happens.
			super.move();
		if(walls!=null) {
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
		if(vX > 0) {
			runningImages = runningRightImages;
			idleImages = idleRightImages;
		} else if(vX < 0) {
			runningImages = runningLeftImages;
			idleImages = idleLeftImages;
		}
		
		if(vX != 0 || vY != 0) {
			if(state != RUNNING) {
				state = RUNNING;
				timeInState = 0;
			}
		} else {
			if(state != IDLE) {
				state = IDLE;
				timeInState = 0;
			}
		}
		
		
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
		/*marker.fill(0, 256, 0);
		marker.ellipse((float)(x+width/2), (float)(y+height/2), (float)width, (float)height);
		marker.fill(0);
		marker.textAlign(PApplet.CENTER);
		marker.text("Frog", (float)x+(float)width/2, (float)y+(float)height/2);
		
		marker.noFill();
		marker.stroke(255, 0, 0);
		marker.rect((float) this.x, (float) this.y, (float) this.width, (float) this.height);*/
		
		PImage image = idleImages.get(0);
		int frame = this.timeInState / 2;
		if(state == RUNNING)
			image = runningImages.get(frame % 12);
		else if(state == DAMAGE)
			image = damageImages.get(frame % 7);
		else
			image = idleImages.get(frame % 10);
		timeInState++;
		
		marker.pushMatrix();
		marker.translate((float) (x) - (float)(width/6), (float) (y - width/6 - 8));
		marker.scale((float) ((width*4)/(3*image.width)), (float) ((height*4)/(3*image.height)));
		marker.image(image, 0, 0);
		marker.popMatrix();
		
		marker.popStyle();
	}

	public MeleeWeapon getMelee() {
		return melee;
	}
	
	public ProjectileWeapon getProjectile() {
		return ranged;
	}
	
	public void setMelee(MeleeWeapon melee) {
		this.melee = melee;
	}
	
	public void setProjectile(ProjectileWeapon ranged) {
		this.ranged = ranged;
	}
	
	public void loadImages(DrawingSurface surface) {
		for(int i = 0; i < 10; i++)
	    	idleRightImages.add(surface.loadImage("resources/player/idle/right/" + i + ".png"));
		for(int i = 0; i < 10; i++)
	    	idleLeftImages.add(surface.loadImage("resources/player/idle/left/" + i + ".png"));
		for(int i = 0; i < 12; i++)
	    	runningRightImages.add(surface.loadImage("resources/player/run/right/" + i + ".png"));
		for(int i = 0; i < 12; i++)
			runningLeftImages.add(surface.loadImage("resources/player/run/left/" + i + ".png"));
		for(int i = 0; i < 7; i++)
	    	damageImages.add(surface.loadImage("resources/player/hit/" + i + ".png"));
	}

	public int getCoins() {
		return coins;
	}
	
	public void incrementCoins(int amount) {
		coins += amount;
	}
	
	public Map<String, Object> asMap() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("melee", melee.asMap());
		data.put("ranged", ranged.asMap());
		data.put("coins", coins);
		data.put("state", state);
		data.put("timeInState", timeInState);
		data.putAll(super.asMap());
		return data;
	}
	
}

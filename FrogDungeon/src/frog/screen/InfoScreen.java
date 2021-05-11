package frog.screen;

import frog.util.Button;
import processing.core.PImage;
import frog.DrawingSurface;

/**
 * Represents the "How to Play" screen that can be accessed from the MenuScreen. Displays the controls.
 * @author Mikaela Kwan
 *
 */
public class InfoScreen extends Screen {
	//Fields
	private Button returnButton;
	private PImage gorf;
	private PImage potion1;
	private PImage potion2;
	private PImage potion3;
	
	//Constructors
	/**
	 * Constructs a new InfoScreen
	 * @param surface The DrawingSurface that this InfoScreen exists inside of
	 */
	public InfoScreen(DrawingSurface surface) {
		super(surface);
		
		gorf = new PImage();
		potion1 = new PImage();
		potion2 = new PImage();
		potion3 = new PImage();
		
		returnButton = new Button(20, 20, 150, 100);
		returnButton.setText("Return to Main Menu");
		returnButton.setButtonListener(this);
		buttons.add(returnButton);
		
	}
	
	//Methods
	public void draw() {
		gorf = surface.loadImage("resources/gorf1.png");
		potion1 = surface.loadImage("resources/healthpotion.png");
		potion2 = surface.loadImage("resources/speedpotion.png");
		potion3 = surface.loadImage("resources/strengthpotion.png");
		
		surface.background(0);
		surface.pushStyle();
		//surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.textSize(15);
		surface.text("HOW TO PLAY", 345, 50);
		surface.text("WASD to move", 345, 250);
		surface.text("Left Click to Melee Attack", 305, 275);
		surface.text("Right Click to Projectile Attack", 290, 300);
		surface.text("Press E to Get Items as you Defeat Monsters", 240, 325);
		surface.text("Use Coins to Buy New Weapons", 290, 415);
		surface.text("Once you are ready, take on the final boss!", 250, 450);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.image(gorf, 335, 85);
		surface.image(potion1, 280, 340, 50, 50);
		surface.image(potion2, 370, 340, 50, 50);
		surface.image(potion3, 460, 340, 50, 50);
		
		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(returnButton)) {
			surface.switchScreen(surface.MENU_SCREEN);
		}
	}
}

package frog.screen;

import frog.util.Button;
import processing.core.PImage;
import frog.DrawingSurface;

public class InfoScreen extends Screen {
	//Fields
	private Button returnButton;
	private PImage gorf;
	
	//Constructors
	/**
	 * Constructs a new InfoScreen
	 * @param surface The DrawingSurface that this InfoScreen exists inside of
	 */
	public InfoScreen(DrawingSurface surface) {
		super(surface);
		
		gorf = new PImage();
		
		returnButton = new Button(20, 20, 150, 100);
		returnButton.setText("Return to Main Menu");
		returnButton.setButtonListener(this);
		buttons.add(returnButton);
		
	}
	
	//Methods
	public void draw() {
		gorf = surface.loadImage("resources/gorf1.png");
		
		surface.background(0);
		surface.pushStyle();
		//surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("HOW TO PLAY", 355, 50);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.image(gorf, 335, 85);
		
		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(returnButton)) {
			surface.switchScreen(surface.MENU_SCREEN);
		}
	}
}

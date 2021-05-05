package frog.screen;

import frog.util.Button;
import processing.core.PImage;
import frog.DrawingSurface;

public class MenuScreen extends Screen {
	//Fields
	private Button startButton;
	private Button infoButton;
	private PImage gorf;
	
	//Constructors
	/**
	 * Constructs a new MenuScreen
	 * @param surface The DrawingSurface that this MenuScreen exists inside of
	 */
	public MenuScreen(DrawingSurface surface) {
		super(surface);
		
		gorf = new PImage();
		
		startButton = new Button(300, 250, 200, 150);
		startButton.setText("Start");
		startButton.setButtonListener(this);
		buttons.add(startButton);
		
		infoButton = new Button(300, 400, 200, 150);
		infoButton.setText("How To Play");
		infoButton.setButtonListener(this);
		buttons.add(infoButton);

	}
	
	public void draw() {
		gorf = surface.loadImage("gorf1.png");


		surface.background(0);
		surface.pushStyle();
		//surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);

		surface.text("FROG DUNGEON", 350, 50);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.image(gorf, 335, 85);

		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(startButton)) {
			surface.switchScreen(surface.GAME_SCREEN);
		}
		else if(button.equals(infoButton)) {
			surface.switchScreen(surface.INFO_SCREEN);
		}
	}
}

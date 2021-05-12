package frog.screen;

import frog.util.Button;
import processing.core.PImage;
import frog.DrawingSurface;

/**
 * Default screen that appears when the program is run. Displays a start button and a how to play button.
 * @author Justin Hwang
 *
 */
public class MenuScreen extends Screen {
	//Fields
	private Button startButton;
	private Button infoButton;
	private PImage title;
	
	//Constructors
	/**
	 * Constructs a new MenuScreen
	 * @param surface The DrawingSurface that this MenuScreen exists inside of
	 */
	public MenuScreen(DrawingSurface surface) {
		super(surface);
		
		//frog = new PImage();
		
		startButton = new Button(300, 375, 200, 50);
		startButton.setText("Start");
		startButton.setButtonListener(this);
		buttons.add(startButton);
		
		infoButton = new Button(300, 450, 200, 50);
		infoButton.setText("How To Play");
		infoButton.setButtonListener(this);
		buttons.add(infoButton);

	}
	
	public void draw() {
		if(title == null)
			title = surface.loadImage("resources/title.png");

		surface.background(0);
		surface.pushStyle();
		//surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);

		//surface.text("FROG DUNGEON", 350, 50);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.image(title, 100, 10);

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

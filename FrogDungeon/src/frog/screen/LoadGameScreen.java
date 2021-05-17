package frog.screen;

import frog.util.Button;
import processing.core.PImage;

import java.awt.Color;
import java.io.File;

import frog.DrawingSurface;

/**
 * Default screen that appears when the program is run. Displays a start button and a how to play button.
 * @author Justin Hwang
 *
 */
public class LoadGameScreen extends Screen {
	//Fields
	
	//Constructors
	/**
	 * Constructs a new MenuScreen
	 * @param surface The DrawingSurface that this MenuScreen exists inside of
	 */
	public LoadGameScreen(DrawingSurface surface) {
		super(surface);
		
		File saveDirectory = new File("saves");
		File[] contents = saveDirectory.listFiles();
		for(int i = 0; i < contents.length; i++) {
			Button button = new Button(100, 150 + 50 * i, 600, 45);
			String fileName = contents[i].getName();
			button.setText(fileName.substring(0, fileName.length() - 4));
			button.setButtonListener(this);
			//button.setTextSize(25);
			buttons.add(button);
		}

	}
	
	public void draw() {
		surface.background(28, 29, 30);
		surface.pushStyle();
		surface.textAlign(DrawingSurface.CENTER);
		surface.textSize(50);
		surface.fill(255);
		surface.text("Select Save File...", 400, 100);
		surface.textSize(25);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);

		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {

		surface.loadGameFromFile("saves/" + button.getText() + ".yml");
		surface.switchScreen(surface.GAME_SCREEN);
	}
}

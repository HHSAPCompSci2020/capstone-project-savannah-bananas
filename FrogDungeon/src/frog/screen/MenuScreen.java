package frog.screen;

import frog.util.Button;

import frog.DrawingSurface;

public class MenuScreen extends Screen {
	//Fields
	private Button startButton;
	private Button infoButton;
	
	//Constructors
	/**
	 * Constructs a new MenuScreen
	 * @param surface The DrawingSurface that this MenuScreen exists inside of
	 */
	public MenuScreen(DrawingSurface surface) {
		super(surface);
		
		startButton = new Button(300, 150, 200, 150);
		startButton.setText("Start");
		startButton.setButtonListener(this);
		buttons.add(startButton);
		
		infoButton = new Button(300, 300, 200, 150);
		infoButton.setText("How To Play");
		infoButton.setButtonListener(this);
		buttons.add(infoButton);

	}
	
	//Methods
	public void draw() {
		surface.background(0);
		surface.pushStyle();
		//surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("FROG DUNGEON", 350, 100);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
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

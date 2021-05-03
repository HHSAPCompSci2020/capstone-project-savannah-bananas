package frog.screen;

import frog.util.Button;

import frog.DrawingSurface;

public class MenuScreen extends Screen {
	//Fields
	private Button startButton;
	
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
	}
	
	//Methods
	public void draw() {
		surface.background(0);
		surface.pushStyle();
		surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		//surface.text("FROG DUNGEON", 400, 300);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(startButton)) {
			surface.switchScreen(surface.GAME_SCREEN);
		}
	}
}

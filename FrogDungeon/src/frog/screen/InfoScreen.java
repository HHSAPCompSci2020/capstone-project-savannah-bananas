package frog.screen;

import frog.util.Button;

import frog.DrawingSurface;

public class InfoScreen extends Screen {
	//Fields
	private Button returnButton;
	
	//Constructors
	/**
	 * Constructs a new InfoScreen
	 * @param surface The DrawingSurface that this InfoScreen exists inside of
	 */
	public InfoScreen(DrawingSurface surface) {
		super(surface);
		
		returnButton = new Button(20, 20, 150, 100);
		returnButton.setText("Return to Main Menu");
		returnButton.setButtonListener(this);
		buttons.add(returnButton);
		
	}
	
	//Methods
	public void draw() {
		surface.background(0);
		surface.pushStyle();
		surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("GAME CONTROLS, BACKGROUND INFO, ETC", 400, 300);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.popStyle();
	}

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(returnButton)) {
			surface.switchScreen(surface.MENU_SCREEN);
		}
	}
}

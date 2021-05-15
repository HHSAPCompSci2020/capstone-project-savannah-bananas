package frog.screen;

import frog.util.Button;
import frog.DrawingSurface;

/**
 * Represents the Screen that appears while the game is Paused.
 * @author Mikaela Kwan
 *
 */
public class PauseScreen extends Screen {
	
	//Fields
	private Button resumeButton;
	private Button saveButton;
	private Button exitButton;
	
	// Constructors
	/**
	 * Constructs a new PauseScreen
	 * @param surface The DrawingSurface that this PauseScreen exists inside of
	 */
	public PauseScreen(DrawingSurface surface) {
		super(surface);
		
		resumeButton = new Button(300, 100, 200, 150);
		resumeButton.setText("Resume");
		resumeButton.setButtonListener(this);
		buttons.add(resumeButton);
		
		saveButton = new Button(300, 250, 200, 150);
		saveButton.setText("Save Game");
		saveButton.setButtonListener(this);
		buttons.add(saveButton);
		
		exitButton = new Button(300, 400, 200, 150);
		exitButton.setText("Exit");
		exitButton.setButtonListener(this);
		buttons.add(exitButton);

		
		//TODO: Create resume, save and exit buttons, and add them to "buttons" arraylist inherited from Screen superclass
	}
	
	public void draw() {
		surface.background(28, 29, 30);
		surface.pushStyle();
	//	surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("GAME PAUSED", 355, 50);
		
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.popStyle();
	}
	
	//Methods

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(resumeButton)) {
			surface.switchScreen(surface.GAME_SCREEN);
		} else if(button.equals(exitButton)) {
			surface.switchScreen(surface.MENU_SCREEN);
		}
	}
}

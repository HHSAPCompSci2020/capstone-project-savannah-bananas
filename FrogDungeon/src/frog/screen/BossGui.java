package frog.screen;

import frog.util.Button;
import frog.DrawingSurface;

/**
 * Represents the Screen that appears while the game is Paused.
 * @author Mikaela Kwan
 *
 */
public class BossGui extends Screen {
	
	//Fields
	private Button yesButton;
	private Button noButton;
	
	// Constructors
	/**
	 * Constructs a new PauseScreen
	 * @param surface The DrawingSurface that this PauseScreen exists inside of
	 */
	public BossGui(DrawingSurface surface) {
		super(surface);
		
		yesButton = new Button(300, 250, 200, 150);
		yesButton.setText("Yes");
		yesButton.setButtonListener(this);
		buttons.add(yesButton);
		
		noButton = new Button(300, 400, 200, 150);
		noButton.setText("No");
		noButton.setButtonListener(this);
		buttons.add(noButton);

		
		//TODO: Create resume, save and exit buttons, and add them to "buttons" arraylist inherited from Screen superclass
	}
	
	public void draw() {
		surface.background(28, 29, 30);
		surface.pushStyle();
	//	surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("YOU HAVE FOUND THE SORCERER'S CHAMBER", 265, 150);
		surface.text("DO YOU WISH TO CONTINUE?", 315, 170);

		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		
		surface.popStyle();
	}
	
	//Methods

	@Override
	public void buttonPressed(Button button) {
		if(button.equals(yesButton)) {
			surface.switchScreen(surface.BOSS_SCREEN);
		} else if(button.equals(noButton)) {
			surface.switchScreen(surface.GAME_SCREEN);
		}
	}
}

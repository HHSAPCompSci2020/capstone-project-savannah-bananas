package frog.screen;

import frog.util.Button;
import frog.DrawingSurface;

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
		
		//TODO: Create resume, save and exit buttons, and add them to "buttons" arraylist inherited from Screen superclass
	}
	
	//Methods

	@Override
	public void buttonPressed(Button button) {
		//if(button.equals(resumeButton) {// do stuff}
	}
}

package frog.screen;

import java.awt.Button;

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
	}
	
	//Methods
	public void draw() {
		surface.background(0);
		surface.pushStyle();
		surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.text("FROG DUNGEON", 400, 300);
		surface.popStyle();
	}
}

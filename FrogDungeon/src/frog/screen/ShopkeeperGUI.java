package frog.screen;

import frog.DrawingSurface;
import frog.misc.SpeedPotion;
import frog.util.Button;

public class ShopkeeperGUI extends Screen {
	
	private Button swordbutton;
	private Button hammerbutton;
	private Button pistolbutton;
	private Button riflebutton;
	private Button exit;
	private Button healthbutton;
	private Button speedbutton;
	private Button strengthbutton;

	public ShopkeeperGUI(DrawingSurface surface) {
		super(surface);
		
		//SWORD BUTTON
		swordbutton = new Button(25, 150, 150, 100);
		swordbutton.setText("Sword: $50");
		swordbutton.setButtonListener(this);
		buttons.add(swordbutton);
		
		hammerbutton = new Button(225, 150, 150, 100);
		hammerbutton.setText("Hammer: $75");
		hammerbutton.setButtonListener(this);
		buttons.add(hammerbutton);
		
		pistolbutton = new Button(425, 150, 150, 100);
		pistolbutton.setText("Pistol: $75");
		pistolbutton.setButtonListener(this);
		buttons.add(pistolbutton);
		
		riflebutton = new Button(625, 150, 150, 100);
		riflebutton.setText("Rifle: $100");
		riflebutton.setButtonListener(this);
		buttons.add(riflebutton);
		
		healthbutton = new Button(25, 300, 150, 100);
		healthbutton.setText("Health: $25");
		healthbutton.setButtonListener(this);
		buttons.add(healthbutton);
		
		speedbutton = new Button(225, 300, 150, 100);
		speedbutton.setText("Speed: $25");
		speedbutton.setButtonListener(this);
		buttons.add(speedbutton);
		
		strengthbutton = new Button(425, 300, 150, 100);
		strengthbutton.setText("Strength: $50");
		strengthbutton.setButtonListener(this);
		buttons.add(strengthbutton);
		
		exit = new Button(625, 300, 150, 100);
		exit.setText("Exit");
		exit.setButtonListener(this);
		buttons.add(exit);
	}

	public void buttonPressed(Button button) {
		if(button.equals(exit)) {
			surface.switchScreen(surface.GAME_SCREEN);
		} else if(button.equals(swordbutton)) {
			//PURCHASE SWORD
		} else if(button.equals(hammerbutton)) {
			//PURCHASE HAMMER
		} else if(button.equals(pistolbutton)) {
			//PURCHASE PISTOL
		} else if(button.equals(riflebutton)) {
			//PURCHASE RIFLE
		} else if(button.equals(healthbutton)) {
			//PURCHASE HEALTHPOTION
		} else if(button.equals(speedbutton)) {
			//PURCHASE SPEEDPOTION
		} else if(button.equals(strengthbutton)) {
			//PURCHASE STRENGTHPOTION
		}
		
	}

	public void draw() {
		surface.background(0);
		surface.pushStyle();
		surface.textAlign(DrawingSurface.CENTER, DrawingSurface.CENTER);
		surface.textSize(15);
		surface.text("Welcome to the Shop!", 400, 40);
		surface.text("You can buy weapons here.", 400, 60);

			
		updateButtons(surface.assumedCoordinatesToActual(surface.mouseX, surface.mouseY), surface.mousePressed);
		drawButtons(surface);
		surface.popStyle();
	}
}

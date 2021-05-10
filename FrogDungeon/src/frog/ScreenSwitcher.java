package frog;

/**
 * Simple interface used by DrawingSurface to switch between screens.
 * Mostly copied from Mr. Shelby's "ProcessingScreenSwitching" demo.
 * @author Justin Hwang
 *
 */
public interface ScreenSwitcher {

	//Fields
	public final int MENU_SCREEN = 0;
	public final int GAME_SCREEN = 1;
	public final int PAUSE_SCREEN = 2;
	public final int INFO_SCREEN = 3;
	public final int BOSS_GUI = 4;
	
	//Methods
	/**
	 * Switches the current active Screen to the new index
	 * @param i
	 */
	public void switchScreen(int i);
}

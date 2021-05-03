package temporary;

public interface ScreenSwitcher {

	//Fields
	public final int MENU_SCREEN = 0;
	public final int GAME_SCREEN = 1;
	public final int PAUSE_SCREEN = 2;
	
	//Methods
	/**
	 * 
	 * @param i
	 */
	public void switchScreen(int i);
}

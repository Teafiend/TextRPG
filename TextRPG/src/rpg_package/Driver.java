package rpg_package;

/**
 * Starts up the program by creating a Game object and calling its execute
 * method.
 * 
 * @author Trevor Nelson
 */
public class Driver {
	/**
	 * instantiates a Game object and calls its execute method.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.execute();
	} // end main method
} // end class Driver
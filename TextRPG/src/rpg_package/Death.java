package rpg_package;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Contains all behaviors associated with player character death.
 * 
 * @author Trevor Nelson
 */
public class Death {
	private Player player;
	private Dungeon dungeon;

	/**
	 * Constructs an object of Death using a given player and dungeon.
	 * 
	 * @param player
	 *            The player that has just died.
	 * @param dungeon
	 *            The dungeon associated with the deceased player.
	 */
	public Death(Player player, Dungeon dungeon) {
		this.player = player;
		this.dungeon = dungeon;
	} // end constructor

	/**
	 * Initiates the sequence that occurs when the player character dies.
	 */
	public void playerDeath() {
		System.out.println(player.getName() + " has died!");
		recordDeath();
		System.out.println(player.getName() + "'s fate has been recorded in the Death Log.");
		System.out.println("Better luck next time!");
	} // end method playerDeath

	/**
	 * Records the deceased player's info in the Death Log text file.
	 */
	public void recordDeath() {
		try {
			File txtFile = new File("DeathLog.txt");
			FileWriter txtWriter = new FileWriter(txtFile, true);
			BufferedWriter bufferedTxtWriter = new BufferedWriter(txtWriter);

			// write epitaph-esque bit of text to text file
			bufferedTxtWriter.write("R.I.P. " + player.getName());
			bufferedTxtWriter.newLine();
			bufferedTxtWriter.write("Highest level achieved: " + player.getLevel());
			bufferedTxtWriter.newLine();
			bufferedTxtWriter.write("Deepest floor reached: " + dungeon.getCurrentFloor());
			bufferedTxtWriter.newLine();
			bufferedTxtWriter.write("Gold amassed: " + player.getGold());
			bufferedTxtWriter.newLine();
			bufferedTxtWriter.write("Monsters slain: " + player.getKillCount());
			bufferedTxtWriter.newLine();
			bufferedTxtWriter.newLine();

			bufferedTxtWriter.close();
		} // end try: tries code and handles exception if one is thrown
		catch (Exception e) {
			System.err.println(e);
		} // end catch: catches exception and prints it
	} // end method recordDeath
} // end class Death
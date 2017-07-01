package rpg_package;

/**
 * Allows for a player to sleep at the tavern to fully recover their health and
 * mana at a small cost of gold.
 * 
 * @author Trevor Nelson
 */
public class Tavern {

	/**
	 * Fully recovers the given character's health and mana, at the cost of 10
	 * gold.
	 * 
	 * @param c
	 *            The character who is sleeping at the tavern.
	 */
	public static void sleep(Character c) {
		c.setHealth(c.getMaxHealth());
		c.setMana(c.getMaxMana());
		c.setGold(c.getGold() - 10);
		View.sleepText(c.getName(), c.getMaxHealth());
	} // end method sleep
} // end class Tavern
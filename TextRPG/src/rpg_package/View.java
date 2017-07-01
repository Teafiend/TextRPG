package rpg_package;

/**
 * Contains a series of static methods that can be used to print out text
 * efficiently.
 * 
 * @author Trevor Nelson
 */
public class View {
	/**
	 * Outputs text when an attack spell is cast.
	 * 
	 * @param casterName
	 *            Name of the spell's caster.
	 * @param recieverName
	 *            Name of the spell's reciever.
	 * @param spellName
	 *            Name of the spell.
	 * @param damage
	 *            Damage that the spell dealt.
	 */
	public static void attackSpellText(String casterName, String recieverName, String spellName, int damage) {
		System.out.println(casterName + " cast " + spellName + " at " + recieverName + "!");
		System.out.println(recieverName + " recieved " + damage + " points of damage!");
	} // end method attackSpellText

	/**
	 * Outputs text when a heal spell is cast.
	 * 
	 * @param casterName
	 *            Name of the spell's caster.
	 * @param recieverName
	 *            Name of the spell's reciever
	 * @param spellName
	 *            Name of the spell.
	 * @param amountHealed
	 *            Amount of health recovered.
	 */
	public static void healSpellText(String casterName, String recieverName, String spellName, int amountHealed) {
		System.out.println(casterName + " cast " + spellName + "!");
		System.out.println(recieverName + " recovered " + amountHealed + " points of health!");
	} // end method healSpellText

	/**
	 * Outputs text when a potion is consumed.
	 * 
	 * @param drinkerName
	 *            Name of potion's drinker.
	 * @param potionName
	 *            Name of potion.
	 * @param type
	 *            Type of potion (Health or Mana).
	 * @param power
	 *            Amount of (type) restored.
	 */
	public static void potionText(String drinkerName, String potionName, String type, int power) {
		System.out.println(drinkerName + " drank the " + potionName + ".");
		System.out.println(drinkerName + " recovered " + power + " " + type + " points!");
	} // end method potionText

	/**
	 * Outputs text when player buys an item.
	 * 
	 * @param buyerName
	 *            Name of player buying item.
	 * @param gold
	 *            Amount of gold spent.
	 */
	public static void spendGoldText(String buyerName, int gold) {
		System.out.println(buyerName + " spent " + gold + " gold coins.");
	} // end method spendGoldText

	/**
	 * Outputs text when an item is received.
	 * 
	 * @param charName
	 *            Name of character receiving item.
	 * @param itemName
	 *            Name of item.
	 */
	public static void recieveItemText(String charName, String itemName) {
		System.out.println(charName + " recieved a " + itemName);
	} // end method recieveItemText

	/**
	 * Outputs text when player levels up.
	 * 
	 * @param playerName
	 *            Name of player levelling up.
	 * @param level
	 *            Player's new level.
	 * @param expNeeded
	 *            Experience points needed for next level.
	 */
	public static void levelUpText(String playerName, int level, int expNeeded) {
		System.out.println(playerName + " leveled up!");
		System.out.println(playerName + " is now level " + level + "!");
		System.out.println(
				playerName + " requires " + expNeeded + " experience points to reach level " + (level + 1) + ".");
	} // end method levelUpText

	/**
	 * Outputs text when player sells an item.
	 * 
	 * @param playerName
	 *            Name of player selling item.
	 * @param itemName
	 *            Name of item.
	 * @param price
	 *            Amount of gold item sold for.
	 */
	public static void sellText(String playerName, String itemName, int price) {
		System.out.println(playerName + " sold a " + itemName + " for " + price + " gold coins.");
	} // end method sellText

	/**
	 * Outputs text when player sleeps at tavern.
	 * 
	 * @param playerName
	 *            Name of player sleeping at tavern.
	 * @param maxHealth
	 *            Player's max health.
	 */
	public static void sleepText(String playerName, int maxHealth) {
		System.out.println("\n" + playerName + " slept and restored back to " + maxHealth + " health points.");
	} // end method sleepText

	/**
	 * Outputs text when game begins.
	 */
	public static void introText() {
		System.out.println("You are an intrepid adventurer, driven by wanderlust to this quiant village.");
		System.out.println("You have recieved word of regular attacks upon this town by monsters, "
				+ "which have been seen spewing forth from a nearby cave.");
		System.out.println(
				"You must descend into this desolate labyrinth, find the source of these attacks, and end it, once and for all!");
		System.out.println("Good luck!");
	} // end method introText

	/**
	 * Outputs text when player is in village center.
	 */
	public static void villageCenterText() {
		System.out.println("\nYou stand in the center of the village.");
		System.out.println("Your options are:");
		System.out.println("1) Visit the Shop");
		System.out.println("2) Visit the Tavern");
		System.out.println("3) Enter the Dungeon");
		System.out.println("4) Equip Gear");
		System.out.println("5) Exit Game");
	} // end method villageCenterText

	/**
	 * Outputs text when player is in shop.
	 */
	public static void shopMenuText() {
		System.out.println("Your options are:");
		System.out.println("1) Buy");
		System.out.println("2) Sell");
		System.out.println("3) Exit Shop");
	} // end method shopMenuText

	/**
	 * Outputs text when player is in tavern.
	 */
	public static void tavernMenu() {
		System.out.println("Your options are: ");
		System.out.println("1) Sleep (10g)");
		System.out.println("2) Exit tavern");
	} // end method tavernMenu

	/**
	 * Outputs text when player chooses to quit game.
	 */
	public static void quitMenu() {
		System.out.println("\nAre you sure you want to quit?");
		System.out.println("1) Yes");
		System.out.println("2) No");
	} // end method quitMenu

	/**
	 * Outputs text when player is about to enter the dungeon.
	 */
	public static void dungeonIntroMenu() {
		System.out.println("\nAre you sure you want to enter the dungeon?");
		System.out.println("Once you enter, you may not exit until you clear the current floor.");
		System.out.println("Enter the dungeon?");
		System.out.println("1) Yes");
		System.out.println("2) No");
	} // end method dungeonIntroMenu

	/**
	 * Outputs text when player is in combat.
	 */
	public static void combatMenu() {
		System.out.println("\nChoose an option:");
		System.out.println("1) Physical Attack");
		System.out.println("2) Cast Spell");
		System.out.println("3) Use Item");
	} // end method combatMenu

	/**
	 * Outputs text when player is about to enter boss chamber.
	 */
	public static void bossText() {
		System.out.println("\nYou have cleared all floors of the dungeon.");
		System.out.println("All that remains now is to defeat the boss of the dungeon.");
		System.out.println("Are you prepared to fight the boss?");
		System.out.println("1) Yes");
		System.out.println("2) No");
	} // end method bossText

	/**
	 * Outputs text when player is about to fight the boss.
	 * 
	 * @param weaponName
	 *            Name of boss's weapon.
	 * @param armorName
	 *            Name of boss's armor.
	 */
	public static void bossEncounterText(String weaponName, String armorName) {
		System.out.println(
				"\nYou descend into the deepest area of the dungeon, notice the air getting colder as you near the bottom.");
		System.out.println(
				"You emerge into a great antechamber; the walls lined with bookcases stacked as high as you can see.");
		System.out.println(
				"In the center of the chamber, you notice an unnaturally tall humanoid figure, cloaked in a pitch black robe;");
		System.out.println("He slowly turns around, and throws off his robe to reveal the visage of a skeleton!");
		System.out.println(
				"You also notice the fiend is wearing a " + armorName + ", and is wielding a " + weaponName + ".");
		System.out.println("The Skeletal Warlock attacks you!");
	} // end method bossEncounterText

	/**
	 * Outputs text when player clears the game.
	 * 
	 * @param bossName
	 *            Name of the final boss.
	 * @param playerName
	 *            Name of the player.
	 */
	public static void gameClear(String bossName, String playerName) {
		System.out.println("Congratulation! You have slain the boss!");
		System.out.println(
				"You have saved the land from the evil power of the " + bossName + " and his army of monsters!");
		System.out.println("The name \"" + playerName + "\" will go down in history as one of virtue and courage.");
		System.out.println("Thank you for playing!");
	} // end method bossClear
} // end class View
package rpg_package;

import java.util.Scanner;

// TODO: Add error checking for ALL user input sequences

/**
 * Contains the main logic of the game, and holds objects of the player,
 * dungeon, shop, and scanner.
 * 
 * @author Trevor Nelson
 */
public class Game {
	private Player player;
	private Dungeon dungeon;
	private Shop shop;
	private Scanner reader;

	/**
	 * Initiates game by prompting for player's name and size of dungeon, and
	 * instantiates instance variables.
	 */
	public void execute() {
		reader = new Scanner(System.in);

		System.out.print("Enter your name: ");
		player = new Player(reader.nextLine());

		System.out.print("Enter size of dungeon: ");
		dungeon = new Dungeon(reader.nextInt());

		System.out.println();

		shop = new Shop();

		View.introText();
		inVillage();
	} // end method execute

	/**
	 * Outputs text for village center and converts input into an action.
	 */
	private void inVillage() {
		View.villageCenterText();
		switch (reader.nextInt()) {
		// Shop
		case 1:
			enterShop();
			// Tavern
		case 2:
			enterTavern();
			// Dungeon
		case 3:
			enterDungeon();
			// Equip Gear
		case 4:
			equipGear();
			// Exit
		case 5:
			exitGame();
		default:
			System.out.println("Invalid selection");
			inVillage();
		} // end switch: applies action based on user's choice
	} // end method inVillage

	/**
	 * Displays text for when player enters shop, and interpret's player's
	 * choice at the menu.
	 */
	private void enterShop() {
		System.out.println("\nYou enter the shop.");
		View.shopMenuText();
		switch (reader.nextInt()) {
		// Buy
		case 1:
			buyItem();
			// Sell
		case 2:
			sellItem();
			// Exit Shop
		case 3:
			inVillage();
		default:
			System.out.println("Invalid selection");
			enterShop();
		} // end switch: applies action dependent on user's choice
	} // end method enterShop

	/**
	 * Interprets user's choice at the "buy item" menu.
	 */
	private void buyItem() {
		System.out.println("\nYou have " + player.getGold() + " gold pieces.");
		System.out.println("Your options are:");
		System.out.println(shop.getInv().getInvAsString()); // display shop's
															// inventory

		int choice = reader.nextInt();
		if (choice == 0) {
			inVillage();
		} // end if: exits shop if user selects "exit"
		else {

			if (shop.getInv().getItems().get(choice - 1).getPrice() > player.getGold()) {
				System.out.println("\nYou do not have enough gold to purchase that item.");
				buyItem(); // returns to buy menu
			} // end if: makes sure player has enough gold to afford item

			shop.buy(player, choice - 1); // buy item if player has enough gold
			buyItem(); // return to buy menu
		} // end else: purchases item that user selected
	} // end method buyItem

	/**
	 * Interprets choice at "sell item" menu.
	 */
	private void sellItem() {
		System.out.println("\nYou have " + player.getGold() + " gold pieces.");
		System.out.println("Your options are:");
		System.out.println(player.getInv().getInvAsString()); // display
																// player's
																// inventory

		int choice = reader.nextInt();
		if (choice == 0) {
			inVillage();
		} // end if: exits shop if user selects "exit"
		else {
			player.sell(choice - 1); // sell item
			sellItem(); // return to sell item menu
		} // end else: sells item that user selected
	} // end method sellItem

	/**
	 * Interprets user's choice at tavern menu.
	 */
	private void enterTavern() {
		System.out.println("\nYou enter the tavern.");
		System.out.println("You have " + player.getHealth() + "/" + player.getMaxHealth() + " Health Points,");
		System.out.println("and " + player.getMana() + "/" + player.getMaxMana() + " Mana Points.");
		System.out.println("You have " + player.getGold() + " gold pieces.");

		View.tavernMenu();
		if (reader.nextInt() == 1) { // stay the night
			if (player.getGold() < 10) {
				System.out.println("You do not have enough gold to afford a room.");
				inVillage();
			} // end if: makes sure player has enough gold to stay at tavern

			Tavern.sleep(player);
			inVillage();
		} // end if: player sleeps if user selects "sleep" option
		else { // return to village
			inVillage();
		} // end else: returns to village if user selects "exit" option
	} // end method enterTavern

	/**
	 * Interprets user's choice at equip gear menu.
	 */
	private void equipGear() {
		System.out.println("\nCurrent equipped weapon: " + player.getEqWep().getName());
		System.out.println("Current equipped armor: " + player.getEqArm().getName());
		System.out.println("Select an item to equip:");
		System.out.println(player.getInv());

		int choice = reader.nextInt();
		if (choice == 0) {
			inVillage();
		} // end if: returns player to village if they select "exit"
		else {
			Item item = player.getInv().getItems().get(choice - 1);
			if (!item.isDrinkable()) { // if item isn't a potion

				if (item instanceof Weapon) {
					player.getInv().getItems().add(player.getEqWep()); // adds
																		// current
																		// weapon
																		// back
																		// to
																		// inv
					player.setEqWep((Weapon) player.getInv().getItems().remove(choice - 1));
				} // end if: if item is a weapon, equip it as a weapon

				else {
					player.getInv().getItems().add(player.getEqArm()); // adds
																		// current
																		// armor
																		// back
																		// to
																		// inv
					player.setEqArm((Armor) player.getInv().getItems().remove(choice - 1));
				} // end else: if item is armor, equip it as armor

				System.out.println(player.getName() + " equipped the " + item.getName() + ".");
				equipGear();
			} // end if: checks if item is a potion, and if it isn't, equips it
			else {
				System.out.println("You cannot equip that item.");
				equipGear();
			} // end else: prevents player from equipping a potion
		} // end else: equips item if it isn't a potion
	} // end method equipGear

	/**
	 * Interprets user's choice at exit game screen.
	 */
	private void exitGame() {
		View.quitMenu();

		int choice = reader.nextInt();
		if (choice == 1) {
			System.out.println("Goodbye!");
			System.exit(1);
		} // end if: exits game if user selects "yes"
		else {
			inVillage();
		} // end else: returns player to village
	} // end method exitGame

	/**
	 * Interpret user's choice at dungeon entry menu.
	 */
	private void enterDungeon() {
		if (dungeon.getCurrentFloor() == dungeon.getFloors().length) {
			View.bossText(); // if at last floor, begin boss event

			int choice = reader.nextInt();
			if (choice == 2) {
				inVillage();
			} // end if: returns player to village if they select "no"
			else {
				bossEncounter();
			} // end else: sends player to boss encounter if they select "yes"
		} // end if: // triggers boss event if all dungeon floors have been
			// cleared

		View.dungeonIntroMenu();
		int choice = reader.nextInt();
		if (choice == 2) {
			inVillage();
		} // end if: returns player to village if they select "no"
		else {
			dungeon.getFloors()[dungeon.getCurrentFloor()] = new Floor(player.getLevel()); // generates
																							// current
																							// floor

			// welcome message
			System.out.println("\nWelcome to the Dungeon!");
			// state current floor
			System.out.println("You are currently on floor " + (dungeon.getCurrentFloor() + 1) + ".");
			// state current floor's environment's name
			System.out.println(
					"This is " + dungeon.getFloors()[dungeon.getCurrentFloor()].getEnvironment().getName() + ".");
			// state current floor's environment's description
			System.out.println(dungeon.getFloors()[dungeon.getCurrentFloor()].getEnvironment().getDescription());

			encounter();
		} // end else: lets player into dungeon if they select "yes"
	} // end method enterDungeon

	/**
	 * Generate and encounter a monster.
	 */
	private void encounter() {
		Monster monster = dungeon.getFloors()[dungeon.getCurrentFloor()].getMonsters().get(0); // generate
																								// a
																								// monster
		System.out.println("\nYou encountered a " + monster.getName() + "!");
		combat(monster); // start combat with monster
	} // end method encounter

	/**
	 * Begin combat with a monster.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void combat(Monster monster) {
		if (player.getEffectiveSpeed() >= monster.getEffectiveSpeed()) {
			playerTurn(monster);
		} // initiates player's turn if they are faster
		else {
			monsterTurn(monster);
		} // end else: initiates monster's turn if monster is faster
	} // end method combat

	/**
	 * Initiates player's turn in combat.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void playerTurn(Monster monster) {
		System.out.println(
				"\n" + player.getName() + " has " + player.getHealth() + " HP and " + player.getMana() + " MP.");
		System.out.println("The " + monster.getName() + " has " + monster.getHealth() + " HP.");

		View.combatMenu();
		int choice = reader.nextInt();
		switch (choice) {
		// Physical Attack
		case 1:
			physicalAttack(monster);
			// Magical Attack
		case 2:
			castSpell(monster);
			// Use Item
		case 3:
			useItem(monster);
		} // end switch: player performs action based upon user's choice
	} // end method combat

	/**
	 * Performs action if user selects to use a physical attack.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void physicalAttack(Monster monster) {
		int damage = player.getAttackValue() - monster.getDefenseValue();
		if (damage < 1)
			damage = 1; // limits minimum amount of damage dealt

		monster.setHealth(monster.getHealth() - damage); // monster takes damage

		System.out.println("\n" + player.getName() + " deals " + damage + " damage to the " + monster.getName() + "!");

		if (monster.getHealth() == 0) {

			if (monster instanceof Boss) {
				bossVictory((Boss) monster);
			} // end if: if boss was just killed, call special method

			victory(monster);
		} // end if: checks if monster is dead, and calls victory method if so

		else {

			if (monster instanceof Boss) {
				bossTurn((Boss) monster);
			} // end if: performs special turn if enemy is the boss

			monsterTurn(monster);
		} // end else: initiates monster's turn after player's turn is over
	} // end method physicalAttack

	/**
	 * Perform action if user selects to use magic.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void castSpell(Monster monster) {
		System.out.println("\nChoose a spell:");
		System.out.println(player.getSpellbook());

		int choice = reader.nextInt();
		if (choice == 0) {
			playerTurn(monster);
		} // end if: returns user to selection screen if the choose "go back"

		if (player.getMana() < player.getSpellbook().getSpells().get(choice - 1).getManaCost()) {
			System.out.println("\nYou don't have enough mana to cast that.");
			castSpell(monster); // returns to magic menu
		} // end if: prevents player from casting spell if they don't have
			// enough mana

		player.getSpellbook().getSpells().get(choice - 1).cast(player, monster); // cast
																					// selected
																					// spell

		if (monster.getHealth() == 0) {

			if (monster instanceof Boss) {
				bossVictory((Boss) monster);
			} // end if: performs special victory method if boss just died

			victory(monster);
		} // end if: checks if monster is dead, and calls victory method if so

		if (monster instanceof Boss) {
			bossTurn((Boss) monster);
		} // end if: performs special turn if enemy is the boss

		monsterTurn(monster);
	} // end method castSpell

	/**
	 * Display game clear text and end the game.
	 * 
	 * @param boss
	 *            Boss that player was fighting.
	 */
	private void bossVictory(Boss boss) {
		View.gameClear(boss.getName(), player.getName());
		System.exit(1);
	} // end method bossVictory

	/**
	 * Perform action if user selects to use an item in combat.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void useItem(Monster monster) {
		System.out.println("Choose an item:");
		System.out.println(player.getInv().getPotions()); // display all potions

		int choice = reader.nextInt();
		if (choice == 0) {
			playerTurn(monster);
		} // end if: goes back if user's selection is "go back"

		// otherwise, drink selected potion
		((HealthPotion) player.getInv().getPotions().getItems().get(choice)).drink(player);
	} // end method useItem

	/**
	 * Perform monster's turn during combat.
	 * 
	 * @param monster
	 *            Monster that player is fighting.
	 */
	private void monsterTurn(Monster monster) {
		int damage = monster.getAttackValue() - player.getDefenseValue();
		if (damage < 1)
			damage = 1; // limits minimum amount of damage that can be dealt

		player.setHealth(player.getHealth() - damage); // player takes damage
		if (player.getHealth() == 0) {
			Death death = new Death(player, dungeon);
			death.playerDeath();
			System.exit(1);
		} // end if: if player dies, perform appropriate actions

		System.out.println("The " + monster.getName() + " dealt " + damage + " damage to " + player.getName() + "!");
		playerTurn(monster);
	} // end method monsterTurn

	/**
	 * Performs boss's turn during combat.
	 * 
	 * @param boss
	 *            Boss that player is fighting.
	 */
	private void bossTurn(Boss boss) {
		int choice = (int) (Math.random() * 2 + 1); // randomly choose physical
													// attack or cast spell
		if (choice == 1) { // if boss chooses physical attack
			int damage = boss.getAttackValue() - player.getDefenseValue();
			player.setHealth(player.getHealth() - damage);

			System.out.println("The " + boss.getName() + " attacked " + player.getName() + " with its "
					+ boss.getEqWep().getName());
			System.out.println("The " + boss.getName() + " dealt " + damage + " damage to " + player.getName() + "!");

			if (player.getHealth() == 0) {
				Death death = new Death(player, dungeon);
				death.playerDeath();
				System.exit(1);
			} // end if: if player dies, perform appropriate actions

			playerTurn(boss);
		} // end if: executes a physical attack on player

		else { // if boss chooses to cast a spell
			int spellChoice = (int) (Math.random() * boss.getSpellbook().getSpells().size());
			Spell spell = boss.getSpellbook().getSpells().get(spellChoice);
			spell.cast(boss, player);

			if (player.getHealth() == 0) {
				Death death = new Death(player, dungeon);
				death.playerDeath();
				System.exit(1);
			} // end if: if player dies, perform appropriate actions

			playerTurn(boss);
		} // end else: casts a random spell
	} // end method bossTurn

	/**
	 * Performs actions when player defeats enemy (give exp, give gold, etc).
	 * 
	 * @param monster
	 *            Monster that player just defeated.
	 */
	private void victory(Monster monster) {
		System.out.println(player.getName() + " defeated the " + monster.getName() + "!");

		System.out.println(
				player.getName() + " collected the dead " + monster.getName() + "'s " + monster.getGold() + " gold.");
		player.setGold(player.getGold() + monster.getGold()); // adds dead
																// monsters gold
																// to player's

		System.out.println(player.getName() + " got " + monster.getLevel() + " exp.");
		player.setExp(player.getExp() + monster.getLevel()); // gives player exp

		player.setKillCount(player.getKillCount() + 1); // increments player's
														// kill count

		dungeon.getFloors()[dungeon.getCurrentFloor()].getMonsters().remove(0); // removes
																				// dead
																				// monster
																				// from
																				// the
																				// Floor

		if (dungeon.getFloors()[dungeon.getCurrentFloor()].getMonsters().size() == 0) {
			System.out.println("\nCongratulations, you have cleared floor " + (dungeon.getCurrentFloor() + 1) + "!");
			dungeon.setCurrentFloor(dungeon.getCurrentFloor() + 1); // increment
																	// current
																	// floor

			shop.populateInv(player.getLevel()); // repopulate shop inventory

			System.out.println("You make your way back to the village.");
			inVillage();
		} // end if: handles case when current floor has been cleared of
			// monsters

		encounter(); // if floor isn't empty, fight another monster
	} // end method victory

	/**
	 * Initiates fight with the boss
	 */
	private void bossEncounter() {
		Boss boss = new Boss(player.getLevel()); // instantiates the boss with
													// same level as player
		View.bossEncounterText(boss.getEqWep().getName(), boss.getEqArm().getName());
		playerTurn(boss);
	} // end method bossEncounter
} // end class Game
package rpg_package;

/**
 * A shop that possesses its own inventory, and can have items bought from it.
 * 
 * @author Trevor Nelson
 */
public class Shop {
	private Inventory inv;

	/**
	 * Constructs a shop with an empty inventory, then populates the inventory
	 * using a level parameter of 1.
	 */
	public Shop() {
		inv = new Inventory();
		populateInv(1);
	} // end constructor

	/**
	 * Populates the shop's inventory with 5 items (2 potions, 3 weapons or
	 * armor) based upon a given level.
	 * 
	 * @param level
	 *            The desired level (determines power of items in inventory).
	 */
	public void populateInv(int level) {
		inv.getItems().clear(); // clears inv first

		// add 2 potions of the given level
		inv.getItems().add(new HealthPotion(level));
		inv.getItems().add(new ManaPotion(level));

		// adds 3 weapons or armor, with increasing level
		int i = 0;
		while (i < 3) {
			int randNum = (int) (Math.random() * 2);
			if (randNum == 0) {
				inv.getItems().add(Weapon.generate(level + i));
			} // end if: 50% of the time generates a weapon
			else if (randNum == 1) {
				inv.getItems().add(Armor.generate(level + i));
			} // end else: 50% of the time generates armor
			i++;
		} // end while: generates 3 items (weapon or armor) with increasing
			// power levels
	} // end method populateInv

	/**
	 * Allows the given player to purchase an item from the shop's inventory.
	 * 
	 * @param buyer
	 *            The player who is buying the item.
	 * @param index
	 *            The index in the shop's inventory of the item that the player
	 *            wants to buy.
	 */
	public void buy(Player buyer, int index) {
		buyer.setGold(buyer.getGold() - inv.getItems().get(index).getPrice());
		// takes appropriate amount of gold from player
		System.out.println();
		View.spendGoldText(buyer.getName(), inv.getItems().get(index).getPrice());

		String itemName = inv.getItems().get(index).getName();

		if (inv.getItems().get(index).isDrinkable()) {
			buyer.getInv().getItems().add(inv.getItems().get(index)); // gives
																		// player
																		// item
		} // end if: if item is a potion, don't remove it, b/c there are
			// infinite number of them
		else {
			buyer.getInv().getItems().add(inv.getItems().remove(index)); // gives
																			// player
																			// item
		} // end else: if item is not a potion, remove it from inv

		View.recieveItemText(buyer.getName(), itemName);
	} // end method buy

	public Inventory getInv() {
		return inv;
	} // end method getInv

	public void setInv(Inventory inv) {
		this.inv = inv;
	} // end method setInv
} // end class Shop
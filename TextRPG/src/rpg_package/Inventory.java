package rpg_package;

import java.util.ArrayList;

/**
 * Contains a list of items, as well as some useful methods to manipulate the
 * list.
 * 
 * @author Trevor Nelson
 */
public class Inventory {
	private ArrayList<Item> items;

	/**
	 * Constructs an Inventory with an empty list of items.
	 */
	public Inventory() {
		items = new ArrayList<Item>();
	} // end constructor

	/**
	 * Constructs an Inventory with a given list of items.
	 * 
	 * @param items
	 *            The list of items to create the Inventory with.
	 */
	public Inventory(ArrayList<Item> items) {
		this.items = items;
	} // end constructor

	/**
	 * Returns the Inventory in the form of a string, with each item being
	 * printed with a corresponding number, as well as the item's price. This
	 * method also adds a final "Go Back" option to the end of the string to
	 * facilitate its use in menus.
	 * 
	 * @return A string of all the items within the inventory, listed with a
	 *         corresponding number and their price, as well as a final
	 *         "Go Back" option added to the end of the string.
	 */
	public String getInvAsString() {
		String str = "";
		for (int i = 0; i < items.size(); i++) {
			str += i + 1 + ") " + items.get(i).getName() + " (" + items.get(i).getPrice() + "g)\n";
		} // end for: adds all items and their prices to a string
		str += "0) Go Back";
		return str;
	} // end method viewInv

	/**
	 * Returns a version of the current inventory that only contains potions.
	 * 
	 * @return A copy of the current inventory, but it only contains potions.
	 */
	public Inventory getPotions() {
		ArrayList<Item> potions = new ArrayList<Item>();
		for (Item item : items) {
			if (item.isDrinkable()) {
				potions.add(item);
			} // end if: adds item to potions if it is a potion
		} // end for-each: looks at all items and checks if they are drinkable
		Inventory inv = new Inventory(potions);
		return inv;
	} // end method getPotions

	public ArrayList<Item> getItems() {
		return items;
	} // end method getItems

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	} // end method setItems

	/**
	 * Returns the inventory as a String, with each item being listed with a
	 * corresponding number, but no prices are listed. A "Go Back" token is also
	 * added to the end to facilitate use in menus.
	 * 
	 * @return A string containing all the items in the inventory, with each one
	 *         having its own number, and an extra "Go Back" option added to the
	 *         end.
	 * @Override
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < items.size(); i++)
			str += i + 1 + ") " + items.get(i).getName() + "\n";
		str += "0) Go Back";
		return str;
	} // end method toString
} // end class Inventory
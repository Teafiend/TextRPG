package rpg_package;

import java.util.ArrayList;

/**
 * Holds a list of spells, and a toString to convert them into a single string.
 * 
 * @author Trevor Nelson
 */
public class Spellbook {
	private ArrayList<Spell> spells;

	/**
	 * Constructs a Spellbook with an empty list of spells
	 */
	public Spellbook() {
		spells = new ArrayList<Spell>();
	} // end constructor

	public ArrayList<Spell> getSpells() {
		return spells;
	} // end method getSpells

	public void setSpells(ArrayList<Spell> spells) {
		this.spells = spells;
	} // end method setSpells

	/**
	 * Returns all spells in list as a String, with each spell being associated
	 * with a number, and a "Go Back" option being added at the end to
	 * facilitate use in menus.
	 * 
	 * @return A String that contains all spells in the list and associates them
	 *         each with unique numbers, as well as placing a "Go Back" option
	 *         at the end of the String.
	 * @Override
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < spells.size(); i++) {
			str += i + 1 + ") " + spells.get(i).getName() + "\n";
		} // end for: adds all spells to the string
		str += "0) Go Back";
		return str;
	} // end method toString
} // end class Spellbook
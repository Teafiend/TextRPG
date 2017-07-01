package rpg_package;

/**
 * An extension of Character that has unique stat generation, and unique methods
 * to generate attack value, defense value, and effective speed.
 * 
 * @author Trevor Nelson
 */
public class Monster extends Character {

	/**
	 * Constructs a Monster using a given name and level.
	 * 
	 * @param name
	 *            The monster's name.
	 * @param level
	 *            The monster's level.
	 */
	public Monster(String name, int level) {
		this.name = name;
		this.level = level;
		maxHealth = level * 50;
		health = level * 50;
		maxMana = level * 50;
		mana = level * 50;
		strength = level * 5;
		fortitude = level * 5;
		speed = level * 5;
		intellect = level * 5;
		gold = level * 10;
	} // end constructor

	/**
	 * Constructs a monster using default values. Required by Monster's Boss
	 * subclass.
	 */
	public Monster() {
		name = "";
		level = 1;
		maxHealth = 0;
		health = 0;
		maxMana = 0;
		mana = 0;
		strength = 0;
		fortitude = 0;
		speed = 0;
		intellect = 0;
		gold = 0;
	} // end default constructor

	@Override
	public int getEffectiveSpeed() {
		return speed;
	} // end method getEffectiveSpeed

	@Override
	public int getAttackValue() {
		return strength;
	} // end method getAttackValue

	@Override
	public int getDefenseValue() {
		return fortitude;
	} // end method getDefenseValue
} // end class Monster
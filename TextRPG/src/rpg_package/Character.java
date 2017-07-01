package rpg_package;
/**
 * The superclass for all other creatures in the game, and possesses many
 * attributes and stats.
 * 
 * @author Trevor
 */
public abstract class Character {
	protected String name;
	protected int level;
	protected int maxHealth;
	protected int health;
	protected int maxMana;
	protected int mana;
	protected int strength;
	protected int fortitude;
	protected int speed;
	protected int intellect;
	protected int gold;

	public String getName() {
		return name;
	} // end method getName

	public void setName(String name) {
		this.name = name;
	} // end method setName

	public int getLevel() {
		return level;
	} // end method getLevel

	public void setLevel(int level) {
		this.level = level;
	} // end method setLevel

	public int getMaxHealth() {
		return maxHealth;
	} // end method getMaxHealth

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	} // end method setMaxHealth

	public int getHealth() {
		return health;
	} // end method getHealth

	/**
	 * Sets the character's health, and prevents it from exceeding the maximum
	 * or minimum values.
	 * 
	 * @param health
	 *            The desired health.
	 */
	public void setHealth(int health) {
		this.health = health;
		if (this.health > maxHealth)
			this.health = maxHealth;
		else if (this.health < 0)
			this.health = 0;
	} // end method setHealth

	public int getMaxMana() {
		return maxMana;
	} // end method getMaxMana

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	} // end method setMaxMana

	public int getMana() {
		return mana;
	} // end method getMana

	/**
	 * Sets the characters mana, and prevents it from exceeding the maximum or
	 * minimum values.
	 * 
	 * @param mana
	 *            The desired mana.
	 */
	public void setMana(int mana) {
		this.mana = mana;
		if (this.mana > maxMana)
			this.mana = maxMana;
		else if (this.mana < 0)
			this.mana = 0;
	} // end method setMana

	public int getStrength() {
		return strength;
	} // end method getStrength

	public void setStrength(int strength) {
		this.strength = strength;
	} // end method setStrength

	public int getFortitude() {
		return fortitude;
	} // end method getFortitude

	public void setFortitude(int fortitude) {
		this.fortitude = fortitude;
	} // end method setFortitude

	public int getSpeed() {
		return speed;
	} // end method getSpeed

	public void setSpeed(int speed) {
		this.speed = speed;
	} // end method setSpeed

	public int getIntellect() {
		return intellect;
	} // end method getIntellect

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	} // end method setIntellect

	public int getGold() {
		return gold;
	} // end method getGold

	public void setGold(int gold) {
		this.gold = gold;
	} // end method setGold

	public abstract int getEffectiveSpeed();

	public abstract int getAttackValue();

	public abstract int getDefenseValue();
} // end class Character
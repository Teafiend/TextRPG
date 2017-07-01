package rpg_package;

/**
 * An extension of Character that has its own inventory, spellbook, equipped
 * weapon, equipped armor, experience points, experience points needed to level
 * up, and a counter of monsters killed.
 * 
 * @author Trevor Nelson
 */
public class Player extends Character {
	private Inventory inv;
	private Spellbook spellbook;
	private int exp;
	private int expNeeded;
	private Weapon eqWep;
	private Armor eqArm;
	private int killCount;

	/**
	 * Constructs a Player using a given name.
	 * 
	 * @param name
	 *            The player's name.
	 */
	public Player(String name) {
		this.name = name;
		level = 1;
		maxHealth = 100;
		health = 100;
		maxMana = 100;
		mana = 100;
		strength = 10;
		fortitude = 10;
		speed = 10;
		intellect = 10;
		gold = 20;
		inv = new Inventory();
		spellbook = new Spellbook();
		// populate the spellbook with basic spells
		spellbook.getSpells().add(AttackSpell.MAGICMISSILE);
		spellbook.getSpells().add(HealSpell.LESSERHEAL);
		exp = 0;
		expNeeded = 5;
		// generate armor and a weapon
		eqWep = Weapon.generate(level);
		eqArm = Armor.generate(level);
		killCount = 0;
	} // end constructor

	public Inventory getInv() {
		return inv;
	} // end method getInv

	public void setInv(Inventory inv) {
		this.inv = inv;
	} // end method setInv

	public Spellbook getSpellbook() {
		return spellbook;
	} // end method getSpellbook

	public void setSpellbook(Spellbook spellbook) {
		this.spellbook = spellbook;
	} // end method setSpellbook

	public int getExp() {
		return exp;
	} // end method getExp

	/**
	 * Sets the player's experience points, and resets experience points and
	 * levels up the character when they have more exp than the needed amount of
	 * exp.
	 * 
	 * @param exp
	 *            The desired amount of experience points.
	 */
	public void setExp(int exp) {
		this.exp = exp;
		if (this.exp >= expNeeded) {
			this.exp -= expNeeded; // resets exp points when player levels up
			levelUp();
		} // end if: levels up player if they have enough exp
	} // end method

	public Weapon getEqWep() {
		return eqWep;
	} // end method getEqWep

	public void setEqWep(Weapon eqWep) {
		this.eqWep = eqWep;
	} // end method setEqWep

	public Armor getEqArm() {
		return eqArm;
	} // end method getEqArm

	public void setEqArm(Armor eqArm) {
		this.eqArm = eqArm;
	} // end method setEqArm

	public int getExpNeeded() {
		return expNeeded;
	} // end method getExpNeeded

	public void setExpNeeded(int expNeeded) {
		this.expNeeded = expNeeded;
	} // end method setExpNeeded

	public int getKillCount() {
		return killCount;
	} // end method getKillCount

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	} // end method setKillCount

	/**
	 * Levels up the character (increases their level, needed exp for next level
	 * up, as well as other stats).
	 */
	public void levelUp() {
		level++;
		expNeeded += 5;
		maxHealth += 10;
		health = maxHealth;
		maxMana += 10;
		mana = maxMana;
		strength++;
		fortitude++;
		speed++;
		intellect++;
		View.levelUpText(name, level, expNeeded);

		if (level == 5) {
			spellbook.getSpells().add(AttackSpell.FIREBALL);
			spellbook.getSpells().add(HealSpell.HOLYLIGHT);
			System.out.println(name + " has learned how to cast " + AttackSpell.FIREBALL.getName() + " and "
					+ HealSpell.HOLYLIGHT.getName() + ".");
		} // end if: adds new spells to player's spellbook once they reach level
			// 5
		else if (level == 10) {
			spellbook.getSpells().add(AttackSpell.CHAOSBOLT);
			spellbook.getSpells().add(HealSpell.LIFEBLOOM);
			System.out.println(name + " has learned how to cast " + AttackSpell.CHAOSBOLT.getName() + " and "
					+ HealSpell.LIFEBLOOM.getName() + ".");
		} // end else-if: adds new spells to player's spellbook once they reach
			// level 10
	} // end method levelUp

	/**
	 * Sells an item from the player's inventory, removing it, and giving the
	 * player an amount of gold.
	 * 
	 * @param index
	 *            The desired item's index in the player's inventory.
	 */
	public void sell(int index) {
		int value = inv.getItems().get(index).getPrice();
		String itemName = inv.getItems().get(index).getName();
		inv.getItems().remove(index); // removes item
		gold += value; // gives player gold
		View.sellText(name, itemName, value);
	} // end method sell

	/**
	 * Returns the player's effective speed based upon their speed stat, armor,
	 * and weapon.
	 * 
	 * @return Player's effective speed.
	 * @Override
	 */
	public int getEffectiveSpeed() {
		return (int) Math.round(eqWep.getSpeedMod() * eqArm.getSpeedMod() * speed);
	} // end method getEffectiveSpeed

	/**
	 * Returns the player's attack value based upon their strength stat and
	 * weapon.
	 * 
	 * @return Player's attack value.
	 * @Override
	 */
	public int getAttackValue() {
		return strength * eqWep.getAtkVal();
	} // end method getAttackValue

	/**
	 * Returns the player's defense value based upon their fortitude stat and
	 * armor.
	 * 
	 * @return Player's defense value.
	 * @Override
	 */
	public int getDefenseValue() {
		return fortitude * eqArm.getDefVal();
	} // end method getDefenseValue
} // end class Player
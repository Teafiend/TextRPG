package rpg_package;

/**
 * A type of Monster that also has its own equipped armor and weapon, as well as
 * its own spellbook, and serves as the final enemy of the game.
 * 
 * @author Trevor Nelson
 */
public class Boss extends Monster {
	private Weapon eqWep;
	private Armor eqArm;
	private Spellbook spellbook;

	/**
	 * Constructs a boss with a given level.
	 * 
	 * @param level
	 *            The level of the boss.
	 */
	public Boss(int level) {
		this.level = level;
		name = "Skeletal Warlock";
		maxHealth = level * 100;
		health = level * 100;
		maxMana = level * 100;
		mana = level * 100;
		strength = level * 10;
		fortitude = level * 10;
		speed = level * 10;
		intellect = level * 10;
		gold = level * 100;
		eqWep = Weapon.generate(level);
		eqArm = Armor.generate(level);
		spellbook = new Spellbook();
		spellbook.getSpells().add(AttackSpell.SOULFISSURE);
	} // end constructor

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

	public Spellbook getSpellbook() {
		return spellbook;
	} // end method getSpellbook

	public void setSpellbook(Spellbook spellbook) {
		this.spellbook = spellbook;
	} // end method setSpellbook

	/**
	 * Returns the boss's attack value.
	 * 
	 * return Boss's attack value.
	 * 
	 * @Override
	 */
	public int getAttackValue() {
		return strength * eqWep.getAtkVal();
	} // end method getAttackValue

	/**
	 * Returns the boss's defense value.
	 * 
	 * @return Boss's defense value.
	 * @Override
	 */
	public int getDefenseValue() {
		return fortitude * eqArm.getDefVal();
	} // end method getDefenseValue

	/**
	 * Returns the boss's effective speed.
	 * 
	 * @return Boss's effective speed
	 * @Override
	 */
	public int getEffectiveSpeed() {
		return (int) Math.round(eqWep.getSpeedMod() * eqArm.getSpeedMod() * speed);
	} // end method getEffectiveSpeed
} // end class Boss
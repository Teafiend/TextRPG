package rpg_package;

/**
 * A type of spell that recovers the caster's health at the cost of their mana.
 * 
 * @author Trevor Nelson
 */
public class HealSpell extends Spell {
	public final static HealSpell LESSERHEAL = new HealSpell("Lesser Heal", 10, 5);
	public final static HealSpell HOLYLIGHT = new HealSpell("Holy Light", 15, 10);
	public final static HealSpell LIFEBLOOM = new HealSpell("Lifebloom", 20, 15);

	/**
	 * Constructs a spell using a given name, power, and mana cost
	 * 
	 * @param name
	 *            The spell's name.
	 * @param power
	 *            The spell's power (modifies amount the spell heals).
	 * @param manaCost
	 *            The spell's mana cost.
	 */
	public HealSpell(String name, int power, int manaCost) {
		this.name = name;
		this.power = power;
		this.manaCost = manaCost;
	} // end constructor

	/**
	 * Restores the caster's health at the cost of their mana (enemy is
	 * unaffected)
	 * 
	 * @param caster
	 *            The character who is casting the spell.
	 * @param enemy
	 *            The enemy who the caster is currently fighting.
	 */
	public void cast(Character caster, Character enemy) {
		caster.setHealth(caster.getHealth() + (power * caster.getIntellect()));
		caster.setMana(caster.getMana() - manaCost);
		View.healSpellText(caster.getName(), caster.getName(), name, power * caster.getIntellect());
	} // end method cast
} // end class HealSpell
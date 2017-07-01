package rpg_package;

/**
 * A type of spell that deals damage to an enemy and consumes mana from the
 * caster.
 * 
 * @author Trevor
 */
public class AttackSpell extends Spell {
	public final static AttackSpell MAGICMISSILE = new AttackSpell("Magic Missile", 10, 5);
	public final static AttackSpell FIREBALL = new AttackSpell("Fireball", 15, 10);
	public final static AttackSpell CHAOSBOLT = new AttackSpell("Chaos Bolt", 20, 15);
	public final static AttackSpell SOULFISSURE = new AttackSpell("Soul Fissure", 30, 25);

	/**
	 * Constructs an attack spell with a given name, power, and mana cost.
	 * 
	 * @param name
	 *            The attack spell's name.
	 * @param power
	 *            The attack spell's power (modifies damage dealt to enemy).
	 * @param manaCost
	 *            The attack spell's mana cost.
	 */
	public AttackSpell(String name, int power, int manaCost) {
		this.name = name;
		this.power = power;
		this.manaCost = manaCost;
	} // end constructor

	/**
	 * Casts the attack spell using a given caster and a given enemy.
	 * 
	 * @param caster
	 *            The character who is casting the spell.
	 * @param enemy
	 *            The character who is being attacked with the spell.
	 * @Override
	 */
	public void cast(Character caster, Character enemy) {
		enemy.setHealth(enemy.getHealth() - (power * caster.getIntellect()));
		caster.setMana(caster.getMana() - manaCost);
		View.attackSpellText(caster.getName(), enemy.getName(), name, power * caster.getIntellect());
	} // end method cast
} // end class AttackSpell
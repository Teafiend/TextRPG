package rpg_package;

/**
 * Extending subclasses of this recieve a name, spell power, mana cost, and a
 * description
 * 
 * @author Trevor Nelson
 */
public abstract class Spell {
	protected String name;
	protected int power;
	protected int manaCost;

	public String getName() {
		return name;
	} // end method getName

	public void setName(String name) {
		this.name = name;
	} // end method setName

	public int getPower() {
		return power;
	} // end method getPower

	public void setPower(int power) {
		this.power = power;
	} // end method setPower

	public int getManaCost() {
		return manaCost;
	} // end method getManaCost

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	} // end method setManaCost

	protected abstract void cast(Character caster, Character enemy);
} // end class Spell
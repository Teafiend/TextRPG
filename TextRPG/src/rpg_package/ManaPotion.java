package rpg_package;

/**
 * A type of item that recovers the drinker's mana.
 * 
 * @author Trevor Nelson
 */
public class ManaPotion extends Item implements Potion {
	private int power;

	/**
	 * Constructs a mana potion with a given power.
	 * 
	 * @param power
	 *            The potion's power (determines how much mana it restores).
	 */
	public ManaPotion(int power) {
		drinkable = true;
		this.power = power;
		price = power * 5;
		name = "+" + power + " Mana Potion";
	} // end constructor

	/**
	 * The given character drinks the potion and recovers an amount of mana.
	 * 
	 * @param drinker
	 *            The character who is drinking the potion.
	 * @Override
	 */
	public void drink(Character drinker) {
		drinker.setMana(drinker.getMana() + power);
		View.potionText(drinker.getName(), name, "Mana", power);
	} // end method drink

	public int getPower() {
		return power;
	} // end method getPower

	public void setPower(int power) {
		this.power = power;
	} // end method setPower
} // end class ManaPotion
package rpg_package;

/**
 * A type of item that recovers the drinker's health.
 * 
 * @author Trevor Nelson
 */
public class HealthPotion extends Item implements Potion {
	private int power;

	/**
	 * Constructs a health potion using a given power.
	 * 
	 * @param power
	 *            The potion's power (determines the amount it heals and costs).
	 */
	public HealthPotion(int power) {
		drinkable = true;
		this.power = power;
		price = power * 5;
		name = "+" + power + " Health Potion";
	} // end constructor

	/**
	 * The given character drinks the potion and recovers an amount of health.
	 * 
	 * @param drinker
	 *            The character who is drinking the potion.
	 */
	public void drink(Character drinker) {
		drinker.setHealth(drinker.getHealth() + power);
		View.potionText(drinker.getName(), name, "Health", power);
	} // end method drink

	public int getPower() {
		return power;
	} // end method getPower

	public void setPower(int power) {
		this.power = power;
	} // end method setPower
} // end class HealthPotion
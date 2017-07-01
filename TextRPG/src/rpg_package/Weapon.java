package rpg_package;

/**
 * A type of item that can be equipped by the player (or boss) to increase their
 * attack value.
 * 
 * @author Trevor Nelson
 */
public class Weapon extends Item {
	private int mod;
	private int atkVal;
	private Material material;
	private WepType type;

	/**
	 * Constructs a Weapon using the given modifier, material, and weapon type.
	 * 
	 * @param mod
	 *            The weapon's modifier (used to compute attack value and
	 *            price).
	 * @param material
	 *            The weapon's material.
	 * @param type
	 *            The weapons type.
	 */
	public Weapon(int mod, Material material, WepType type) {
		this.mod = mod;
		this.material = material;
		this.type = type;
		atkVal = (int) Math.round(mod * material.getAtkMod() * type.getAtkMod());
		drinkable = false;
		price = mod * 10;
		name = "+" + mod + " " + material.getName() + " " + type.getName();
	} // end constructor

	public int getMod() {
		return mod;
	} // end method getMod

	public void setMod(int mod) {
		this.mod = mod;
	} // end method setMod

	public int getAtkVal() {
		return atkVal;
	} // end method getAtkVal

	public void setAtkVal(int atkVal) {
		this.atkVal = atkVal;
	} // end method setAtkVal

	public Material getMaterial() {
		return material;
	} // end method getMaterial

	public void setMaterial(Material material) {
		this.material = material;
	} // end method setMaterial

	public WepType getType() {
		return type;
	} // end method getType

	public void setType(WepType type) {
		this.type = type;
	} // end method setType

	public double getSpeedMod() {
		return material.getSpeedMod() * type.getSpeedMod();
	} // end method getSpeedMod

	/**
	 * Randomly generates and returns a weapon using the given level.
	 * 
	 * @param level
	 *            The level which will be used to determine the modifier of the
	 *            weapon.
	 * @return A randomly generated weapon.
	 */
	public static Weapon generate(int level) {
		// generate a random material
		int randNum = (int) (Math.random() * Material.MATERIALS.length);
		Material material = Material.MATERIALS[randNum];
		// generate a random weapon type
		randNum = (int) (Math.random() * WepType.WEPTYPES.length);
		WepType type = WepType.WEPTYPES[randNum];
		// assemble and return the new weapon
		return new Weapon(level, material, type);
	} // end method generate
} // end class Weapon
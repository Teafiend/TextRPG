package rpg_package;

/**
 * A type of item that can be equipped by the player (or boss) to increase their
 * defense value.
 * 
 * @author Trevor Nelson
 */
public class Armor extends Item {
	private int mod;
	private int defVal;
	private Material material;
	private ArmType type;

	/**
	 * Constructs an object of Armor using a given modifier, material, and armor
	 * type.
	 * 
	 * @param mod
	 *            The modifier of the armor (used to compute defense value and
	 *            price).
	 * @param material
	 *            The material of the armor.
	 * @param type
	 *            The armor type of the armor.
	 */
	public Armor(int mod, Material material, ArmType type) {
		this.mod = mod;
		this.material = material;
		this.type = type;
		defVal = (int) Math.round(mod * material.getDefMod() * type.getDefMod());
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

	public int getDefVal() {
		return defVal;
	} // end method getDefVal

	public void setDefVal(int defVal) {
		this.defVal = defVal;
	} // end method setDefVal

	public Material getMaterial() {
		return material;
	} // end method getMaterial

	public void setMaterial(Material material) {
		this.material = material;
	} // end method setMaterial

	public ArmType getType() {
		return type;
	} // end method getType

	public void setType(ArmType type) {
		this.type = type;
	} // end method setType

	public double getSpeedMod() {
		return material.getSpeedMod() * type.getSpeedMod();
	} // end method getSpeedMod

	/**
	 * Generates and returns a random piece of armor when given a level.
	 * 
	 * @param level
	 *            The level which will be used to determine the modifier of the
	 *            armor.
	 * @return A randomly generated piece of armor.
	 */
	public static Armor generate(int level) {
		// generate a random material
		int randNum = (int) (Math.random() * Material.MATERIALS.length);
		Material material = Material.MATERIALS[randNum];
		// generate a random armor type
		randNum = (int) (Math.random() * ArmType.ARMTYPES.length);
		ArmType type = ArmType.ARMTYPES[randNum];
		// assemble and return the new weapon
		return new Armor(level, material, type);
	} // end method generate
} // end class Armor
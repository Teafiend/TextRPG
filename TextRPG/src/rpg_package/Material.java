package rpg_package;

/**
 * An attribute of both Weapons and Armor that helps determine their name,
 * speed, attack value, and defense value.
 * 
 * @author Trevor Nelson
 */
public class Material {
	public final static Material IRON = new Material("Iron", 1.0, 1.0, 1.0);
	public final static Material ORCISH = new Material("Orcish", 1d, 1.5, 0.5);
	public final static Material EBONY = new Material("Ebony", 1.3, 1.3, 1.3);
	public final static Material DWARVEN = new Material("Dwarven", 0.5, 1.2, 1.3);
	public final static Material ELVEN = new Material("Elven", 1.3, 1.0, 0.7);

	public final static Material[] MATERIALS = { IRON, ORCISH, EBONY, DWARVEN, ELVEN };

	private String name;
	private double speedMod;
	private double atkMod;
	private double defMod;

	/**
	 * Constructs a Material using a given name, speed modifier, attack
	 * modifier, and defense modifier.
	 * 
	 * @param name
	 *            The material's name.
	 * @param speedMod
	 *            The material's speed modifier (modifies weapon and armor's
	 *            speed values).
	 * @param atkMod
	 *            The material's attack modifier (modifies weapon's attack
	 *            value).
	 * @param defMod
	 *            The material's defense modifier (modifies armor's defense
	 *            value).
	 */
	public Material(String name, double speedMod, double atkMod, double defMod) {
		this.name = name;
		this.speedMod = speedMod;
		this.atkMod = atkMod;
		this.defMod = defMod;
	} // end constructor

	public String getName() {
		return name;
	} // end method getName

	public void setName(String name) {
		this.name = name;
	} // end method setName

	public double getSpeedMod() {
		return speedMod;
	} // end method getSpeedMod

	public void setSpeedMod(double speedMod) {
		this.speedMod = speedMod;
	} // end method setSpeedMod

	public double getAtkMod() {
		return atkMod;
	} // end method getAtkMod

	public void setAtkMod(double atkMod) {
		this.atkMod = atkMod;
	} // end method setAtkMod

	public double getDefMod() {
		return defMod;
	} // end method getDefMod

	public void setDefMod(double defMod) {
		this.defMod = defMod;
	} // end method setDefMod
} // end class Material
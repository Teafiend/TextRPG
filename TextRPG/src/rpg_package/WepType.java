package rpg_package;

/**
 * An attribute of weapons which helps determine a weapon's name, speed value,
 * and attack value.
 * 
 * @author Trevor Nelson
 */
public class WepType {
	public final static WepType DAGGER = new WepType("Dagger", 1.5, .5);
	public final static WepType BATTLEAXE = new WepType("Battleaxe", .5, 1.5);
	public final static WepType LONGSWORD = new WepType("Longsword", 1.0, 1.0);

	public final static WepType[] WEPTYPES = { DAGGER, BATTLEAXE, LONGSWORD };

	private String name;
	private double speedMod;
	private double atkMod;

	/**
	 * Constructs a weapon type using a given name, speed modifier, and attack
	 * modifier.
	 * 
	 * @param name
	 *            The weapon type's name.
	 * @param speedMod
	 *            The weapon's speed modifier.
	 * @param atkMod
	 *            The weapon's attack modifier.
	 */
	public WepType(String name, double speedMod, double atkMod) {
		this.name = name;
		this.speedMod = speedMod;
		this.atkMod = atkMod;
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
} // end method WepType
package rpg_package;

/**
 * An attribute of Armor which helps to determine the armor's name, speed value,
 * and defense value.
 * 
 * @author Trevor Nelson
 */
public class ArmType {
	public final static ArmType HAUBERK = new ArmType("Hauberk", 1d, 1d);
	public final static ArmType PLATEMAIL = new ArmType("Plate Mail", 1d, 1d);
	public final static ArmType SCALEARMOR = new ArmType("Scale Armor", 1d, 1d);

	public final static ArmType[] ARMTYPES = { HAUBERK, PLATEMAIL, SCALEARMOR };

	private String name;
	private double speedMod;
	private double defMod;

	/**
	 * Constructs an armor type when given a name, a speed modifier, and a
	 * defense modifier.
	 * 
	 * @param name
	 *            The name of the armor type.
	 * @param speedMod
	 *            The armor type's speed modifier.
	 * @param defMod
	 *            The armor type's defense modifier.
	 */
	public ArmType(String name, double speedMod, double defMod) {
		this.name = name;
		this.speedMod = speedMod;
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

	public double getDefMod() {
		return defMod;
	} // end method getDefMod

	public void setDefMod(double defMod) {
		this.defMod = defMod;
	} // end method setDefMod
} // end class ArmType
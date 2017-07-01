package rpg_package;

/**
 * Contains an association of a name, description, and list of monsters to a
 * number of different environmental types.
 * 
 * @author Trevor Nelson
 */
public class Environment {
	public final static Environment MINES = new Environment("The Mines", "I hear snakes, I hate snakes...",
			new String[] { "Bat", "Spider", "Snake" });
	public final static Environment JUNGLE = new Environment("The Jungle",
			"The faint call of Tarzan can be heard in the distance.", new String[] { "Frog", "Monkey", "Snail" });
	public final static Environment ICECAVES = new Environment("The Ice Caves", "The air is frigid.",
			new String[] { "Yeti", "Alien", "Mammoth" });
	public final static Environment TEMPLE = new Environment("The Temple",
			"The stench of death and decay is powerful here.", new String[] { "Mummy", "Anubis", "Magma Man" });

	public final static Environment[] ENVIRONMENTS = { MINES, JUNGLE, ICECAVES, TEMPLE };

	private String name;
	private String description;
	private String[] monsters;

	/**
	 * Constructs an Environment using a given name, description, and array of
	 * monster names.
	 * 
	 * @param name
	 *            The name of the environment.
	 * @param description
	 *            The description of the environment.
	 * @param monsters
	 *            The array of possible monster names within the environment.
	 */
	public Environment(String name, String description, String[] monsters) {
		this.name = name;
		this.description = description;
		this.monsters = monsters;
	} // end constructor

	public String getName() {
		return name;
	} // end method getName

	public void setName(String name) {
		this.name = name;
	} // end method setName

	public String getDescription() {
		return description;
	} // end method getDescription

	public void setDescription(String description) {
		this.description = description;
	} // end method setDescription

	public String[] getMonsters() {
		return monsters;
	} // end method getMonsters

	public void setMonsters(String[] monsters) {
		this.monsters = monsters;
	} // end method setMonsters
} // end class Environment
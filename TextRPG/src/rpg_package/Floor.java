package rpg_package;

import java.util.ArrayList;

/**
 * Contains a list of monsters and an environment through which the player
 * character traverses during gameplay.
 * 
 * @author Trevor Nelson
 */
public class Floor {
	private int level;
	private ArrayList<Monster> monsters;
	private Environment environment;

	/**
	 * Constructs a Floor using a given level.
	 * 
	 * @param level
	 *            The desired level of the floor, which will its monsters'
	 *            power.
	 */
	public Floor(int level) {
		this.level = level;
		monsters = new ArrayList<Monster>();
		populateFloor();
	} // end constructor

	/**
	 * Populates the floor by generating a random environment and a random set
	 * of enemies on the floor.
	 */
	public void populateFloor() {
		// generate a random environment (picks a random env. from the list of
		// envs)
		environment = Environment.ENVIRONMENTS[(int) (Math.random() * Environment.ENVIRONMENTS.length)];
		// generate size of floor (random number between 5 and 10)
		int floorSize = (int) (Math.random() * 6 + 5);
		// generate monsters on floor
		for (int i = 0; i < floorSize; i++) {
			// picks a random monster name from the environment's list of
			// monster names.
			String monName = environment.getMonsters()[(int) (Math.random() * environment.getMonsters().length)];
			monsters.add(new Monster(monName, level));
		} // end for: generates an ArrayList of random monsters
	} // end method populateFloor

	public int getLevel() {
		return level;
	} // end method getLevel

	public void setLevel(int level) {
		this.level = level;
	} // end method setLevel

	public ArrayList<Monster> getMonsters() {
		return monsters;
	} // end method getMonsters

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	} // end method setMonsters

	public Environment getEnvironment() {
		return environment;
	} // end method getEnvironment

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	} // end method setEnvironment
} // end class Floor
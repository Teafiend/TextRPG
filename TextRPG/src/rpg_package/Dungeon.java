package rpg_package;

/**
 * Contains a set of floors which the player character traverses during
 * gameplay, as well as contains the floor the player is currently on.
 * 
 * @author Trevor Nelson
 */
public class Dungeon {
	private Floor[] floors;
	private int currentFloor;

	/**
	 * Constructs a Dungeon with given number of floors.
	 * 
	 * @param size
	 *            The desired number of floors for the dungeon to contain.
	 */
	public Dungeon(int size) {
		floors = new Floor[size];
		currentFloor = 0;
	} // end constructor

	public Floor[] getFloors() {
		return floors;
	} // end method getFloors

	public void setFloors(Floor[] floors) {
		this.floors = floors;
	} // end method setFloors

	public int getCurrentFloor() {
		return currentFloor;
	} // end method getCurrentFloor

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	} // end method setCurrentFloor
} // end class Dungeon
package rpg_package;

/**
 * Is extending by all classes that function as items, and has a name, price,
 * and may or may not be drinkable.
 * 
 * @author Trevor Nelson
 */
public abstract class Item {
	protected String name;
	protected int price;
	protected boolean drinkable;

	public String getName() {
		return name;
	} // end method getName

	public void setName(String name) {
		this.name = name;
	} // end method setName

	public int getPrice() {
		return price;
	} // end method getPrice

	public void setPrice(int price) {
		this.price = price;
	} // end method setPrice

	public boolean isDrinkable() {
		return drinkable;
	} // end method isDrinkable

	public void setDrinkable(boolean drinkable) {
		this.drinkable = drinkable;
	} // end method setDrinkable
} // end class Item
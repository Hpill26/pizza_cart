package application;
/**
 * Abstract parent class which holds properties of all our actual pizza classes.
 * @author Harishkarthik kumaran pillai and Brian moran
 **/
import java.util.ArrayList;;
public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;
	
	public Pizza(String newStyle, String newSize, ArrayList<String> newToppings) 
	{
		size = newSize;
		style = newStyle;
		toppings = newToppings;
	}
	public Pizza(String newStyle, String newSize) 
	{
		style = newStyle;
		size = newSize;
		
	}
	
	public abstract int pizzaPrice();
	public String toString() 
	{
		return style + " " + size;
	}
}

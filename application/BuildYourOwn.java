package application;

import java.util.*;

/**
 * Class which holds properties of our BuildYourOwn pizza class.
 * @author Harishkarthik kumaran pillai and Brian Moran
 **/
public class BuildYourOwn extends Pizza 
{
	
	//Basic Constructor
	public BuildYourOwn(String size,ArrayList<String>Toppings)
	{
		super("Build Your Own",size,Toppings);
	}
	
	//Gets price for Pizza
	public int pizzaPrice()
	{
		int pizzaPrice = 0;
		int numOfToppings = toppings.size();
		
		int priceOfToppings = numOfToppings * Price.Toppings_Price;
		
		if(size.equalsIgnoreCase("Small"))
		{
			pizzaPrice = Price.BYO_Small + priceOfToppings;
		}
		else if(size.equalsIgnoreCase("Medium"))
		{
			pizzaPrice = Price.BYO_Small + Price.Medium_Price + priceOfToppings;
		}
		else if(size.equalsIgnoreCase("Large"))
		{
			pizzaPrice = Price.BYO_Small + Price.Large_Price + priceOfToppings;
		}
		
		return pizzaPrice;
	}
	//Prints the Pizza name as well as all toppings with the price
	@Override
	public String toString()
	{
		String retVal = super.toString();
		
		 StringBuilder agg = new StringBuilder("");
		 
		 for(int i = 0; i < toppings.size(); i++)
		 {
			 agg.append(toppings.get(i));
			 agg.append(", ");
		 }
		
		return retVal + " " + agg + " $" + pizzaPrice() + "\n";
	}
	
	//Test Method for class
	public static void testBuilYourOwn()
	{
		ArrayList<String> testToppers1 = new ArrayList<String>();
		testToppers1.add("Ham");
		
		ArrayList<String> testToppers2 = new ArrayList<String>();
		testToppers2.add("Ham");
		testToppers2.add("Jalepenos");
		testToppers2.add("Extra Cheese");
		testToppers2.add("Chicken");
		testToppers2.add("Sausage");
		testToppers2.add("Spinach");
		
		ArrayList<String> testToppers3 = new ArrayList<String>();
		
		BuildYourOwn pizza1 = new BuildYourOwn("Small",testToppers1);
		BuildYourOwn pizza2 = new BuildYourOwn("Medium",testToppers2);
		BuildYourOwn pizza3 = new BuildYourOwn("Large",testToppers3);
		
		System.out.println(pizza1.toString());
		System.out.println(pizza2.toString());
		System.out.println(pizza3.toString());
	}
}



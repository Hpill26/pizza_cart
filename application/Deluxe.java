package application;
/**
 * Class which holds properties of our Deluxe pizza class.
 * @author Harishkarthik kumaran pillai and Brain Moran
 **/
public class Deluxe extends Pizza 
{
	
	//Basic Constructor
	public Deluxe(String size)
	{
		super("Deluxe",size);
	}
	
	//Gets Pizza Price
	public int pizzaPrice()
	{
		int pizzaPrice = 0;
		
		if(size.equalsIgnoreCase("Small"))
		{
			pizzaPrice = Price.Deluxe_Small;
		}
		else if(size.equalsIgnoreCase("Medium"))
		{
			pizzaPrice = Price.Deluxe_Small + Price.Medium_Price;
		}
		else if(size.equalsIgnoreCase("Large"))
		{
			pizzaPrice = Price.Deluxe_Small + Price.Large_Price;
		}
		
		return pizzaPrice;
	}
	//Returns the Pizza, along with static toppings with price
	@Override
	public String toString()
	{
		String retVal = super.toString();
		
		return retVal + " " + "Sausage, Pepperoni, Green Pepper, Onion, Mushroom" + " $" + pizzaPrice()+ "\n";
	}
	
	//Test Method for class
	public static void testDeluxe()
	{
		Deluxe pizza1 = new Deluxe("Small");
		Deluxe pizza2 = new Deluxe("Medium");
		Deluxe pizza3 = new Deluxe("Large");
		
		System.out.println(pizza1.toString());
		System.out.println(pizza2.toString());
		System.out.println(pizza3.toString());
	}
}


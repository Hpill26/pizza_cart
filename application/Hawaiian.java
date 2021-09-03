package application;
/**
 * Class which holds properties of our Hawaiian pizza class.
 * @author Harishkarthik kumaran pillai and Brain Moran
 **/
public class Hawaiian extends Pizza
{
	
	//Basic Constructor
	public Hawaiian(String size)
	{
		super("Hawaiian",size);
	}
	
	//Gets Pizza Price
	public int pizzaPrice()
	{
		int pizzaPrice = 0;
		
		if(size.compareTo("Small") == 0)
		{
			pizzaPrice = Price.Hawaiian_Small;
		}
		else if(size.compareTo("Medium") == 0)
		{
			pizzaPrice = Price.Hawaiian_Small + Price.Medium_Price;
		}
		else if(size.compareTo("Large") == 0)
		{
			pizzaPrice = Price.Hawaiian_Small + Price.Large_Price;
		}
		return pizzaPrice;
	}
	
	//Returns string of Pizza with static toppings as well as price
	@Override
	public String toString()
	{
		String retVal = super.toString();
		
		return retVal + " Ham, Pineapple" + " $" + pizzaPrice()+ "\n";
	}
	
	//Test Method for class
	public static void testHawaiin()
	{
		Hawaiian pizza1 = new Hawaiian("Small");
		Hawaiian pizza2 = new Hawaiian("Medium");
		Hawaiian pizza3 = new Hawaiian("Large");
		
		System.out.println(pizza1.toString());
		System.out.println(pizza2.toString());
		System.out.println(pizza3.toString());
	}
}

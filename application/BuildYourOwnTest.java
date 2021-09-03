/**
 * 
 */
package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Junit test class designed to test pizza price method of Build your own sub class.
 * @author Harishkarthik kumaran pillai and Brain Moran
 *
 */
public class BuildYourOwnTest {

	/**
	 * Test method for {@link application.BuildYourOwn#pizzaPrice()}.
	 */
	@Test
	public void testPizzaPrice() {
		
		/*
		 * Valid parameters: no toppings/all toppings and somwhere in between
		 * Valid parameters: size - small, medium, large
		 */
		ArrayList<String> testToppers1 = new ArrayList<String>();
		testToppers1.add("Ham");
		testToppers1.add("Jalepenos");
		testToppers1.add("Extra Cheese");
		
		BuildYourOwn pizza1 = new BuildYourOwn("Small",testToppers1);
		assertEquals(11,pizza1.pizzaPrice());
		
		//size checking
		pizza1 = new BuildYourOwn("medium", testToppers1);
		assertEquals(13,pizza1.pizzaPrice());
		
		pizza1 = new BuildYourOwn("large", testToppers1);
		assertEquals(15,pizza1.pizzaPrice());
		
		//All toppings
		ArrayList<String> testToppers2 = new ArrayList<String>();
		testToppers2.add("Ham");
		testToppers2.add("Jalepenos");
		testToppers2.add("Extra Cheese");
		testToppers2.add("Chicken");
		testToppers2.add("Sausage");
		testToppers2.add("Spinach");
		
		BuildYourOwn pizza2 = new BuildYourOwn("Medium",testToppers2);
		assertEquals(19,pizza2.pizzaPrice());
		
		//no toppings
		ArrayList<String> testToppers3 = new ArrayList<String>();
		BuildYourOwn pizza3 = new BuildYourOwn("Large",testToppers3);
		assertEquals(9,pizza3.pizzaPrice());
		
		//fail("Not yet implemented");
	}

}

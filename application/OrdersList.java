package application;

import java.util.ArrayList;
/**
	 * Growable container class. Creates a studentlist which can be used to add different types of students. Also provides functionality 
	 * to remove students from the list and print the list. 
	 * @author Harishkarthik kumaran pillai and Brian moran
	 *
	 */
public class OrdersList {
	
		   private final int SIZE = 100; 
		   private Pizza [] pizzaList;
		   public int numPizzas;
		   
		   /**
		    * Creates the Student list object which will be holding all the students the user inputs.
		    */
		   public OrdersList()
		   {
		      //this is the default constructor
			   this.pizzaList = new Pizza[SIZE];
			   this.numPizzas = 0;
		   }
		   /**
		    * Checks if the student list is empty
		    * @return true if empty, false otherwise
		    */
		   public boolean isEmpty()
		   {
		       if(numPizzas == 0) 
		       {
		    	   return true;
		       } else {
		    	   return false;
		       }
		   }

		
		   /**
		    * Increases the size of the TeamMember array, allowing the team object to be 
		    * a grow able container class. 
		    */
		   private void grow()
		   {
		       Pizza[] temp = new Pizza[pizzaList.length + SIZE];
		       for (int i = 0; i < pizzaList.length; i++)
		       {
		    	      temp[i] = this.pizzaList[i];
		       }
		       this.pizzaList = temp;
		   }
		   /**
		    * Adds a student to the list. Checks to make sure list is not full, and grows accordingly. 
		    * @param s is the student we want to add to the list; can take all types of students (InState,OutState,International)
		    */
		   public void add(Pizza p)
		   {     
			   //check if array is full
			   if(numPizzas == pizzaList.length) 
			   {
				   this.grow();
			   }
			   numPizzas++;
		   
			   int i = 0;
			   while(pizzaList[i] != null) {
				   i++;
			   }
			   
			   pizzaList[i] = p;	   
		   }
		  
		   public void clearList()
		   {
			   this.numPizzas = 0;
			   this.pizzaList = new Pizza[SIZE];
		   }
		   public String printGUI()
		   {
			   StringBuilder agg = new StringBuilder(""); 
			   for(int i = 0; i < numPizzas; i ++)
			   {
				   agg.append(pizzaList[i].toString());
				   
			   }
			   
			   agg.append("\nTotal: $");
			   agg.append(printTotal());
			   return agg.toString();
		   }
		   public String printTotal()
		   {
			   int total = 0;
			   for(int i = 0; i<numPizzas; i++)
			   {
				   total += pizzaList[i].pizzaPrice();
			   }
			   String retVal = Integer.toString(total);
			   return retVal;
		   }
			public static void testOrderList()
			{
				Deluxe pizza1 = new Deluxe("Small");
				Deluxe pizza3 = new Deluxe("Large");
				Hawaiian pizza11 = new Hawaiian("Small");
				Hawaiian pizza21 = new Hawaiian("Medium");
				ArrayList<String> testToppers1 = new ArrayList<String>();
				testToppers1.add("Ham");
				ArrayList<String> testToppers2 = new ArrayList<String>();
				testToppers2.add("Ham");
				testToppers2.add("Jalepenos");
				testToppers2.add("Extra Cheese");
				testToppers2.add("Chicken");
				testToppers2.add("Sausage");
				testToppers2.add("Spinach");				
				BuildYourOwn pizza12 = new BuildYourOwn("Small",testToppers1);
				BuildYourOwn pizza22 = new BuildYourOwn("Medium",testToppers2);
				
				OrdersList test = new OrdersList();
				test.add(pizza1);
				test.add(pizza3);
				test.add(pizza11);
				test.add(pizza21);
				test.add(pizza12);
				test.add(pizza22);
				
				String print = test.printGUI();
				System.out.println(print);
			}
	}



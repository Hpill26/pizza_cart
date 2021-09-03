package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller Class for main start Window were user picks out pizza
 * @author Harishkarthik kumaran pillai and Brian moran
 **/
public class SampleController implements Initializable{
	
	public static OrdersList root = new OrdersList();
	
	ObservableList<String> PizzaSelect = FXCollections.observableArrayList();
	ObservableList<String> SizeSelect = FXCollections.observableArrayList();
	ObservableList<String> Toppings = FXCollections.observableArrayList();
	ObservableList<String> SelectedToppings = FXCollections.observableArrayList();
	
	//ChoiceBox Controllers
	@FXML public ChoiceBox<String> PizzaDrop;
	@FXML public ChoiceBox<String> SizeDrop;
	
	@FXML public ImageView imageView;
	
	@FXML public Button AddToppings;
	@FXML public Button RemoveToppings;
	@FXML public Button ClearSelection;
	
	@FXML public Button AddOrder;
	@FXML public Button ShowOrder;
	
	@FXML public ListView<String> ToppingsList;
	@FXML public ListView<String> SelectedToppingsList;
	
	@FXML public TextArea Canvas;
	
	private Image deluxe = new Image("Deluxe.jpg");
	private Image buildYourOwn = new Image("BuildYourOwn.jpg");
	private Image hawaiian = new Image("hawaiianPizza.jpg");
	
	private String a = "Build Your Own";
	private String b = "Deluxe";
	private String c = "Hawaiian";
	
	private String d = "Small(10\")";
	private String e = "Medium(12\")";
	private String f = "Large(14\")";
	
	private String g = "Ham";
	private String h = "Jalepenos";
	private String i = "Green Pepper";
	private String j = "Chicken";
	private String k = "Sausage";
	private String l = "Spinach";
	private String m = "Mushroom";
	private String n = "Onion";
	private String o = "Pepperoni";
	private String p = "Pineappe";
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadCBox();
		//loadLists();
	}
	
	
	public void setImage()
	{
		
		
		String ComboBoxValue = PizzaDrop.getValue();
		if(ComboBoxValue.equalsIgnoreCase("Build Your Own"))
		{
			imageView.setImage(buildYourOwn);
			HClearToppings();
			HClearToppings();
			ToppingsList.setDisable(false);
			AddToppings.setDisable(false);
			RemoveToppings.setDisable(false);
		}
		else if(ComboBoxValue.equalsIgnoreCase("Hawaiian"))
		{
			
			imageView.setImage(hawaiian);
			HClearDeluxeAndHam();
			HClearDeluxeAndHam();
			//HClearToppings();
			//HClearToppings();
			loadHam();
			ToppingsList.setDisable(true);
			AddToppings.setDisable(true);
			RemoveToppings.setDisable(true);
		}
		else if(ComboBoxValue.equalsIgnoreCase("Deluxe"))
		{
			imageView.setImage(deluxe);
			HClearDeluxeAndHam();
			HClearDeluxeAndHam();
			//HClearToppings();
			loadDeluxe();
			ToppingsList.setDisable(true);
			AddToppings.setDisable(true);
			RemoveToppings.setDisable(true);
		}
		
		
	}
	
	@FXML
	public void HAddToppings()
	{
		int size = SelectedToppings.size();
		if(!(ToppingsList.getSelectionModel().getSelectedItem() == null))
		{
			if(size < 6)
			{
				SelectedToppingsList.getItems().add(ToppingsList.getSelectionModel().getSelectedItem());
				SelectedToppings.addAll(ToppingsList.getSelectionModel().getSelectedItem());
			
				int remove = ToppingsList.getSelectionModel().getSelectedIndex();
				ToppingsList.getItems().remove(remove);
				Toppings.remove(remove);
			}
			else
			{
				Canvas.setText("Can't have more than 6 toppings!!!");
			}
		}
	}
	@FXML
	public void HRemoveToppings() {
		
		if(!(SelectedToppingsList.getSelectionModel().getSelectedItem() == null))
		{
			ToppingsList.getItems().add(SelectedToppingsList.getSelectionModel().getSelectedItem());
			Toppings.addAll(ToppingsList.getSelectionModel().getSelectedItem());
		
			int remove = SelectedToppingsList.getSelectionModel().getSelectedIndex();
			SelectedToppingsList.getItems().remove(remove);
			SelectedToppings.remove(remove);
		
		}
	}
	public void HClearDeluxeAndHam()
	{
		SelectedToppingsList.getItems().removeAll(SelectedToppings);
		SelectedToppings.removeAll(SelectedToppings);
				
		ToppingsList.getItems().removeAll(Toppings);
		Toppings.removeAll(Toppings);
	}
	@FXML
	public void HClearToppings() {
		//Doesn't Work for Whatever Reason
		
		SelectedToppingsList.getItems().removeAll(SelectedToppings);
		SelectedToppings.removeAll(SelectedToppings);
				
		ToppingsList.getItems().removeAll(Toppings);
		Toppings.removeAll(Toppings);
		
		ToppingsList.setDisable(false);
		AddToppings.setDisable(false);
		RemoveToppings.setDisable(false);
		
		//PizzaDrop.setValue(a);
		//SizeDrop.setValue(e);
		//ToppingsList.getItems().removeAll(Toppings);
		loadLists();
		
		SelectedToppingsList.getItems().removeAll(SelectedToppings);
		SelectedToppings.removeAll(SelectedToppings);
				
		ToppingsList.getItems().removeAll(Toppings);
		Toppings.removeAll(Toppings);
		
		ToppingsList.setDisable(false);
		AddToppings.setDisable(false);
		RemoveToppings.setDisable(false);
		
		//PizzaDrop.setValue(a);
		//SizeDrop.setValue(e);
		//ToppingsList.getItems().removeAll(Toppings);
		loadLists();
		PizzaDrop.setValue(a);
		SizeDrop.setValue(e);
	}
	
	@FXML
	public void HAddtoOrder() {
		Pizza input1;
		String pizza = PizzaDrop.getValue();
		String size = SizeDrop.getValue();
		ArrayList<String> toppings = new ArrayList<String>();
		
		for(int i = 0; i < SelectedToppings.size(); i++) {
			toppings.add(SelectedToppings.get(i));
		}
		

		if(pizza.equals("Build Your Own")) {
			
			if(toppings.size() < 1) {
				Canvas.setText("Must choose at least 1 topping");
				return;
			} else if(toppings.size() > 6) {
				Canvas.setText("Cannot choose more than 6 toppings");
				return;
			}
						
			
			if(size.equals("Small(10\")")) {
				input1 = new BuildYourOwn("Small" , toppings);
				root.add(input1);
			}else if(size.equals("Medium(12\")")) {
				input1 = new BuildYourOwn("Medium" , toppings);
				root.add(input1);
			}else if(size.equals("Large(14\")")) {
				input1 = new BuildYourOwn("Large" , toppings);
				root.add(input1);
			}
		} else if (pizza.equals("Hawaiian")) {
			if(size.equals("Small(10\")")) {
				input1 = new Hawaiian("Small");
				root.add(input1);
			}else if(size.equals("Medium(12\")")) {
				input1 = new Hawaiian("Medium");
				root.add(input1);
			}else if(size.equals("Large(14\")")) {
				input1 = new Hawaiian("Large");
				root.add(input1);
			}
			HClearToppings();
		} else if (pizza.equals("Deluxe")) {
			if(size.equals("Small(10\")")) {
				input1 = new Deluxe("Small");
				root.add(input1);
			}else if(size.equals("Medium(12\")")) {
				input1 = new Deluxe("Medium");
				root.add(input1);
			}else if(size.equals("Large(14\")")) {
				input1 = new Deluxe("Large");
				root.add(input1);
			}
			HClearToppings();
		}
		
		Canvas.setText("Pizza Added to Order!" + "----pizzas " + root.numPizzas);
		
		HClearToppings();
		PizzaDrop.setValue(a);
		SizeDrop.setValue(e);
	}
	@FXML public void HShowOrder() {
		String output = "";
		if(root.numPizzas > 0)
		{
			 output = root.printGUI();
		}
		else if(root.numPizzas == 0)
		{
			output = "Order is empty";
		}

			try {
			
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Second.fxml"));
				Parent root = (Parent) loader.load();
			
				SecondController controller2 = (SecondController)loader.<SecondController>getController();
				controller2.setDisplay(output);
				
				Stage secondStage = new Stage();
				Scene scene = new Scene(root,520,350);
				secondStage.initModality(Modality.APPLICATION_MODAL);
				secondStage.setScene(scene);
				secondStage.showAndWait();
				} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
	}
	public static OrdersList getRoot()
	{
		return root;
	}
	public static void setRoot(OrdersList newRoot)
	{
		root = newRoot;
	}
	public void loadHam() {
		
		Toppings.removeAll(Toppings);
		String p = "Pineapple";
		String h = "Ham";
		
		SelectedToppings.addAll(h,p);
		SelectedToppingsList.getItems().addAll(SelectedToppings);
	}

	//Loads all ListViews into GUI on Initialization
	public void loadDeluxe() {
		Toppings.removeAll(Toppings);
		ToppingsList.getItems().removeAll(Toppings);
		String s = "Sausage";
		String p = "Pepperoni";
		String g = "Green Pepper";
		String o = "Onion";
		String m = "Mushroom";
		
		SelectedToppings.addAll(s,p,g,o,m);
		SelectedToppingsList.getItems().addAll(SelectedToppings);
	}
	//Loads all choiceboxes into GUI on Initialization
	public void loadCBox() {
		//Pizza Drop
		PizzaSelect.removeAll(PizzaSelect);
		
		PizzaSelect.addAll(a,b,c);
		PizzaDrop.getItems().addAll(PizzaSelect);
		PizzaDrop.setValue(a);
		
		//Size Drop
		SizeSelect.removeAll(SizeSelect);
		
		SizeSelect.addAll(d,e,f);
		SizeDrop.getItems().addAll(SizeSelect);
		SizeDrop.setValue(e);
	}
	
	public void loadLists() {
		Toppings.removeAll(Toppings);
		String g = "Ham";
		String h = "Jalepenos";
		String i = "Green Pepper";
		String j = "Chicken";
		String k = "Sausage";
		String l = "Spinach";
		String m = "Mushroom";
		String n = "Onion";
		String o = "Pepperoni";
		String p = "Pineappe";
		Toppings.addAll(g,h,i,j,k,l,m,n,o,p);
		ToppingsList.getItems().addAll(Toppings);
	}
}

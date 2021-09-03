package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller Class for main start Window were user picks out pizza
 * @author Harishkarthik kumaran pillai and Brian moran
 **/
//Controller for Second Window, 
public class SecondController implements Initializable{

	@FXML public Button clear;
	@FXML public Button back;
	
	boolean clearPressed;
	OrdersList root;
	
	String pizzaOrder;
	@FXML public TextArea OrderList;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	public void setDisplay(String pizzaOrder)
	{
		OrderList.setText(pizzaOrder);
		
		//System.out.println(pizzaOrder);
	}
	
	@FXML public void Hclear() {

		root = SampleController.getRoot();
		
		root = retClear(root);
		
		SampleController.setRoot(root);
		
		OrderList.setText("");
		}
	
	public OrdersList retClear(OrdersList newRoot)
	{
		OrdersList temp = new OrdersList();
		root = temp;	
		return root;
	}
	@FXML public void Hback() 
	{
			Stage stage = (Stage) clear.getScene().getWindow();
			
			stage.close();			
	}
}

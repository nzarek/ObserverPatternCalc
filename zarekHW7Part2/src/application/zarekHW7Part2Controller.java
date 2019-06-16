/*
Nicholas Zarek
CSCV 335
Observer Calculator Controller
*/
package application;

import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class zarekHW7Part2Controller implements Observer { 
	
	//object declaration
	private zarekHW7Part2Model model;
	
	//variable declaration
	@FXML
	private TextField tfTotal;
	
	@FXML
	private Label lblDesc;
	
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btnSubtract;
	
	@FXML
	private Button btnEquals;
	
	@FXML
	private Button btnClear;
	
	//initialize function
	@FXML
	private void initialize() {
		tfTotal.setPromptText("0");
		btnEquals.setDisable(true);
		model = new zarekHW7Part2Model();
		model.addObserver(this);
	}
	
	//addition button call
	public void addClicked() {
		model.setCurrentOperator("+");
		model.setCurrentOperand(Integer.parseInt(tfTotal.getText()));
		tfTotal.setText("");
		tfTotal.setPromptText("0");
		tfTotal.requestFocus();
		btnAdd.setDisable(true);
		btnSubtract.setDisable(true);
		btnEquals.setDisable(false);
		//lblDesc.setText(String.valueOf(model.getRunningTotal()));
	}
	
	//subtraction button call
	public void subtractClicked() {
		model.setCurrentOperator("-");
		model.setCurrentOperand(Integer.parseInt(tfTotal.getText()));
		tfTotal.setText("");
		tfTotal.setPromptText("0");
		tfTotal.requestFocus();
		btnAdd.setDisable(true);
		btnSubtract.setDisable(true);
		btnEquals.setDisable(false);
		//lblDesc.setText(String.valueOf(model.getRunningTotal()));
	}
	
	//equals button call
	public void equalsClicked() {
		if (tfTotal.getText() != null) {
			model.setCurrentOperand(Integer.parseInt(tfTotal.getText()));
			btnAdd.setDisable(false);
			btnSubtract.setDisable(false);
			model.notifyobserver();
			model.setRunningTotal(-Integer.parseInt(tfTotal.getText()));		 
		} else {tfTotal.requestFocus(); } 

	}
	
	//clear button call
	public void clearClicked() {
		btnAdd.setDisable(false);
		btnSubtract.setDisable(false);
		tfTotal.setText("");
		model.setRunningTotal(0);
		model.setCurrentOperand(0);
		model.setCurrentOperator("");
		initialize();
	}

	//observer to update running total in textfield
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.toString() != null) {
		tfTotal.setText(String.valueOf(model.getRunningTotal()));

		}
	} 
	
}

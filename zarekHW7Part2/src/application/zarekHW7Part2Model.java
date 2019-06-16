/*
Nicholas Zarek
CSCV 335
Observer Calculator Model
*/

package application;

import java.util.Observable;

public class zarekHW7Part2Model extends Observable { 

	//variable declaration
	private int runningTotal;
	private int currentOperand;
	private String currentOperator;
	
	//getters/setters with mathmatical operations where necessary
	public int getRunningTotal() {
		return runningTotal;
	}
	public void setRunningTotal(int runningTotal) {
		if (this.runningTotal == 0) {
			this.runningTotal = runningTotal;
		} else {
			if (getCurrentOperator() == "+") {
				this.runningTotal = this.runningTotal + runningTotal;
			} else {
				this.runningTotal = this.runningTotal - runningTotal;
			}
		}
	}
	public int getCurrentOperand() {
		return currentOperand;
	}
	public void setCurrentOperand(int currentOperand) {

		this.currentOperand = currentOperand;
		setRunningTotal(this.currentOperand);
		
	}
	public String getCurrentOperator() {
		return currentOperator;
	}
	public void setCurrentOperator(String currentOperator) {
		this.currentOperator = currentOperator;
	}
	
	//observers notification
	public void notifyobserver() {
		if (getRunningTotal() != 0) 
		setChanged();
		notifyObservers(getRunningTotal());
	}
}

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class InvestmentCalculator extends Application {
	//create text fields to hold investment data
	private TextField invAmount = new TextField();
	private TextField numYears = new TextField();
	private TextField annRate = new TextField();
	private TextField futValue = new TextField();
	private Button calculate = new Button("Calculate");
	
	//Create Labels
	private Label invLabel = new Label("Investment Amount:");
	private Label numYearsLabel = new Label("Number of Years:");
	private Label annRateLabel = new Label("Annual Interest Rate:");
	private Label futValueLabel = new Label("Future Value");

	@Override
	public void start(Stage secondaryStage) throws Exception {
		
		//create the layout for buttons and labels
		GridPane investPane = new GridPane();
		investPane.setHgap(7);
		investPane.setVgap(7);
		//adds the labels on the left
		investPane.setConstraints(invLabel, 0, 0);
		investPane.setConstraints(numYearsLabel, 0, 1);
		investPane.setConstraints(annRateLabel, 0, 2);
		investPane.setConstraints(futValueLabel, 0, 3);
		//adds textfields on right
		investPane.setConstraints(invAmount, 1, 0);
		investPane.setConstraints(numYears, 1, 1);
		investPane.setConstraints(annRate, 1, 2);
		investPane.setConstraints(futValue, 1, 3);
		investPane.setConstraints(calculate, 1, 4);
		
		//add children to gridpane
		investPane.getChildren().addAll(invLabel, numYearsLabel, annRateLabel, futValueLabel, invAmount, numYears
				, annRate, futValue, calculate);
		
		//sets properties for GridPane
		investPane.setAlignment(Pos.CENTER);
		invAmount.setAlignment(Pos.BOTTOM_RIGHT);
		numYears.setAlignment(Pos.BOTTOM_RIGHT);
		annRate.setAlignment(Pos.BOTTOM_RIGHT);
		futValue.setAlignment(Pos.BOTTOM_RIGHT);
		futValue.setEditable(false);
		GridPane.setHalignment(calculate, HPos.RIGHT);
		
		//make an event for the button
		calculate.setOnAction(event -> investmentCalculation());
		
		//create a scene/place in stage
		Scene newScene = new Scene(investPane, 300, 175);
		secondaryStage.setTitle("Investment Calculator");
		secondaryStage.setScene(newScene);
		secondaryStage.show();
		
		
	}
	
	private void investmentCalculation() {
		//process investment calculation given the amounts in the fields and the math from textbook
		double inputAmount = Double.parseDouble(invAmount.getText());
		int inputYears = Integer.parseInt(numYears.getText());
		double inputAnnRate = Double.parseDouble(annRate.getText());
		double getFutureValue;
		
		//do the math
		getFutureValue = inputAmount * Math.pow((1 + (inputAnnRate / 1200)), (inputYears * 12));
		
		//show getFutureValue
		futValue.setText(String.format("$%.2f", getFutureValue));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

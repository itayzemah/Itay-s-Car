import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface Command {
	public void Execute();
}

class CommandButton extends Button implements Command {
	protected Car car;;

	public CommandButton() {
		super();

	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

	}

}

class AddButton extends CommandButton {
	private Car car;
	private ObservableList<Car> carsList;

	public AddButton(ObservableList<Car> carsList) {
		this.carsList = carsList;
		this.setText("הוסף רכב");
	}

	@Override
	public void Execute() {
		try {
			CarPane2 pane = new CarPane2(carsList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}

class EnterButton extends CommandButton {
	private Car car;

	public EnterButton(Car car) {
		this.setCar(car);
		this.setText("<|	");
		this.setPrefWidth(20);
		this.setPrefHeight(30);
	}

	@Override
	public void Execute() {
	}

	public Car getCar() {
		return car;
	}

	private void setCar(Car car) {
		this.car = car;
	}

}

class SearchVia extends ChoiceBox<String> {
	public final ObservableList<String> items = FXCollections.observableArrayList("מס' רישוי", "דגם רכב", "שנה");

	public SearchVia() {
		this.getItems().addAll(items);
		this.setValue(items.get(0));
	}
	
}

class SearchCar extends TextField {
	private Car car;

	public SearchCar() {
		this.setPromptText("Search here!");
	}
}

/*
 * 
 * 
 *       textField.setOnKeyReleased(keyEvent ->
        {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "First Name":
                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Last Name":
                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Email":
                    flPerson.setPredicate(p -> p.getEmail().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
            }
        });
 */

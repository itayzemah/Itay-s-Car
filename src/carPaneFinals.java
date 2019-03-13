import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface carPaneFinals {
	Label date = new Label("תאריך");
	Label carID = new Label("מ.ר");
	Label chassis = new Label("שלדה");
	Label statusL = new Label("סטאטוס");
	/*Label name = new Label("Name");
	Label street = new Label("Street");
	Label city = new Label("City");*/
	final String[] StatusOfCarList = new String[] { "Netanya", "Herzelia", "Outlet"};
	ObservableList<String> StatusOfCarObservableList = FXCollections
			.observableArrayList(Arrays.asList(StatusOfCarList));
	ArrayList<TextField> textFields = new ArrayList<>();
}

import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface carPaneFinals {
	Label date = new Label("�����");
	Label carID = new Label("�.�");
	Label chassis = new Label("����");
	Label statusL = new Label("������");
	/*Label name = new Label("Name");
	Label street = new Label("Street");
	Label city = new Label("City");*/
	final String[] StatusOfCarList = new String[] { "Netanya", "Herzelia", "Outlet"};
	ObservableList<String> StatusOfCarObservableList = FXCollections
			.observableArrayList(Arrays.asList(StatusOfCarList));
	ArrayList<TextField> textFields = new ArrayList<>();
}

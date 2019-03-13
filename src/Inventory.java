import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class Inventory extends BorderPane {
	private BottomPanel bottom;
	private CarsTableView carsTable;
	private ObservableList<Car> carsList = FXCollections.observableArrayList();
	
	public Inventory() {
		Car c = new Car(13, "dddddd" , "07/02/19");
		carsList.add(c);
		initTable();
		initBottomPane();
	}

	private void initBottomPane() {
		bottom = new BottomPanel(this) ;
		this.setBottom(bottom);
	}

	private void initTable() {
		carsTable = new CarsTableView(this);
		this.setCenter(carsTable);
		
	}

	public ObservableList<Car> getCarsList() {
		return carsList;
	}

	public void setCarsList(ObservableList<Car> carsList) {
		this.carsList = carsList;
	}
}
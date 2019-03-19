import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CarsTableView extends TableView<Car> {
	private final static int NUM_OF_CLICKS_TO_OPEN_NEW_CLIENT_WINDOW = 2;
	private SortedList<Car> sortedClientsList;
//	private ObservableList<Car> clientsList = FXCollections.observableArrayList();
	private Inventory ui;


	public CarsTableView(Inventory ui) {
		this.setUi(ui);
		this.setItems(ui.getCarsList());
		this.setEditable(false);
		TableColumn<Car,String> carIDCol = new TableColumn<Car,String>("מספר רכב");
		carIDCol.setPrefWidth(105);
		carIDCol.setCellValueFactory(new PropertyValueFactory<Car, String>("carID"));
		TableColumn<Car,String> chassisCol = new TableColumn<Car,String>("שלדה");
		chassisCol.setCellValueFactory(new PropertyValueFactory<Car, String>("chassis"));
		TableColumn<Car,String> dateCol = new TableColumn<Car,String>("תאריך");
		dateCol.setCellValueFactory(new PropertyValueFactory<Car, String>("date"));
		this.getColumns().setAll(dateCol,carIDCol, chassisCol);
		this.setOnMouseClicked(e -> clickItem(e));
		/*----------------------------
		TableColumn<Car, String> carID = new TableColumn<Car, String>("מספר רכב");
		carID.setMinWidth(12);
		//carID.setCellValueFactory(cellData -> cellData.getValue().getCarID());
		TableColumn<Car, String> carChaissis = new TableColumn<Car, String>("מספר שלדה");
		carChaissis.setMinWidth(10);*/
	}


	public void clickItem(MouseEvent event)
	{
	    if (event.getClickCount() == 2) //Checking double click
	    {
	    	try {
				new CarPane2(this.getSelectionModel().getSelectedItem());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //CarPane.getCarPaneInstance(this.getSelectionModel().getSelectedItem(),true);
	    }
	}
	public Inventory getUi() {
		return ui;
	}


	public void setUi(Inventory ui) {
		this.ui = ui;
	}




}

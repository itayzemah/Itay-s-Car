import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CarPane extends GridPane implements carPaneFinals {
	private Car car;
	private HBox dateVBox = new HBox();
	private TextField dateTF = new TextField();
	private HBox carIDBox = new HBox();
	private TextField carIDTF = new TextField();
	private HBox statusVBox = new HBox();
	private ComboBox<String> statusComboBox = new ComboBox<String>(StatusOfCarObservableList);
	private HBox chassisIDBox = new HBox();
	private TextField chassisTF = new TextField();
	private HBox yearBox = new HBox();
	private TextField yearTF = new TextField();
	private HBox monthBox = new HBox();
	private TextField monthTF = new TextField();
	public static boolean isDone;
	public static int numOfStages = 0;
	private Scene carScene;
	private Stage carStage;

	public CarPane(ObservableList<Car> list) {
		carScene = new Scene(this, 1100, 900);
		carStage = new Stage();
		carStage.setScene(carScene);
		carStage.show();
		addAllFieldToWindow();
		dateTF.setText(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"))));
		Button done = new Button("סיים");
		done.setOnAction(e -> {
			if (allFieldFull()) {
				addCar(list, new Car(Integer.parseInt(this.getCarIDTF().getText()), this.getChassisTF().getText(),
						String.valueOf(this.dateTF.getText())));
				isDone = (true);
				carStage.close();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("שגיאה");
				alert.setHeaderText(null);
				alert.setContentText("יש למלא את כל השדות!");
				alert.showAndWait();
			}

		});

		carStage.setOnCloseRequest(e -> {
			boolean toClose;
			toClose = checkForDelete();
			if (toClose == true) {
				carStage.close();
			} else {
				e.consume();
			}
		});
		this.add(done, 10, 10);
	}

	public Scene getCarScene() {
		return carScene;
	}

	public Stage getCarStage() {
		return carStage;
	}

	private void addCar(ObservableList<Car> list, Car car) {
		list.add(car);

	}

	public Car getDetailsFromCarPane() {
		Car car = new Car(Integer.parseInt(this.getCarIDTF().getText().trim()), this.getChassisTF().getText(),
				dateTF.getText());
		return car;

	}

	private boolean allFieldFull() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean checkForDelete() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("ביטול הקמת רכב חדש");
		alert.setHeaderText("פעולת ביטול");
		alert.setContentText("האם אתה בטוח שברצונך לבטל את הקמת הרכב?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	private CarPane(Car car, boolean editable) {
		carScene = new Scene(this, 1100, 900);
		carStage = new Stage();
		carStage.setScene(carScene);
		carStage.show();
		this.setCar(car);
		dateTF.setEditable(editable);
		carIDTF.setEditable(editable);
		carIDTF.setText(String.valueOf(car.getcarID()));
		chassisTF.setText(car.getchassis());
		dateTF.setText(car.getDate());
		addAllFieldToWindow();
		this.setPadding(new Insets(10));
		carStage.setOnCloseRequest(e -> numOfStages--);
//		this.setRight(new Right());
//		this.setLeft(new Left());
	}

	protected void addAllFieldToWindow() {
		this.add(combineField(date, dateVBox, dateTF), 0, 0);
		this.add(combineField(carID, carIDBox, carIDTF), 1, 0);

		this.add(combineField(chassis, chassisIDBox, chassisTF), 2, 0);
		this.add(combineField(statusL, statusVBox, statusComboBox), 3, 0);
	}

	public static CarPane getCarPaneInstance(Car car, boolean editable) {
		if (numOfStages > 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("סגור חלון קודם!");
			alert.setContentText("לא ניתן לפתוח חלון רכב נוסף, סגור את החלון הקיים");
			alert.showAndWait();
			return null;
		}
		numOfStages++;
		return new CarPane(car, editable);
	}

	public HBox combineField(Label l, HBox hbox, Node node) {
		l.setFont(Font.font("Arial", 19));
		hbox.getChildren().addAll(node, l);
		return hbox;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public TextField getDateTF() {
		return dateTF;
	}

	public void setDateTF(TextField dateTF) {
		this.dateTF = dateTF;
	}

	public TextField getCarIDTF() {
		return carIDTF;
	}

	public void setCarIDTF(TextField carIDTF) {
		this.carIDTF = carIDTF;
	}

	public TextField getChassisTF() {
		return chassisTF;
	}

	public void setChassisTF(TextField chassisTF) {
		this.chassisTF = chassisTF;
	}

	public boolean isDone() {
		return isDone;
	}

	public TextField getYearTF() {
		return yearTF;
	}

	public void setYearTF(TextField yearTF) {
		this.yearTF = yearTF;
	}

	public TextField getMonthTF() {
		return monthTF;
	}

	public void setMonthTF(TextField monthTF) {
		this.monthTF = monthTF;
	}
}

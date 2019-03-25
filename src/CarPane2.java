import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CarPane2  implements CarPaneFinals2 {
	private Stage carStage;
	private Scene carScene;
	private Image image1;
	private ImageView imageView1;
	private Image image2;
	private ImageView imageView2;
	private Image image3;
	private ImageView imageView3;

	// --- first row nodes-------
	private TextField carIDTF = new TextField();
	private Label carIDL = new Label("מספר רישוי");

	private TextField chassisTF = new TextField();
	private Label cahssisL = new Label("שלדה");

	private ObservableList<String> status = FXCollections.observableArrayList("נתניה", "הרצליה", "outlet");
	private ComboBox<String> statusCB = new ComboBox<>(status);
	private Label statusL = new Label("סטטוס");

	private CheckBox onLine = new CheckBox("מוצג באתר");

	private Label dateModifyL = new Label("תאריך כניסה");
	private TextField dateModifyTF = new TextField();
	
	// ----- second row nodes----
	private Label listPriceL = new Label("מחירון");
	private TextField listPriceTF = new TextField();

	private ObservableList<String> colors = FXCollections.observableArrayList("שחור", "לבן", "אדום", "אפור", "ברונזה",
			"לבן פנינה");
	private ComboBox<String> colorsCB = new ComboBox<>(colors);
	private Label colorsL = new Label("צבע");

	private Button modelsList = new Button("רשימת מודלים");

	private ObservableList<String> models = FXCollections.observableArrayList();
	private ComboBox<String> modelsCB = new ComboBox<>(models);
	private Label modelsL = new Label("דגם");
	
	// ------- third row nodes---------
	private Label shopPriceL = new Label("מחיר");
	private TextField shopPriceTF = new TextField();

	private ObservableList<String> originally = FXCollections.observableArrayList("פרטי", "ליסינג מימוני", "ליסינג תפעולי",
			"השכרה", "חברה");
	private ComboBox<String> originallyCB = new ComboBox<>(originally);
	private Label originallyL = new Label("מקוריות");

	private Button ownersList = new Button("רשימת לקוחות");
	private Button ownerDetails = new Button("פרטי לקוח");

	private ObservableList<String> owners = FXCollections.observableArrayList();
	private ComboBox<String> ownersCB = new ComboBox<>(owners);
	private Label ownersL = new Label("בעלים");
	
	
	public CarPane2(Car car) throws FileNotFoundException{
		carStage = new Stage();
		BorderPane layout = new BorderPane();
		carScene = new Scene(layout);
		carStage.setTitle("רכב");
		GridPane center = new GridPane();
		enterFieldsToCenter(center);
		right(layout);
		layout.setCenter(center);
		layout.setBottom(bottom());
		insertDetailsOfCarToFiels(car);
//		layout.setStyle("style.css");
		carStage.setScene(carScene);
//		layout.getCenter().setStyle("-fx-background-image: url('file:C:\\Users\\itayz\\eclipse-workspace\\Itay'sCar\\src\\CrystalClear.jpg');"
//                + "-fx-background-size: 500, 500;"
//                + "-fx-background-repeat: no-repeat;");
		sizeOfStage();
		carStage.show();
		carStage.setOnCloseRequest( e-> {
		});
	}
	
	public CarPane2(ObservableList<Car> list) throws FileNotFoundException {
		carStage = new Stage();
		BorderPane layout = new BorderPane();
		carScene = new Scene(layout);
		carStage.setTitle("רכב חדש");
		GridPane center = new GridPane();
		enterFieldsToCenter(center);
		right(layout);
		layout.setCenter(center);
		layout.setBottom(bottom());
		carStage.setScene(carScene);
		dateModifyTF.setText(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"))));
		Button done = new Button("סיים");
		done.setOnAction(e -> {
			if (allFieldFull()) {
				addCar(list, new Car(Integer.parseInt(carIDTF.getText()), chassisTF.getText(),
						String.valueOf(dateModifyTF.getText()),checkAndReturnInt(listPriceTF.getText(),listPriceL)));
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
		center.add(done, 10, 10);
		sizeOfStage();
		clearAllTextFiels();
		carStage.show();
	}


	private void clearAllTextFiels() {
		// TODO Auto-generated method stub
		
	}

	private int checkAndReturnInt(String val, Label l) {
		int good = -100;
		while (good < 0)
		try {
		good = Integer.valueOf(val);
		}catch (NumberFormatException  e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("שגיאה");
			alert.setHeaderText(null);
			alert.setContentText("טעות בשדה" + l.getText());
			alert.showAndWait();
		}
		return good;
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
	
	private void addCar(ObservableList<Car> list, Car car) {
		list.add(car);

	}
	
	private boolean allFieldFull() {
		// TODO Auto-generated method stub
		return true;
	}

	protected void insertDetailsOfCarToFiels(Car car) {
		carIDTF.setText(car.getcarID());
		carIDTF.setEditable(false);
		dateModifyTF.setText(car.getDate());
		dateModifyTF.setEditable(false);
		chassisTF.setText(car.getchassis());
		chassisTF.setEditable(false);
	}

	private Node bottom() {
		FlowPane p = new FlowPane();
		p.getChildren().add(details);
		details.setOnAction(e -> handleFetailsBtn()); 
		p.setPadding(new Insets(_2CHARS_TF));
		return p;
	}

	private void handleFetailsBtn() {
			Stage detailsStage = new Stage();
			StackPane detailsPane = new StackPane();
//	detailsPane.getChildren().add();
			Scene scene = new Scene(detailsPane, 960, 600);
			detailsStage.setScene(scene);
			detailsStage.show();
		

	}

	private void right(BorderPane layout) throws FileNotFoundException {
		VBox pics = new VBox();
		Button button1 = new Button("בחר תמונה");
		FileChooser fileChooser1 = new FileChooser();
		Button button2 = new Button("בחר תמונה");
		FileChooser fileChooser2 = new FileChooser();
		Button button3 = new Button("בחר תמונה");
		FileChooser fileChooser3 = new FileChooser();
		setImage2(button2, fileChooser2);
		setImage1(button1, fileChooser1);
		setImage3(button3, fileChooser3);
		pics.getChildren().add(combine(button1, imageView1));
		pics.getChildren().add(combine(button2, imageView2));
		pics.getChildren().add(combine(button3, imageView3));
		layout.setRight(pics);
	}

	private void setImage3(Button button3, FileChooser fileChooser3) throws FileNotFoundException {
		image3 = new Image(new FileInputStream(_CAR_EXAMPLE_));
		imageView3 = new ImageView(image2);
		imageView3.setX(70);
		imageView3.setY(55);
		imageView3.setFitHeight(255);
		imageView3.setFitWidth(300);
		imageView3.setOnMouseClicked(e -> {
			showPic(image3);
		});

		button3.setOnAction(e -> {
			File selectedFile = fileChooser3.showOpenDialog(carStage);
			try {
				image3 = new Image(new FileInputStream(selectedFile.getPath()));
				imageView3.setImage(image3);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}

	private void setImage2(Button button2, FileChooser fileChooser2) throws FileNotFoundException {
		image2 = new Image(new FileInputStream(_CAR_EXAMPLE_));
		imageView2 = new ImageView(image2);
		imageView2.setX(70);
		imageView2.setY(55);
		imageView2.setFitHeight(255);
		imageView2.setFitWidth(300);
		imageView2.setOnMouseClicked(e -> {
			showPic(image2);
		});

		button2.setOnAction(e -> {
			File selectedFile = fileChooser2.showOpenDialog(carStage);
			try {
				image2 = new Image(new FileInputStream(selectedFile.getPath()));
				imageView2.setImage(image2);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}

	protected void setImage1(Button button1, FileChooser fileChooser1) throws FileNotFoundException {
		image1 = new Image(new FileInputStream(_CAR_EXAMPLE_));
		imageView1 = new ImageView(image1);
		imageView1.setX(70);
		imageView1.setY(55);
		imageView1.setFitHeight(255);
		imageView1.setFitWidth(300);
		imageView1.setOnMouseClicked(e -> {
			showPic(image1);
		});

		button1.setOnAction(e -> {
			File selectedFile = fileChooser1.showOpenDialog(carStage);
			try {
				image1 = new Image(new FileInputStream(selectedFile.getPath()));
				imageView1.setImage(image1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		});
	}

	protected void showPic(Image image) {
		ImageView cloned = new ImageView(image);
		cloned.setFitHeight(600);
		cloned.setFitWidth(960);
		Stage imageStage = new Stage();
		StackPane picBox = new StackPane();
		picBox.getChildren().add(cloned);
		Scene scene = new Scene(picBox, 960, 600);
		imageStage.setScene(scene);
		imageStage.show();
	}

	private void sizeOfStage() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		carStage.setX(primaryScreenBounds.getMinX());
		carStage.setY(primaryScreenBounds.getMinY());
		carStage.setWidth(primaryScreenBounds.getWidth());
		carStage.setHeight(primaryScreenBounds.getHeight());
	}

	private void enterFieldsToCenter(GridPane center) {
		control_TF_size();
		center.setAlignment(Pos.TOP_CENTER);
		center.setHgap(10);
		center.setVgap(10);
		center.setPadding(new Insets(10));

		firstRow(center);

		secondRow(center);

		thirdRow(center);

		fourthRow(center);

		fifthRow(center);

		sixthRow(center);

	}

	private void sixthRow(GridPane center) {
		center.add(combine(discriptionTF, discriptionL), 0, 5, 3, 2);
		center.add(combine(bondagesCB, bondagesL), 2, 5);
		center.add(combine(noteTF, noteL), 3, 5, 2, 2);

		suit6Row();
	}

	private void suit6Row() {
		discriptionTF.setPrefSize(400, 200);
		discriptionTF.alignmentProperty().set(Pos.TOP_RIGHT);
		noteTF.setPrefSize(400, 200);
		noteTF.alignmentProperty().set(Pos.TOP_RIGHT);
		new AutoCompleteComboBoxListener<>(bondagesCB);
	}

	private void fifthRow(GridPane center) {
		center.add(combine(KMTF, KML), 0, 4);
		center.add(combine(HPTF, HPL), 1, 4);
		center.add(combine(tireSizeTF, tireSizeL), 2, 4);
		center.add(combine(combine(airBagsTF, airBagsL), combine(pollutionTF, pollutionL)), 3, 4);
		center.add(combine(isProtection, IsSunRoof, isAutoMatic), 4, 4);

		suit5Row();
	}

	private void suit5Row() {
		KMTF.setMaxWidth(_10CHARS_TF);
		HPTF.setMaxWidth(_4_5_CHARS_TF);
		airBagsTF.setMaxWidth(_2CHARS_TF);
		pollutionTF.setMaxWidth(_2CHARS_TF);
	}

	private void fourthRow(GridPane center) {
		center.add(combine(monthlypriceTF, montlypriceL), 0, 3);
		center.add(combine(testpriceTF, testpriceL), 1, 3);
		center.add(combine(testDateTF, testpDateL), 2, 3);
		center.add(combine(combine(numOfDoorsTF, numOfDoorsL), combine(numOfOwnersTF, numOfOwnersL)), 3, 3);
		center.add(combine(combine(combine(dayTF, dayL), combine(monthTF, monthL)), combine(yearTF, yearL)), 4, 3);
	}

	private void thirdRow(GridPane center) {
		center.add(combine(shopPriceTF, shopPriceL), 0, 2);
		center.add(combine(originallyCB, originallyL), 1, 2);
		center.add(ownersList, 2, 2);
		center.add(ownerDetails, 3, 2);
		center.add(combine(ownersCB, ownersL), 4, 2, 2, 1);

	}

	private void secondRow(GridPane center) {
		center.add(combine(listPriceTF, listPriceL), 0, 1);
		center.add(combine(colorsCB, colorsL), 1, 1);
		colorsCB.setEditable(true);
		new AutoCompleteComboBoxListener<>(colorsCB);
		center.add(modelsList, 3, 1);
		center.add(combine(modelsCB, modelsL), 4, 1, 2, 1);
		modelsCB.setEditable(true);
		new AutoCompleteComboBoxListener<>(modelsCB);
	}

	private void firstRow(GridPane center) {
		center.add(combine(chassisTF, cahssisL), 0, 0);
		center.add(combine(statusCB, statusL), 1, 0);
		statusCB.setEditable(true);
		new AutoCompleteComboBoxListener<String>(statusCB);
		center.add(onLine, 2, 0);
		center.add(combine(carIDTF, carIDL), 3, 0);
		center.add(combine(dateModifyTF, dateModifyL), 4, 0, 2, 1);
	}

	private void control_TF_size() {
		yearTF.setMaxWidth(_4_5_CHARS_TF);
		monthTF.setMaxWidth(_2CHARS_TF);
		dayTF.setMaxWidth(_2CHARS_TF);
		carIDTF.setMaxWidth(_10CHARS_TF);
		modelsCB.setMinWidth(400);
		ownersCB.setMinWidth(400);
		testDateTF.setMaxWidth(_10CHARS_TF);
		testpriceTF.setMaxWidth(_4_5_CHARS_TF);
		numOfDoorsTF.setMaxWidth(_2CHARS_TF);
		numOfOwnersTF.setMaxWidth(_2CHARS_TF);
		listPriceTF.setMaxWidth(_10CHARS_TF);
		shopPriceTF.setMaxWidth(_10CHARS_TF);
		chassisTF.setMaxWidth(_10CHARS_TF);
		monthlypriceTF.setMaxWidth(_10CHARS_TF);
	}

	private HBox combine(Node node1, Node node2) {
		HBox hb = new HBox();
		// hb.alignmentProperty().set(Pos.TOP_RIGHT);
		hb.getChildren().addAll(node1, node2);
		hb.setSpacing(5);
		return hb;
	}

	private Node combine(Node node1, Node node2, Node node3) {
		HBox hb = new HBox();
		hb.getChildren().addAll(node1, node2, node3);
		hb.setSpacing(5);
		hb.alignmentProperty().set(Pos.CENTER);
		return hb;
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

}

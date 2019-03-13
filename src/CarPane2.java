import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.swing.text.html.MinimalHTMLWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CarPane2 extends Application implements CarPaneFinals2 {
	private Stage carStage;
	private Scene carScene;
	private Image image;
	private ImageView imageView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		carStage = new Stage();
		BorderPane layout = new BorderPane();
		carScene = new Scene(layout);
		carStage.setTitle("רכב");
		GridPane center = new GridPane();
		enterFieldsToCenter(center);
		right(layout);
		layout.setCenter(center);
		carStage.setScene(carScene);
		sizeOfStage();
		carStage.show();

	}

	private void right(BorderPane layout) throws FileNotFoundException {
		image = new Image(new FileInputStream("C:\\Users\\itayz\\eclipse-workspace\\Lab2\\carexample.jpg"));
		imageView = new ImageView(image);
		imageView.setX(70);
		imageView.setY(55);
		imageView.setFitHeight(355);
		imageView.setFitWidth(300);
		Stage fileStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		Button button = new Button("בחר תמונה");
		Scene scene = new Scene(button, 960, 600);
		fileStage.setScene(scene);
		layout.setRight(combine(button, imageView));
		button.setOnAction(e -> {
			File selectedFile = fileChooser.showOpenDialog(carStage);
			try {
				System.out.println(selectedFile.getPath());
				image = new Image(new FileInputStream(selectedFile.getPath()));
				System.out.println(selectedFile.toURI().toURL().toExternalForm().toString());
				imageView.setImage(image);
			} catch (FileNotFoundException | MalformedURLException e1) {
				
				
				e1.printStackTrace();
			}
	

		});
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
		

	}

	private void fifthRow(GridPane center) {
		center.add(combine(KMTF,KML),0,4);
		center.add(combine(HPTF,HPL),1,4);
		center.add(combine(tireSizeTF,tireSizeL),2,4);
		center.add(combine(combine(airBagsTF, airBagsL),combine(pollutionTF, pollutionL)),3,4);
		center.add(combine(isProtection,IsSunRoof,isAutoMatic),4,4);
		
		suit5Row();
	}

	

	private void suit5Row() {
		KMTF.setMaxWidth(_10CHARS_TF);
		HPTF.setMaxWidth(_4_5_CHARS_TF);
		airBagsTF.setMaxWidth(_2CHARS_TF);
		pollutionTF.setMaxWidth(_2CHARS_TF);
	}

	private void fourthRow(GridPane center) {
		center.add(combine(monthlypriceTF,montlypriceL),0,3);
		center.add(combine(testpriceTF,testpriceL), 1, 3);
		center.add(combine(testDateTF,testpDateL), 2, 3);
		center.add(combine(combine(numOfDoorsTF,numOfDoorsL),combine(numOfOwnersTF, numOfOwnersL)), 3, 3);
		center.add(combine(combine(combine(dayTF, dayL), combine(monthTF, monthL)), combine(yearTF, yearL)), 4, 3);
	}

	private void thirdRow(GridPane center) {
		center.add(combine(shopPriceTF,shopPriceL),0,2);
		center.add(combine(originallyCB,originallyL),1,2);
		center.add(ownersList,2,2);
		center.add(ownerDetails,3,2);
		center.add(combine(ownersCB,ownersL),4,2,2,1);
		
	}

	private void secondRow(GridPane center) {
		center.add(combine(listPriceTF,listPriceL),0,1);
		center.add(combine(colorsCB,colorsL),1,1);
		colorsCB.setEditable(true);
		new AutoCompleteComboBoxListener<>(colorsCB);
		center.add(modelsList, 3, 1);
		center.add(combine(modelsCB, modelsL), 4, 1,2,1);
		modelsCB.setEditable(true);
		new AutoCompleteComboBoxListener<>(modelsCB);
	}

	private void firstRow(GridPane center) {
		center.add(combine(chassisTF, cahssisL), 0, 0);
		center.add(combine(statusCB, statusL), 1, 0);
		statusCB.setEditable(true);
		new AutoCompleteComboBoxListener<String>(statusCB);
		center.add(onLine,2,0);
		center.add(combine(carIDTF, carIDL), 3, 0);
		center.add(combine(dateModifyTF,dateModifyL) ,4,0,2,1);
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
		hb.getChildren().addAll(node1, node2);
		hb.setSpacing(5);
		return hb;
	}

	private Node combine(CheckBox node1, CheckBox node2, CheckBox node3) {
		HBox hb = new HBox();
		hb.getChildren().addAll(node1, node2,node3);
		hb.setSpacing(5);
		return hb;
	}
//	private void createLists() {
//		textFields.addAll(Arrays.asList(tFields));
//		hboxes.addAll(Arrays.asList(boxes));
//	
//}

	public static void main(String[] args) {
		launch(args);
	}

}

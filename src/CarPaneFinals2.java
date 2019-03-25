import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public interface CarPaneFinals2 {






	// ------- fourth row nodes---------
	TextField yearTF = new TextField();
	Label yearL = new Label("עליה לכביש:  שנה");

	TextField monthTF = new TextField();
	Label monthL = new Label("חודש");

	TextField dayTF = new TextField();
	Label dayL = new Label("יום");

	final TextField monthlypriceTF = new TextField();
	final Label montlypriceL = new Label("מחיר חודשי");

	final TextField testpriceTF = new TextField();
	final Label testpriceL = new Label("סכום טסט");

	final TextField testDateTF = new TextField();
	final Label testpDateL = new Label("תאריך טסט");

	final TextField numOfDoorsTF = new TextField();
	final Label numOfDoorsL = new Label("דלתות");

	final TextField numOfOwnersTF = new TextField();
	final Label numOfOwnersL = new Label("מ.בעלים");

	// -------- fifth row nodes -----------
	final TextField KMTF = new TextField();
	final Label KML = new Label("מד אוץ");

	final TextField HPTF = new TextField();
	final Label HPL = new Label("כ\"ס");

	final TextField tireSizeTF = new TextField();
	final Label tireSizeL = new Label("צמיגים");

	final TextField airBagsTF = new TextField();
	final Label airBagsL = new Label("כריות אוויר");

	final TextField pollutionTF = new TextField();
	final Label pollutionL = new Label("זיהום אוויר");

	final CheckBox isProtection = new CheckBox("מיגון");
	final CheckBox IsSunRoof = new CheckBox("חלון בגג");
	final CheckBox isAutoMatic = new CheckBox("אוטומט");

	// ---------sixth row ------------

	final TextField discriptionTF = new TextField();
	final Label discriptionL = new Label("תיאור");

	final TextField noteTF = new TextField();
	final Label noteL = new Label("הערות");

	final ObservableList<String> bondages = FXCollections.observableArrayList("בנק לאומי","בנק מזרחי","כלמוביל","קרסו","מכוניות המזרח","בנק פועלים");
	final ComboBox<String> bondagesCB = new ComboBox<>(bondages);
	final Label bondagesL = new Label("שעבוד");
	
	//---------bottom------------
	final Button details = new Button("פרטים נוספים");
	
	// ------- Image -------
	String _CAR_EXAMPLE_ = "C:\\Users\\itayz\\eclipse-workspace\\Lab2\\carexample.jpg";

	ArrayList<TextField> textFields = new ArrayList<>();
	ArrayList<HBox> hboxes = new ArrayList<>();
	ArrayList<Label> labels = new ArrayList<>();
	final double _4_5_CHARS_TF = 50;
	final double _2CHARS_TF = 30;
	final double _10CHARS_TF = 90;
}

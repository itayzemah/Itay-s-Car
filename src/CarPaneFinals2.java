import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public interface CarPaneFinals2 {

	// --- first row nodes-------
	TextField carIDTF = new TextField();
	Label carIDL = new Label("מספר רישוי");

	TextField chassisTF = new TextField();
	Label cahssisL = new Label("שלדה");

	ObservableList<String> status = FXCollections.observableArrayList("נתניה", "הרצליה", "outlet");
	ComboBox<String> statusCB = new ComboBox<>(status);
	Label statusL = new Label("סטטוס");

	CheckBox onLine = new CheckBox("מוצג באתר");

	Label dateModifyL = new Label("תאריך כניסה");
	TextField dateModifyTF = new TextField();

	// ----- second row nodes----
	Label listPriceL = new Label("מחירון");
	TextField listPriceTF = new TextField();

	ObservableList<String> colors = FXCollections.observableArrayList("שחור", "לבן", "אדום", "אפור", "ברונזה",
			"לבן פנינה");
	ComboBox<String> colorsCB = new ComboBox<>(colors);
	Label colorsL = new Label("צבע");

	Button modelsList = new Button("רשימת מודלים");

	ObservableList<String> models = FXCollections.observableArrayList();
	ComboBox<String> modelsCB = new ComboBox<>(models);
	Label modelsL = new Label("דגם");

	// ------- third row nodes---------
	Label shopPriceL = new Label("מחיר");
	TextField shopPriceTF = new TextField();

	ObservableList<String> originally = FXCollections.observableArrayList("פרטי", "ליסינג מימוני", "ליסינג תפעולי",
			"השכרה", "חברה");
	ComboBox<String> originallyCB = new ComboBox<>(originally);
	Label originallyL = new Label("מקוריות");

	Button ownersList = new Button("רשימת לקוחות");
	Button ownerDetails = new Button("פרטי לקוח");

	ObservableList<String> owners = FXCollections.observableArrayList();
	ComboBox<String> ownersCB = new ComboBox<>(owners);
	Label ownersL = new Label("בעלים");

	// ------- fourth row nodes---------
	TextField yearTF = new TextField();
	Label yearL = new Label("עליה לכביש:  שנה");

	TextField monthTF = new TextField();
	Label monthL = new Label("חודש");

	TextField dayTF = new TextField();
	Label dayL = new Label("יום");

	TextField monthlypriceTF = new TextField();
	Label montlypriceL = new Label("מחיר חודשי");

	TextField testpriceTF = new TextField();
	Label testpriceL = new Label("סכום טסט");

	TextField testDateTF = new TextField();
	Label testpDateL = new Label("תאריך טסט");

	TextField numOfDoorsTF = new TextField();
	Label numOfDoorsL = new Label("דלתות");

	TextField numOfOwnersTF = new TextField();
	Label numOfOwnersL = new Label("מ.בעלים");

	// -------- fifth row nodes -----------
	TextField KMTF = new TextField();
	Label KML = new Label("מד אוץ");

	TextField HPTF = new TextField();
	Label HPL = new Label("כ\"ס");

	TextField tireSizeTF = new TextField();
	Label tireSizeL = new Label("צמיגים");

	TextField airBagsTF = new TextField();
	Label airBagsL = new Label("כריות אוויר");

	TextField pollutionTF = new TextField();
	Label pollutionL = new Label("זיהום אוויר");

	CheckBox isProtection = new CheckBox("מיגון");
	CheckBox IsSunRoof = new CheckBox("חלון בגג");
	CheckBox isAutoMatic = new CheckBox("אוטומט");

	
	
	//------- Image -------
	String _CAR_EXAMPLE_ ="C:\\Users\\itayz\\eclipse-workspace\\Lab2\\carexample.jpg";
    final int NUMBER_OF_PICTURS = 4;

	ArrayList<TextField> textFields = new ArrayList<>();
	ArrayList<HBox> hboxes = new ArrayList<>();
	ArrayList<Label> labels = new ArrayList<>();
//	TextField[] tFields = new TextField[] {carIDTF,dateTF, chassisTF,yearTF,monthTF,dayTF};
//	HBox[] boxes = new HBox[] {carIDBox,dateBox,chassisbox,yearBox,monthBox,dayBox};
	final double _4_5_CHARS_TF = 50;
	final double _2CHARS_TF = 30;
	final double _10CHARS_TF = 90;
}

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
	Label carIDL = new Label("���� �����");

	TextField chassisTF = new TextField();
	Label cahssisL = new Label("����");

	ObservableList<String> status = FXCollections.observableArrayList("�����", "������", "outlet");
	ComboBox<String> statusCB = new ComboBox<>(status);
	Label statusL = new Label("�����");

	CheckBox onLine = new CheckBox("���� ����");

	Label dateModifyL = new Label("����� �����");
	TextField dateModifyTF = new TextField();

	// ----- second row nodes----
	Label listPriceL = new Label("������");
	TextField listPriceTF = new TextField();

	ObservableList<String> colors = FXCollections.observableArrayList("����", "���", "����", "����", "������",
			"��� �����");
	ComboBox<String> colorsCB = new ComboBox<>(colors);
	Label colorsL = new Label("���");

	Button modelsList = new Button("����� ������");

	ObservableList<String> models = FXCollections.observableArrayList();
	ComboBox<String> modelsCB = new ComboBox<>(models);
	Label modelsL = new Label("���");

	// ------- third row nodes---------
	Label shopPriceL = new Label("����");
	TextField shopPriceTF = new TextField();

	ObservableList<String> originally = FXCollections.observableArrayList("����", "������ ������", "������ ������",
			"�����", "����");
	ComboBox<String> originallyCB = new ComboBox<>(originally);
	Label originallyL = new Label("�������");

	Button ownersList = new Button("����� ������");
	Button ownerDetails = new Button("���� ����");

	ObservableList<String> owners = FXCollections.observableArrayList();
	ComboBox<String> ownersCB = new ComboBox<>(owners);
	Label ownersL = new Label("�����");

	// ------- fourth row nodes---------
	TextField yearTF = new TextField();
	Label yearL = new Label("���� �����:  ���");

	TextField monthTF = new TextField();
	Label monthL = new Label("����");

	TextField dayTF = new TextField();
	Label dayL = new Label("���");

	TextField monthlypriceTF = new TextField();
	Label montlypriceL = new Label("���� �����");

	TextField testpriceTF = new TextField();
	Label testpriceL = new Label("���� ���");

	TextField testDateTF = new TextField();
	Label testpDateL = new Label("����� ���");

	TextField numOfDoorsTF = new TextField();
	Label numOfDoorsL = new Label("�����");

	TextField numOfOwnersTF = new TextField();
	Label numOfOwnersL = new Label("�.�����");

	// -------- fifth row nodes -----------
	TextField KMTF = new TextField();
	Label KML = new Label("�� ���");

	TextField HPTF = new TextField();
	Label HPL = new Label("�\"�");

	TextField tireSizeTF = new TextField();
	Label tireSizeL = new Label("������");

	TextField airBagsTF = new TextField();
	Label airBagsL = new Label("����� �����");

	TextField pollutionTF = new TextField();
	Label pollutionL = new Label("����� �����");

	CheckBox isProtection = new CheckBox("�����");
	CheckBox IsSunRoof = new CheckBox("���� ���");
	CheckBox isAutoMatic = new CheckBox("������");

	
	
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

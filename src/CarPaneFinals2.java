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
	Label yearL = new Label("���� �����:  ���");

	TextField monthTF = new TextField();
	Label monthL = new Label("����");

	TextField dayTF = new TextField();
	Label dayL = new Label("���");

	final TextField monthlypriceTF = new TextField();
	final Label montlypriceL = new Label("���� �����");

	final TextField testpriceTF = new TextField();
	final Label testpriceL = new Label("���� ���");

	final TextField testDateTF = new TextField();
	final Label testpDateL = new Label("����� ���");

	final TextField numOfDoorsTF = new TextField();
	final Label numOfDoorsL = new Label("�����");

	final TextField numOfOwnersTF = new TextField();
	final Label numOfOwnersL = new Label("�.�����");

	// -------- fifth row nodes -----------
	final TextField KMTF = new TextField();
	final Label KML = new Label("�� ���");

	final TextField HPTF = new TextField();
	final Label HPL = new Label("�\"�");

	final TextField tireSizeTF = new TextField();
	final Label tireSizeL = new Label("������");

	final TextField airBagsTF = new TextField();
	final Label airBagsL = new Label("����� �����");

	final TextField pollutionTF = new TextField();
	final Label pollutionL = new Label("����� �����");

	final CheckBox isProtection = new CheckBox("�����");
	final CheckBox IsSunRoof = new CheckBox("���� ���");
	final CheckBox isAutoMatic = new CheckBox("������");

	// ---------sixth row ------------

	final TextField discriptionTF = new TextField();
	final Label discriptionL = new Label("�����");

	final TextField noteTF = new TextField();
	final Label noteL = new Label("�����");

	final ObservableList<String> bondages = FXCollections.observableArrayList("��� �����","��� �����","�������","����","������� �����","��� ������");
	final ComboBox<String> bondagesCB = new ComboBox<>(bondages);
	final Label bondagesL = new Label("�����");
	
	//---------bottom------------
	final Button details = new Button("����� ������");
	
	// ------- Image -------
	String _CAR_EXAMPLE_ = "C:\\Users\\itayz\\eclipse-workspace\\Lab2\\carexample.jpg";

	ArrayList<TextField> textFields = new ArrayList<>();
	ArrayList<HBox> hboxes = new ArrayList<>();
	ArrayList<Label> labels = new ArrayList<>();
	final double _4_5_CHARS_TF = 50;
	final double _2CHARS_TF = 30;
	final double _10CHARS_TF = 90;
}

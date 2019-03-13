import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class BottomPanel extends FlowPane {
	private AddButton addBtn;
	private SearchVia searchVia;
	private SearchCar searchCar;
	public BottomPanel(Inventory inventory) {
		searchVia = new SearchVia();
		searchCar = new SearchCar();
		addBtn = new AddButton(inventory.getCarsList());
		
		
		this.alignmentProperty().set(Pos.TOP_RIGHT);
		this.setPadding(new Insets(10));
		this.setHgap(7);
		this.getChildren().add(addBtn);
		this.getChildren().add(searchVia);
		this.getChildren().add(searchCar);
		addBtn.setOnAction(e -> addBtn.Execute());
		
		
	}

	public AddButton getAddBtn() {
		return addBtn;
	}
	
	
}

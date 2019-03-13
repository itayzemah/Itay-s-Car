import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private final static int MIN_PRIMARY_STAGE_HEIGTH = 700;
	private final static int MIN_PRIMARY_STAGE_WIDTH = 1000;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Inventory incentory = new Inventory();
		incentory.prefHeightProperty().bind(primaryStage.heightProperty());
		incentory.prefWidthProperty().bind(primaryStage.widthProperty());
		Scene mainScene = new Scene(incentory);
		primaryStage.setTitle("רכב איתי");
		primaryStage.setScene(mainScene);
		primaryStage.setMinHeight(MIN_PRIMARY_STAGE_HEIGTH);
		primaryStage.setMinWidth(MIN_PRIMARY_STAGE_WIDTH);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}

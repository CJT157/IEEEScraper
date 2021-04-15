
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/* 	To run:
*		cd into applications (type 'cd application' into terminal)
*		paste 'javac --module-path ../javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml GUI.java' and press enter
*		paste 'java --module-path ../javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml GUI.java' and press enter
*		there ya go
*/

public class GUI extends Application{

	public static Stage primaryStage;
	public static Scene titleScene;
	public static Scene mainScene;

	public static void main(String[] args) throws InterruptedException {
		GUI gui = new GUI();
		gui.newGUI(args);
	}

	public void newGUI(String[] args) throws InterruptedException {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		GUI.primaryStage = arg0;
		
		titleScene = new Scene(titleScene());
		
		GUI.primaryStage.setScene(titleScene);
		GUI.primaryStage.show();
	}
	
	public GridPane titleScene() {
		GridPane grid = new GridPane();
		grid.setPrefSize(800, 600);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Label title = new Label("Test GUI");
		grid.add(title, 0, 0);
		
		return grid;
	}

}
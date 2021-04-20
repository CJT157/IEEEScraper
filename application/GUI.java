import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	public static Scene loadingScene;
	public static Scene mainScene;
	public static MovieSuggestion movieSuggestion = MovieSuggestion.getMovieSuggestion();

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
		
		loadingScene = loadingScene();
		mainScene = mainScene();
		titleScene = titleScene();
		
		GUI.primaryStage.setScene(titleScene);
		GUI.primaryStage.show();
	}
	
	public Scene titleScene() {
		GridPane grid = new GridPane();
		grid.setPrefSize(1280, 720);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Label loadingLabel = new Label("IEEE IMDB Scraper");
		grid.add(loadingLabel, 0, 0);

		Button openButton = new Button("Enter");
		openButton.setOnAction(e -> {
			GUI.primaryStage.setScene(loadingScene);
			movieSuggestion.loadMovieInfo();
			GUI.primaryStage.setScene(mainScene);
			});
		grid.add(openButton, 0, 1);
		
		return new Scene(grid);
	}

	public Scene mainScene() {
		GridPane grid = new GridPane();
		grid.setPrefSize(1280, 720);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);

		Label loadingLabel = new Label("IEEE IMDB Scraper");
		grid.add(loadingLabel, 0, 0);

		return new Scene(grid);
	}

	public Scene loadingScene() {
		GridPane grid = new GridPane();
		grid.setPrefSize(1280, 720);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);

		Label loadingLabel = new Label("Loading...");
		grid.add(loadingLabel, 0, 0);

		return new Scene(grid);
	}

}
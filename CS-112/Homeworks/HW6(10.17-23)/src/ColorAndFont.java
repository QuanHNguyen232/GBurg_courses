import java.util.Random;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorAndFont extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		int gap=10;
		Group group = new Group();
		GridPane gridPane = new GridPane();
		gridPane.setHgap(gap);	// gap b/w columns
		gridPane.setVgap(gap);	// gap b/w rows
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setRotate(90);
		gridPane.setStyle("-fx-background-color: linear-gradient(to top, gray, white, gray)");
		
		// make a scene object
		Scene scene = new Scene(borderPane, 200, 200);
		
		Random rand = new Random();
	
	
		for (int i=1; i <= 5; i++) {
			Text text = new Text("java");
			double red = rand.nextDouble();
			double green = rand.nextDouble();
			double blue = rand.nextDouble();
			double opacity = rand.nextDouble();
			Color color = new Color(red, green, blue, opacity);
			text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
			text.setFill(color);
			gridPane.add(text, 0, i);
		}
		group.getChildren().add(gridPane);
		borderPane.setCenter(group);
		
		// add the scene to the stage
		primaryStage.setTitle("Color & Font");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	
	public static void main(String[] args) {
		launch(args);
		
	}


}

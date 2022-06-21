import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapeGUI extends Application{
	
	public static final int WIDTH=400, HEIGHT=600;
	
	@Override
	public void start(Stage primaryStage) {// throws Exception {
		// parent: top level of user interface
		BorderPane parent = new BorderPane();
		
		// make a scene object
		Scene scene = new Scene(parent, WIDTH, HEIGHT);
		
		// create a group of shapes
		Group shapes = new Group();
		
		// create a line out of two x, y coordinates
		Line line1 = new Line(0, 0, WIDTH, HEIGHT);
		Line line2 = new Line(0, HEIGHT/4.0, WIDTH, HEIGHT/4);
		Rectangle rec1 = new Rectangle(10, 15, 50, 75);
		
		// add the line to the group
		shapes.getChildren().add(line1);
		shapes.getChildren().add(line2);
		shapes.getChildren().add(rec1);
		
		shapes.setRotate(45);	// rotate group and all of its children
		
		// add the group to the parent
		parent.setCenter(shapes);
		
		// add the scene to the stage
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	// hierarchy:
	// BorderPane
	//	-Group
	//		-Line
	//		-Rectangle

	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}


}

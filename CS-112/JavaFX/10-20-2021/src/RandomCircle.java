import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RandomCircle extends Application{
	
	public static final int WIDTH=400, HEIGHT=600;
	public static final int NUM_CIRCLES = 20;
	public static final int MAX_RADIUS = 50;
	
	@Override
	public void start(Stage primaryStage) {// throws Exception {
		// parent: top level of user interface
		BorderPane parent = new BorderPane();
		
//		parent.setStyle("-fx-background-color: lightgray");
		parent.setStyle("-fx-background-color: linear-gradient(to right, red, black, aqua)");	// to right, left, bottom, top
		
		// make a scene object
		Scene scene = new Scene(parent, WIDTH, HEIGHT);
		
		// create a group of shapes
		Group shapes = new Group();
		
		Random rand = new Random();	// rand.setSeed(int);
		
		// create circles
		for (int i=0; i < NUM_CIRCLES; i++) {
			int x = rand.nextInt(WIDTH);
			int y = rand.nextInt(HEIGHT);
			int r = rand.nextInt(MAX_RADIUS);
			
			// create object
			Circle c = new Circle(x, y, r);
//			Circle c2 = new Circle(x, y, 20, Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), .3));
			double red = rand.nextDouble();
			double green = rand.nextDouble();
			double blue = rand.nextDouble();
			double opacity = rand.nextDouble();
			Color color = new Color(red, green, blue, opacity);

			c.setFill(color);
			c.setStroke(Color.BLACK);
//			c.setFill(Color.web("#FFAACC", 1.0));
//			c.setFill(Color.rgb(164, 200, 100, .5));
			
			// add it to shapes
			shapes.getChildren().add(c);
//			shapes.getChildren().add(c2);
		}
		Circle c2 = new Circle(WIDTH/2.0, HEIGHT/2.0 , 20, Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 1));
		c2.setStroke(Color.RED);
		shapes.getChildren().add(c2);
		TranslateTransition translate = new TranslateTransition();
		translate.setByX(WIDTH/2.0-10);
		translate.setByY(HEIGHT/2.0+10);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(500);
		translate.setAutoReverse(true);  
		translate.setNode(c2);
		translate.play();
		// rotate group and all of its children
//		shapes.setRotate(45);
		
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

	public static void main(String[] args) {	// main only need for the first time run
		launch(args);
		System.out.println(new Random().nextDouble());
		
		
		
	}


}

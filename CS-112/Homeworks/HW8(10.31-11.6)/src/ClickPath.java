import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class ClickPath extends Application {
	public static BorderPane pane;
	public static Circle circle;
	public static double sceneSize = 500; 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pane = new BorderPane();
		
		circle = new Circle(sceneSize/2, sceneSize/2, 20);
		pane.getChildren().add(circle);
		
		pane.setOnMouseClicked(e -> event(e.getX(), e.getY()));
		
		Scene scene = new Scene(pane, sceneSize, sceneSize);
		
		
		primaryStage.setTitle("Mouse and Key events");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void event(double centerX, double centerY) {
		PathTransition pathTrans = new PathTransition();
		pathTrans.setNode(circle);
		FadeTransition fade = new FadeTransition(); 
		fade.setFromValue(0);
		fade.setToValue(1);
		
		Random rand = new Random();

		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		
		// Create trails
		Line line = new Line(circle.getCenterX(), circle.getCenterY(), centerX, centerY);
		line.setStrokeLineCap(StrokeLineCap.ROUND);
		line.setStrokeWidth(20);
		line.setStroke(Color.rgb(red, green, blue, .5));
		
		// Set animation
		pathTrans.setPath(line);
		pathTrans.play();
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);
		circle.setFill(Color.rgb(red, green, blue, 1));
		pane.getChildren().add(line);
		fade.setNode(line);
		fade.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

	

}

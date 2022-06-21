import java.util.Random;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;


public class TransformTests extends Application {
	public static final double SIZE = 100, PANE_SIZE = 500;
	public static GridPane controlPane;
	public static Group shapes;
	public static Rectangle rec;
	public static Circle cir;
	public static Text text;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		Pane playPane = new Pane();
		mainPane.setCenter(playPane);
		shapes = new Group();
		playPane.getChildren().add(shapes);
		controlPane = new GridPane();
		mainPane.setTop(controlPane);
		
		// reset btn
		Button resetBtn = new Button("reset");
		playPane.getChildren().add(resetBtn);
		resetBtn.setOnMouseEntered(e -> {
			Random rand = new Random();
			resetBtn.setTranslateX(rand.nextInt((int)PANE_SIZE-100)+50);
			resetBtn.setTranslateY(rand.nextInt((int)PANE_SIZE-100)+50);
		});
		
		createShape();
		
		createBtns();
		
		
		//
		playPane.setOnMousePressed(e -> {
			shapes.setTranslateX(e.getX());
			shapes.setTranslateY(e.getY());
		});
		
		
		Scene scene = new Scene(mainPane, PANE_SIZE, PANE_SIZE);
		
		primaryStage.setTitle("TransformTests");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void createShape() {
		rec = new Rectangle(-SIZE, 0, SIZE*2, SIZE*2);
		rec.setRotate(0);
		rec.setFill(Color.GREENYELLOW);
		cir = new Circle(0, 0, SIZE);
		cir.setFill(Color.DARKGREEN);
		text = new Text(0, SIZE, "hello");
		text.setScaleX(3);
		text.setScaleY(3);
		shapes.getChildren().addAll(cir, rec, text);
		

	}
	
	public void createBtns() {
		Button scaleUpX = new Button("scale(x) +");
		controlPane.add(scaleUpX, 0, 0);
		scaleUpX.setOnMouseClicked(e -> {
			shapes.setScaleX(shapes.getScaleX()*1.1);
		});
		
		Button scaleUpY = new Button("scale(y) +");
		controlPane.add(scaleUpY, 1, 0);
		scaleUpY.setOnMouseClicked(e -> {
			shapes.setScaleY(shapes.getScaleY()*1.1);
		});
		
		Button scaleDownX = new Button("scale(x) -");
		controlPane.add(scaleDownX, 0, 1);
		scaleDownX.setOnMouseClicked(e -> {
			shapes.setScaleX(shapes.getScaleX()*0.9);
		});
		
		Button scaleDownY = new Button("scale(y) -");
		controlPane.add(scaleDownY, 1, 1);
		scaleDownY.setOnMouseClicked(e -> {
			shapes.setScaleY(shapes.getScaleY()*0.9);
		});
		
		Button rotateLeft = new Button("rotate left");
		controlPane.add(rotateLeft, 2, 0);
		rotateLeft.setOnMouseClicked(e -> {
			shapes.setRotate(shapes.getRotate()-10);
		});
		
		Button rotateRigt = new Button("rotate right");
		controlPane.add(rotateRigt, 2, 1);
		rotateRigt.setOnMouseClicked(e -> {
			shapes.setRotate(shapes.getRotate()+10);
		});
		
	}
	
}


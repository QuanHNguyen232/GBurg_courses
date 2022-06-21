

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineTest extends Application {

	public static final double SIZE = 400;
	public static final double TIME_MILLIS = 20;
	
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		pane.setOnMouseClicked(e -> {
			Mover m = new Mover(e.getX(), e.getY());
			pane.getChildren().add(m);
		});
		
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(TIME_MILLIS), e -> {
			for(Node n: pane.getChildren()) {
				if(n instanceof Mover) {
					Mover m = (Mover)n;
					m.moveIt();
				}
			}
		}));
		
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		Scene scene = new Scene(pane, SIZE, SIZE);
		
		primaryStage.setTitle("Path Animation Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


class Mover extends Group{

	public static final double SIZE = 20;
	public static final double SPEED = 2;
	
	private int dx = 1;
	private int dy = 1;
	
	double dx1, dy1;
	
	public Mover(double x, double y) {
		Rectangle bg = new Rectangle(-SIZE, -SIZE, 2*SIZE, 2*SIZE);
		Circle fg = new Circle(0, 0, SIZE);
		fg.setFill(Color.YELLOW);
		
		Random rand = new Random(1);
		dx1 = rand.nextDouble();
		dy1 = rand.nextDouble();
		
		//move the group to (x, y)
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.getChildren().addAll(bg, fg);
	}
	
	public void moveIt() {
		//make sure this group appears in a pane
		Parent parent = this.getParent();
		if(parent == null || !(parent instanceof Pane))
			return;
		
		Pane pane = (Pane)parent;

		double currX = this.getTranslateX();
		double currY = this.getTranslateY();
		
		
		//change direction
		if(currX < SIZE || currX > pane.getWidth() - SIZE) {
//			dx *= -1;
			dx1 *= -1;
		}
		
		if(currY < SIZE || currY > pane.getHeight() - SIZE) {
//			dy *= -1;
			dy1 *= -1;
		}
		
		//update the group's location
//		this.setTranslateX(currX + dx*SPEED);
//		this.setTranslateY(currY + dy*SPEED);
		this.setTranslateX(currX + dx1*SPEED);
		this.setTranslateY(currY + dy1*SPEED);
	}
	
}
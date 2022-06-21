import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathAnimTest extends Application{

	public static final int SIZE = 400;
//	boolean isRun = true;
	
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		//set up a shapes 
		Circle  circle = new Circle(SIZE/2, SIZE/2, 50);
		Line line = new Line(0, SIZE/2, SIZE, SIZE/2);
		Button b = new Button("Click");
		pane.getChildren().addAll(circle, line, b);
		
//		Button stop = new Button("stop");	// it does not work
//		pane.getChildren().add(stop);
		
		//transition is a type of animation
		PathTransition pathAnim = new PathTransition();
//		pathAnim.setNode(line);
		pathAnim.setNode(circle);
//		pathAnim.setNode(b);
		pathAnim.setPath(line);
//		pathAnim.setPath(circle);
		pathAnim.setCycleCount(Timeline.INDEFINITE);
		pathAnim.setAutoReverse(false);
		pathAnim.setDuration(Duration.seconds(1));
		
//		pathAnim.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		
//		stop.setOnAction(e -> isRun=false);
		
		//control the animation
		b.setOnMouseEntered(e -> pathAnim.play());
		b.setOnMouseExited(e -> pathAnim.pause());
		pane.setOnMousePressed(e -> pathAnim.play());
		pane.setOnMouseReleased(e -> pathAnim.pause());
//		pane.setOnMouseClicked(e -> {
//			pathAnim.
//		});
		
		Scene scene = new Scene(pane, SIZE, SIZE);
		
		primaryStage.setTitle("Path Animation Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
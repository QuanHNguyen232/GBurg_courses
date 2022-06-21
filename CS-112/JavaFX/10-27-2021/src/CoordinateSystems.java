import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CoordinateSystems extends Application {
	// NEED MORE EXPLANATION: HOW SET WIDTH/HEIGHT automatically change while there's no binding/call method
	
	// primaryStage resize -> scene resize -> pane resize
	@Override
	public void start(Stage primaryStage) {
		
		Pane pane = new CoordPane();
		
		Scene scene = new Scene(pane, 400, 400);
		
		primaryStage.setTitle("Coordinate Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

class CoordPane extends Pane {
	
	public static final double MAX_X = 10;
	public static final double MIN_X = -10;
	public static final double MAX_Y= 18;
	public static final double MIN_Y = -2;
	
	private void paint() {	// prof Presser said this is constructor ?????
		//erase the old stuff
		this.getChildren().clear();
		
		Line xAxis = new Line(g2wX(MIN_X), g2wY(0), g2wX(MAX_X), g2wY(0));
		Line yAxis = new Line(g2wX(0), g2wY(MIN_Y), g2wX(0), g2wY(MAX_Y));

		Circle dot = new Circle(g2wX(3), g2wY(12), 10);
		
		//System.out.printf("%s\n", xAxis);
		
		this.getChildren().addAll(xAxis, yAxis, dot);
		
	}
	
	// Formula: http://cs.gettysburg.edu/~cpresser/cs112/examples/javaFX/CoordTransform.pdf
	
	//transform a graph x coordinate into a window x coordinate
	private double g2wX(double x) {
		return getWidth() * (((x - MIN_X)/(MAX_X - MIN_X)));
	}

	//transform a graph y coordinate into a window y coordinate
	private double g2wY(double y) {
		return getHeight() * (1.0 - ((y - MIN_Y)/(MAX_Y - MIN_Y)));
	}
	
	@Override
	public void setWidth(double newWidth) {
		super.setWidth(newWidth);
		System.out.printf("%f\n", newWidth);
		paint();
	}
	
	@Override
	public void setHeight(double newHeight) {
		super.setHeight(newHeight);
		System.out.printf("%f\n", newHeight);
		paint();
	}
}
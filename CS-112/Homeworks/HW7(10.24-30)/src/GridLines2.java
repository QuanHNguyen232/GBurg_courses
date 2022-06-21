import java.util.Random;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GridLines2 extends Application {
	private static final int NUM_LINES = 50;
	private static final double WIDTH = 500.0;
	double a;
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 1000, 1000);
		Random rand = new Random();
		// Border lines
//		Line l = new Line(startX, startY, endX, endY)
		Line borderLine1 = new Line(0, 0, 0, WIDTH);
		Line borderLine2 = new Line(0, 0, WIDTH, 0);
		Line borderLine3 = new Line(0, WIDTH, WIDTH, WIDTH);
		Line borderLine4 = new Line(WIDTH, 0, WIDTH, WIDTH);
		// border 1
		borderLine1.setStrokeWidth(3);
		borderLine1.getStrokeDashArray().addAll(10d, 10d);
		borderLine1.endYProperty().bind(borderPane.heightProperty().divide(2));
		// border 2
		borderLine2.setStrokeWidth(3);
		borderLine2.getStrokeDashArray().addAll(10d, 10d);
		borderLine2.endXProperty().bind(borderPane.widthProperty().divide(2));
		// border 3
		borderLine3.setStrokeWidth(3);
		borderLine3.getStrokeDashArray().addAll(10d, 10d);
		borderLine3.startYProperty().bind(borderPane.heightProperty().divide(2));
		borderLine3.endYProperty().bind(borderPane.heightProperty().divide(2));
		borderLine3.endXProperty().bind(borderPane.widthProperty().divide(2));
		// border 4
		borderLine4.setStrokeWidth(3);
		borderLine4.getStrokeDashArray().addAll(10d, 10d);
		borderLine4.startXProperty().bind(borderPane.widthProperty().divide(2));
		borderLine4.endXProperty().bind(borderPane.widthProperty().divide(2));
		borderLine4.endYProperty().bind(borderPane.heightProperty().divide(2));
		// add borders
		borderPane.getChildren().add(borderLine1);
		borderPane.getChildren().add(borderLine2);
		borderPane.getChildren().add(borderLine3);
		borderPane.getChildren().add(borderLine4);
		
		// rows
		double y = 0;
		for (int i = 1; i <= NUM_LINES; i++) {
			y += WIDTH/(NUM_LINES+1.0);
			DoubleBinding gap = (borderPane.heightProperty().divide(2)).divide(NUM_LINES+1).multiply(i);
			Line line = new Line(0, y, WIDTH, y);
			line.endXProperty().bind(borderPane.widthProperty().divide(2));
			line.startYProperty().bind(gap);
			line.endYProperty().bind(gap);
			Color color = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1);
			line.setStroke(color);
			borderPane.getChildren().add(line);
		}
		
		
		// cols
		double x = 0;
		for (int i = 1; i <= NUM_LINES; i++) {
			x += WIDTH/(NUM_LINES+1.0);
			DoubleBinding gap = (borderPane.widthProperty().divide(2)).divide(NUM_LINES+1).multiply(i);
			Line line = new Line(x, 0, x, WIDTH);
			line.endYProperty().bind(borderPane.heightProperty().divide(2));
			line.startXProperty().bind(gap);
			line.endXProperty().bind(gap);
			Color color = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1);
			line.setStroke(color);
			borderPane.getChildren().add(line);
		}
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

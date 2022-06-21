import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlotSquare extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 700, 700);
		
		Group gr = new Group();
		// code from book
		Polyline polyline = new Polyline();
		polyline.setStrokeWidth(3);
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for (int x = -170; x <= 170; x++) {
			list.add(x + 200.0);
			list.add(scaleFactor * x * x);
		}
		
		// test
		Polyline polyline1 = new Polyline();
		polyline1.setStrokeWidth(3);
		ObservableList<Double> list1 = polyline1.getPoints();
		double scaleFactor1 = 0.000125;
		for (int x = -100; x <= 100; x++) {
			list1.add(x + 200.0);
			list1.add(scaleFactor1 * (x*x*x + x*x*100 + x*1000));
		}
		gr.getChildren().add(polyline1);
		
		// X-Axis
		Text xText = new Text(0, 20, "x");
		xText.setRotate(180);
		Line xAxis = new Line(0, 0, 400, 0);
		xAxis.setStrokeWidth(3);
		Line xAxis_1 = new Line(0, 0, 10, 10);
		xAxis_1.setStrokeWidth(3);
		Line xAxis_2 = new Line(0, 0, 10, -10);
		xAxis_2.setStrokeWidth(3);
		
		Text text1 = new Text(115, -10, "1");
		text1.setRotate(180);
		gr.getChildren().add(text1);
		
		// Y-Axis
		Text yText = new Text(180, 400, "y");
		yText.setRotate(180);
		Line yAxis = new Line(200, -100, 200, 400);
		yAxis.setStrokeWidth(3);
		Line yAxis_1 = new Line(200, 400, 190, 390);
		yAxis_1.setStrokeWidth(3);
		Line yAxis_2 = new Line(200, 400, 210, 390);
		yAxis_2.setStrokeWidth(3);
		
		Text text2 = new Text(205, 80, "1");
		text2.setRotate(180);
		gr.getChildren().add(text2);
		
		// rows
		for (int i = -10; i< 40; i++) {
			Line l = new Line(0, i*10, 400, i*10);
			l.setStrokeWidth(.2);
			gr.getChildren().add(l);
		}
		
		// cols
		for (int i =0; i< 41; i++) {
			Line l = new Line(i*10, -100, i*10, 400);
			l.setStrokeWidth(.2);
			gr.getChildren().add(l);
		}
		
		// Note for line
		Text note = new Text(50, 350, "y = x^2");
		note.setRotate(180);
		gr.getChildren().add(note);
		
	
		Line intersect1 = new Line(120, 80, 120, 0);
		intersect1.setStyle("-fx-stroke: red;");
		intersect1.getStrokeDashArray().addAll(10d, 10d);
		intersect1.setStrokeWidth(2);
		gr.getChildren().add(intersect1);
		Line intersect2 = new Line(120, 80, 200, 80);
		intersect2.setStyle("-fx-stroke: red;");
		intersect2.getStrokeDashArray().addAll(10d, 10d);
		intersect2.setStrokeWidth(2);
		gr.getChildren().add(intersect2);
		
		// additional line y = x
		Polyline polymonial1 = new Polyline();
		polymonial1.setStroke(Color.BLUE);
		polymonial1.setStrokeWidth(3);
		ObservableList<Double> list3 = polymonial1.getPoints();
		double scaleFactor3 = 1;
		for (int x = -200; x <= 100; x++) {
			list3.add(x + 200.0);
			list3.add(scaleFactor3 * (-x));
		}
		gr.getChildren().add(polymonial1);
		Text note1 = new Text(10, 150, "y = x");
		note1.setRotate(180);
		gr.getChildren().add(note1);
		
		// Add elements
		gr.getChildren().add(polyline);
		gr.getChildren().add(xText);
		gr.getChildren().add(xAxis);
		gr.getChildren().add(xAxis_1);
		gr.getChildren().add(xAxis_2);
		gr.getChildren().add(yText);
		gr.getChildren().add(yAxis);
		gr.getChildren().add(yAxis_1);
		gr.getChildren().add(yAxis_2);
		gr.setRotate(180);
		borderPane.setCenter(gr);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


}

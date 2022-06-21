import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoundBorder extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		//add to the border pane
		pane.setTop(new LabelPane("Top", "red"));
		pane.setBottom(new LabelPane("Bottom", "blue"));
		pane.setLeft(new LabelPane("Left", "green"));
		pane.setRight(new LabelPane("Right", "yellow"));
		pane.setCenter(new LabelPane("Center", "orange"));
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
		
	}

}
class LabelPane extends Pane{
	public LabelPane(String text, String colorName) {
		Label name = new Label(text);
		this.getChildren().add(name);
		this.setStyle("-fx-background-color: " + colorName);
		
		//ellipse at x=50, y=80
		//with an x-radius of 25 and a y-radius of 75
		Ellipse c = new Ellipse(50, 80, 25, 75);
		c.centerXProperty().bind(this.widthProperty().divide(2));
		c.centerYProperty().bind(this.heightProperty().divide(2));
		c.radiusXProperty().bind(this.widthProperty().divide(4));
		c.radiusYProperty().bind(this.heightProperty().divide(3));
		c.setFill(Color.WHITE);
		this.getChildren().add(c);
		
		// arc at x = 200, y = 200
		// with an x-radius of 60 and a y-radius of 60
		// its startAngle = 45 degree, length = 90
		Arc a = new Arc(200, 200, 60, 60, 45, 90);
		a.setType(ArcType.ROUND);
		a.centerXProperty().bind(this.widthProperty().divide(2));
		a.centerYProperty().bind(this.heightProperty().divide(2));
		a.radiusXProperty().bind(this.widthProperty().divide(3));
		a.radiusYProperty().bind(this.heightProperty().divide(3));
//		this.getChildren().add(a);
		
		Rectangle r = new Rectangle(30, 50);
		r.widthProperty().bind(this.widthProperty().divide(3));
		r.heightProperty().bind(this.heightProperty().divide(2.5));
		r.xProperty().bind(this.widthProperty().divide(2));
		r.yProperty().bind(this.heightProperty().divide(2));
		this.getChildren().add(r);
	}
}
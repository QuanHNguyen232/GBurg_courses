import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseKeyTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MyMouseKeyPane pane = new MyMouseKeyPane();
		
		Scene scene = new Scene(pane, 400, 400);
		
		
		primaryStage.setTitle("Mouse and Key events");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// must-have to enter from keyboard
		// to send key events
		pane.requestFocus();
	}


	public static void main(String[] args) {
		launch(args);
	}
}	// MouseKeyTest class ends

class MyMouseKeyPane extends Pane {
	
	public MyMouseKeyPane() {
//		Circle circle = new Circle(50, 50, 10);
//		this.getChildren().add(circle);
		Circle cursor = new Circle(0, 0, 10);
		cursor.setStroke(Color.GRAY);
		cursor.setFill(Color.WHITE);
		this.getChildren().add(cursor);
		
		// handle mouse movement
		this.setOnMouseMoved(e -> {
			cursor.setCenterX(e.getX());
			cursor.setCenterY(e.getY());
//			cursor.setTranslateX(e.getX());
//			System.out.println(cursor.getCenterX() + " -> " + cursor.getTranslateX());
		});
		
		// handle mouse clicks
		this.setOnMouseClicked(e -> {
			// get position from event
//			circle.setCenterX(e.getX());
//			circle.setCenterY(e.getY());
			if (e.getButton() == MouseButton.PRIMARY) {
				Circle cir = new Circle(e.getX(), e.getY(), 10);
				this.getChildren().add(cir);
			}
			else {
				for (Node n : this.getChildren()) {
					if (n instanceof Shape) {
						((Shape) n).setFill(Color.RED);
					}
				}
			}
		});
		
		this.setOnKeyTyped(e -> {
			System.out.println("type: " +e.getCode());	// setOnKeyTyped: getCode returns UNDEFINED
			String s = e.getCharacter();
			if (!s.equals("")) {
				Text text = new Text(cursor.getCenterX(), cursor.getCenterY(), s);
				this.getChildren().add(text);
			}
		});
		
		this.setOnKeyPressed(e -> {
			System.out.println("press: " +e.getCode());	// setOnKeyPressed: getCode returns code (eg: TAB, SHIFT, etc.)
			if (e.getCode() == KeyCode.TAB) {
				cursor.setFill(Color.BLUE);
			}
		});
		
		this.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.TAB) {
				cursor.setFill(Color.WHITE);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
//		Circle list[] = new Circle[5];
//		for (int i=0; i<5; i++) {
//			list[i] = new Circle(100+i*10, 100, 5);
//			list[i].setFill(Color.AQUA);
//			this.getChildren().add(list[i]);
//		}
//		this.setOnMouseClicked(e -> {
//			if (e.getButton() == MouseButton.SECONDARY) {
//				for (int i=0; i<5; i++) {
//					list[i].setCenterX(e.getX()+i*10);
//					list[i].setCenterY(e.getY());
//					try {
//						Thread.sleep(1000);	// error: cannot see the change of each circle 
//						// all this stuff must out the event handler
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
		
	}
	

}

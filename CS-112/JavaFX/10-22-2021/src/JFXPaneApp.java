import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFXPaneApp extends Application {	// can have various classes in a .java file. But only 1 class is public and its name must be the same as filename.java
// http://cs.gettysburg.edu/~cpresser/cs112/examples/JFXPaneApp.java
	@Override
	public void start(Stage primaryStage) {
		
//		Pane pane = new IntroPane();
//		Pane pane = new FormPane();
		Pane pane = new GridFormPane();
		
		Scene scene = new Scene(pane);
		
		primaryStage.setTitle("JavaFX Panes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}	// end JFXPaneApp class


class IntroPane extends BorderPane{

	Button button;
	TextField textField;
	TextArea textArea;
	
	public IntroPane() {
		BorderPane pane1 = new BorderPane();
		
		//build the nodes we want to add
		button = new Button("Enter");

		textField = new TextField("Editable?");
		textArea = new TextArea();
		
		Circle circle = new Circle(100, 100, 50);
		circle.setRadius(30);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.BLUE);
		
		
		Text text = new Text(10, 100, "This is a text");
		text.setFont(new Font(20));
	
	
		//lay them out
		FlowPane top = new FlowPane();
		top.setStyle("-fx-border-color: blue; -fx-background-color: gray;");
		System.out.println(top.getStyle());
		top.getChildren().add(new Label("Input "));
		top.getChildren().add(textField);
		top.getChildren().add(button);
		
		// add nodes to BorderPane
		pane1.setTop(top);
		pane1.setCenter(textArea);
		pane1.setBottom(text);
		pane1.setRight(circle);
		
//		this.getChildren().add(pane1);
		this.setCenter(pane1);
	}
	
}

class FormPane extends Pane{

	private final String[] labels = {"First Name", "Last Name", "Year", "Class"};
	private TextField[] fields;
	
	public FormPane() {
		//set up sizes
		GridPane pane = new GridPane();
		int gap=100;
		pane.setHgap(gap);	// gap b/w columns
		pane.setVgap(gap);	// gap b/w rows
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		fields = new TextField[labels.length];
		for(int i = 0; i < labels.length; i++) {
			Label label = new Label(labels[i]);
			fields[i] = new TextField();
			
			pane.add(label, 0, i);
			pane.add(fields[i], 1, i);
			
		}
		this.getChildren().add(pane);
	}
	
}

class GridFormPane extends GridPane{

	private final String[] labels = {"First Name", "Last Name", "Year", "Class"};
	private TextField[] fields;
	
	public GridFormPane() {
		//set up sizes
		setHgap(5);
		setVgap(5);
		
		setPadding(new Insets(10, 10, 10, 10));
		
		fields = new TextField[labels.length];
		for(int i = 0; i < labels.length; i++) {
			Label label = new Label(labels[i]);
			fields[i] = new TextField();
			
			this.add(label, 0, i);
			this.add(fields[i], 1, i);
			
		}
	}
	
}

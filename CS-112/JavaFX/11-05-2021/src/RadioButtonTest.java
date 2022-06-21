import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RadioButtonTest extends Application {
	
	private Circle circle;
	private TextField status;
	private RadioButton rb1, rb2, rb3;
	private ToggleGroup rbGroup;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		mainPane.setLeft(createRadioButtonPane());
		mainPane.setBottom(createStatusPane());
		mainPane.setRight(createCirclePane());
		
		Scene scene = new Scene(mainPane);
		
		primaryStage.setTitle("Radio Button Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Pane createRadioButtonPane() {
		StackPane stack = new StackPane();
		VBox pane = new VBox();	// VBox is a subclass of pane
		rb1 = new RadioButton("Red");
		rb2 = new RadioButton("Blue");
		rb3 = new RadioButton("Green");
		pane.getChildren().addAll(rb1, rb2, rb3);
		
		rbGroup = new ToggleGroup();
		rb1.setToggleGroup(rbGroup);
		rb2.setToggleGroup(rbGroup);
		rb3.setToggleGroup(rbGroup);
		
		// set up events
		rb1.setOnAction(e -> handleRadioClick(e, Color.RED));
		rb2.setOnAction(e -> handleRadioClick(e, Color.BLUE));
		rb3.setOnAction(e -> handleRadioClick(e, Color.GREEN));
		
		stack.getChildren().add(pane);
		return stack;
//		return pane;
	}
	
	private Pane createCirclePane() {
		Pane pane = new Pane();
		circle = new Circle(50);
		circle.centerXProperty().bind(pane.widthProperty().multiply(.5));
		circle.centerYProperty().bind(pane.heightProperty().multiply(.5));
		pane.getChildren().add(circle);
		
		return pane;
	}

	
	private Pane createStatusPane() {

		HBox pane = new HBox();
		Button check = new Button("Check");
		status = new TextField();
		status.setEditable(false);
		
		pane.getChildren().addAll(status, check);
		HBox.setHgrow(status, Priority.ALWAYS);
		
		check.setOnAction(e -> handleButtonClick());
		
		return pane;
	}
	
	private void handleRadioClick(ActionEvent e, Color c) {
		circle.setFill(c);
	}
	
	private void handleButtonClick() {
		// get information from the selected radio button
		Toggle t = rbGroup.getSelectedToggle();	// Toggle is just an interface
		if (t instanceof RadioButton) {
			RadioButton rb = (RadioButton) t; 	// RadioButton implements Toggle ? check API
			status.setText(rb.getText());
		}
		
//		status.setText("Click");
	}
	

	
	

	public static void main(String[] args) {
		launch(args);
	}
}	// end RadioButtonTest
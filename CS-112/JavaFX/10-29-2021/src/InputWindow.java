import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class InputWindow extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		
		HBox top = new HBox(10);

		
		TextField input = new TextField();
		//tell the TextField to expand to fit the space available
		//Note setHgrow is a static method of HBox.
		HBox.setHgrow(input, Priority.ALWAYS);
		
		Button add = new Button("Add");
		top.getChildren().addAll(new Label("Input"), input, add);
		mainPane.setTop(top);
		
		TextArea text = new TextArea();
		mainPane.setCenter(text);
		
		TextField status = new TextField();
		status.setEditable(false);
		mainPane.setBottom(status);
		
		EventHandler<ActionEvent> handler = e ->  {
			System.out.println("Click!");
			String s = input.getText();
			if(s != null && s.length() > 0) {
				text.appendText(s + "\n");
				input.clear();
				status.setText("Characters: " + text.getLength());

			}
		}; 
		
		//lambda expression class
		add.setOnAction(handler); 
		input.setOnAction(handler);
		
		Scene scene = new Scene(mainPane);
		
		primaryStage.setTitle("Action Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}


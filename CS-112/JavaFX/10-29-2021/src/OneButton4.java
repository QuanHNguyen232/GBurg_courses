import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class OneButton4 extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		
		Button click = new Button("Click Here!");
		
		//lambda expression class
		click.setOnAction( e -> {
				System.out.println("Click!");
				click.setRotate(15 + click.getRotate());
		}); //end call to setOnAction
		
		pane.getChildren().add(click);
		
		Scene scene = new Scene(pane, 200, 200);
		
		primaryStage.setTitle("Button Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

} //end class OneButton3

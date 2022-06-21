import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class OneButton2 extends Application {
	Button click;
	@Override
	public void start(Stage primaryStage) {
		
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		
//		Button click = new Button("Click Here!");
		click = new Button("Click Here!");

		//didn't really need the variable
		click.setOnAction(new ClickEventHandler2());
		
		pane.getChildren().add(click);
		
		Scene scene = new Scene(pane, 200, 200);
		
		primaryStage.setTitle("Button Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

    //inner class
	class ClickEventHandler2 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			System.out.println("Click!");
			// error because it cannot access since Button is not a field in that class
			// instead, Button is just an obj in start method
			click.setRotate(15 + click.getRotate());
			
		}
	}

} //end class OneButton2
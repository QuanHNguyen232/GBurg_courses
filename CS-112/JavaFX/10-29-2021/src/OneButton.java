import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class OneButton extends Application {
	private Button click;
	@Override
	public void start(Stage primaryStage) {
		
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		
//		Button click = new Button("Click Here!");
		click = new Button("Click Here!");
		
		ClickEventHandler clickHandler = new ClickEventHandler(click);
		
		click.setOnAction(clickHandler);
		
		pane.getChildren().add(click);
		
		Scene scene = new Scene(pane, 200, 200);
		
		primaryStage.setTitle("Button Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

} //end class OneButton

class ClickEventHandler implements EventHandler<ActionEvent> {
	
	private Button click;
	
	public ClickEventHandler(Button b) {
		this.click = b;
	}
	
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Click!");
		// error because not relates to that class
		click.setRotate(15 + click.getRotate());
	}
}
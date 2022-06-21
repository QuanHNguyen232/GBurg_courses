import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MessyUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		GridPane grid = new GridPane();
		
		// grid on LEFT SIDE
		Label label = new Label("label");
		TextField input = new TextField();
		TextField input2 = new TextField();
		Button click = new Button("Click");
		
		grid.add(label, 0, 0);
		grid.add(input, 0, 1);
		grid.add(input2, 0, 2);
		grid.add(click, 0, 3);
				
		// grid on RIGHT SIDE
		int i=0;
		for (int rowIndex=0; rowIndex<=4; rowIndex++) {
			for (int columnIndex = 0; columnIndex< 5; columnIndex++) {
				String s = String.valueOf(i);
				Button btn = new Button(s);
				btn.setOnAction(e -> {
					input.appendText(s+"-");
				});
				grid.add(btn, columnIndex+1, rowIndex);
				i++;
			}
		}
		
		//
		Button btnCancel = new Button("Cancel");
		Button btnOk= new Button("Ok");
		Button btnApply= new Button("Apply");
		grid.add(btnApply, 0, 6);
		grid.add(btnOk, 0, 7);
		grid.add(btnCancel, 0, 8);
		
		btnCancel.setOnAction(e -> {
			input2.clear();
			input2.appendText("Canceled");
		});
		btnOk.setOnAction(e -> {
			input2.clear();
			input2.appendText("Ok");
		});
		btnApply.setOnAction(e -> {
			input2.clear();
			input2.appendText("Applied");
		});
		click.setOnMouseClicked( e -> {
			input2.clear();
			input2.appendText("Clicked");
		});
		
		Scene scene = new Scene(grid, 500, 500);
		
		primaryStage.setTitle("MessyUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

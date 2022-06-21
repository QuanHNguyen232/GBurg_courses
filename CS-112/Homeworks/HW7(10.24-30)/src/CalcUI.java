import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalcUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		border.setBottom(grid);
		
		// text
		TextField textField = new TextField();
		TextArea textArea = new TextArea();
		border.setTop(textField);
		border.setCenter(textArea);
		
				
		// 0->9 btns
		int i=0;
		for (int rowIndex=0; rowIndex<=1; rowIndex++) {
			for (int columnIndex = 0; columnIndex< 5; columnIndex++) {
				String s = String.valueOf(i);
				Button btn = new Button(s);
				btn.setOnAction(e -> {
					textField.appendText(" " + s);
				});
				grid.add(btn, columnIndex, rowIndex);
				i++;
			}
		}
		
		
		// functional btns
		Button btnAdd = new Button("+");
		Button btnMinus = new Button("-");
		Button btnMul = new Button("*");
		Button btnDiv = new Button("/");
		Button btnDot = new Button(".");
		Button btnEqual = new Button("=");
		Button btnClear = new Button("Clear");
		Button btnHistory= new Button("Clear TextField");
		
		grid.add(btnAdd, 5, 0);
		grid.add(btnMinus, 6, 0);
		grid.add(btnMul, 5, 1);
		grid.add(btnDiv, 6, 1);
		grid.add(btnEqual, 7, 1);
		grid.add(btnClear, 8, 0);
		grid.add(btnHistory, 7, 0);
		grid.add(btnDot, 8, 1);

		btnAdd.setOnAction(e -> {
			textField.appendText(" +");
		});
		btnMinus.setOnAction(e -> {
			textField.appendText(" -");
		});
		btnMul.setOnAction(e -> {
			textField.appendText(" *");
		});
		btnDiv.setOnAction(e -> {
			textField.appendText(" /");
		});
		btnDot.setOnAction(e -> {
			textField.appendText(".");
		});
		btnEqual.setOnAction(e -> {
			textArea.appendText(textField.getText() + "\n");
			textField.clear();
		});
		btnClear.setOnAction(e -> {
			textField.clear();
		});
		btnHistory.setOnAction(e -> {
			textArea.clear();
		});
		
		Scene scene = new Scene(border, 500, 500);
		
		primaryStage.setTitle("CalcUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

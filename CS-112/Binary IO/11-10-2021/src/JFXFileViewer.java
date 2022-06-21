import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class JFXFileViewer extends Application {
	
	private Pane circlePane;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		Scene scene = new Scene(mainPane);
		circlePane = new Pane();
		circlePane.setPrefSize(400, 400);
		
		mainPane.setCenter(circlePane);
		
		//set up a button to open the file dialog
		Button fileButton = new Button("Open File...");
		fileButton.setOnAction(e -> {openFile(primaryStage);});
		
		mainPane.setBottom(fileButton);
		primaryStage.setTitle("File Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	private void openFile(Stage window) {
		//a file chooser provides a system specific open file dialog
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Circle File");

		File pwd = new File(".");
		fileChooser.setInitialDirectory(pwd);

		//display the dialog and wait for the response
		//there is also a showSaveDialog among others
		File selectedFile = fileChooser.showOpenDialog(window);
		if (selectedFile != null) {
			readCircles(selectedFile);
		}
	}
	
	private void readCircles(File file) {
		try {
			Scanner inFromFile = new Scanner(file);
			
			int n = inFromFile.nextInt();
			circlePane.getChildren().clear();
			
			for(int i = 0; i < n; i++) {
				double x = inFromFile.nextDouble();
				double y = inFromFile.nextDouble();
				double r = inFromFile.nextDouble();
				
				Circle c = new Circle(x, y, r);
				circlePane.getChildren().add(c);
			}
			inFromFile.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(Exception e) {
			//if there is a problem, show an error message.
			e.printStackTrace();
			//AlertType.ERRO?
			Alert alert = new Alert(AlertType.CONFIRMATION, "Error reading the file.");
			
			//show and wait allows the program to keep running, but doesn't return until the 
			//user responds
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				System.err.println("OK");
			}
			else {
				System.exit(-1);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
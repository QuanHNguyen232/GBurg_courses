import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EyeHand extends Application {
	private static final double WIDTH = 500.0;
	private static final double TIME_MILLIS = 50;
	private static final int numCir = 5;
	private static int num;
	private static boolean isStarted = false;
	private static long startTime;
	private static BorderPane pane = new BorderPane(), playPane = new BorderPane();
	private static GridPane infoPane, timePane;
	private static Text infoText = new Text();
	private static MyCircle[] cirList = new MyCircle[numCir];

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pane.setCenter(playPane);
		infoPane = new GridPane();
		pane.setTop(infoPane);
		timePane = new GridPane();
		pane.setBottom(timePane);
		
//		TextField t = new TextField();
//		infoPane.add(t, 5, 0);
		

		
		
		// infoText
		infoPane.add(infoText, 0, 0);
		infoText.setText(String.format("There are %d circles in total", numCir));
				
		// start button
		Button startBtn = new Button("Start");
		infoPane.add(startBtn, 0, 2);
		startBtn.setOnKeyTyped(e -> {
			if (!isStarted) {
				num = numCir;
				
				infoText.setText(String.format("There are %d circle(s) left", num));
				startTime = System.currentTimeMillis();
				
				// Time pane
				timePane.getChildren().clear();
				Text timeText = new Text("start time: " + String.valueOf(startTime));
				timePane.add(timeText, 0, 0);
				
				createCircles();
				isStarted = true;
			}
		});
		
		Scene scene = new Scene(pane, WIDTH, WIDTH);
		
		primaryStage.setTitle("Eye Hand");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		System.out.println(pane.getHeight());
		startBtn.requestFocus();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void createCircles() {
		
		// create circles
		for (int i=0; i< cirList.length; i++) {
			cirList[i] = new MyCircle((int)WIDTH);
		}
		
		// add the first circle to Pane
		playPane.getChildren().add(cirList[0]);
		cirSize(cirList[0]);
		
		// add event for circles
		for (int i=0; i< cirList.length-1; i++) {
			MyCircle oldCir = cirList[i];
			MyCircle newCircle = cirList[i+1];
			oldCir.setOnMouseClicked(e -> {
				playPane.getChildren().remove(oldCir);
				playPane.getChildren().add(newCircle);
				cirSize(newCircle);
				
				// information pane
				infoText.setText(String.format("There are %d circle(s) left", --num));
			});
		}
		
		// add event for the LAST circle
		cirList[cirList.length-1].setOnMouseClicked(e -> {
			playPane.getChildren().remove(cirList[cirList.length-1]);
			infoText.setText(String.format("There are %d circle(s) left", --num));
			isStarted = false;
			long endTime = System.currentTimeMillis();
			timePane.add(new Text("end time: " + endTime), 0, 1);
			timePane.add(new Text("time play: " + (endTime - startTime)), 0, 2);
		});
	}
		
	public void cirSize(MyCircle c) {
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(TIME_MILLIS), e -> {
			c.rescale();
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}


	class MyCircle extends Circle {
		private final static double radius = 10;
		public Random rand1 = new Random();
		
		public MyCircle(int maxWidth) {
//			this.setCenterX(rand1.nextInt(maxWidth-100)+50);
			this.setCenterX(rand1.nextInt((int)playPane.getWidth()-100)+50);
//			this.setCenterY(rand1.nextInt(maxWidth-100)+50);
			this.setCenterY(rand1.nextInt((int)playPane.getHeight()-100)+50);
			this.setRadius(radius);
			this.setFill(Color.rgb(rand1.nextInt(256), rand1.nextInt(256), rand1.nextInt(256), .5));
		}

		public void rescale() {
			this.setScaleX(this.getScaleX()*1.1);
			this.setScaleY(this.getScaleY()*1.1);
		}
	}
	
}




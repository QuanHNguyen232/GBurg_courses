import java.util.Arrays;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChaosGame extends Application{
	@Override
	public void start(Stage primaryStage) {
		ChaosPane chaos = new ChaosPane(500, 500);
		
		Scene scene = new Scene(chaos);
		
		primaryStage.setTitle("Pane Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class ChaosPane extends Pane {
	public static final int ITERATIONS = 100000;
	public static final int POINTS = 3;
	
	WritableImage image;
	//Image image2;
	
	public ChaosPane(int width, int height) {
		this.setMinSize(width, height);
		this.setPrefSize(width, height);
		
		//create image
		image = new WritableImage(width, height);
		createImage(width, height);
		//image2 = new Image("http://cs.gettysburg.edu/~cpresser/brback.jpg");
		
		//layout image viewer
		ImageView viewer = new ImageView(image);
		
		this.getChildren().add(viewer);
		//this.setTop(viewer);
	}
	
	public void createImage(int width, int height) {
		Random rand = new Random();
		
		double[] ptX = new double[POINTS];
		double[] ptY = new double[POINTS];
		
		
		//set up initial points
		ptX[0] = 0;
		ptY[0] = height;
		ptX[1] = width/2;
		ptY[1] = 0;
		ptX[2] = width;
		ptY[2] = height;
		
		PixelWriter pw = image.getPixelWriter();
		
		double x = 0, y = 0;
		for(int i = 1; i <= ITERATIONS; i++) {
			//pick a random point
			int pt = rand.nextInt(POINTS);
			
			x = (x + ptX[pt])/2;
			y = (y + ptY[pt])/2;
			
			pw.setColor((int)x, (int)y, Color.BLUE);	// why setColor must has x, y
		}
		
	}
	
	
	public void createImageN(int width, int height) {
		Random rand = new Random();
		
		double[] ptX = new double[POINTS];
		double[] ptY = new double[POINTS];
		
		double angle = 2*Math.PI / POINTS;
		for(int i = 0; i < POINTS; i++) {
			ptX[i] = width/2.0 + Math.cos(i*angle)*(width/2.0);
			ptY[i] = height/2.0 + Math.sin(i*angle)*(height/2.0);
		}
		System.out.printf("%s\n", Arrays.toString(ptX));
		System.out.printf("%s\n", Arrays.toString(ptY));
		
		PixelWriter pw = image.getPixelWriter();
		
		double x = 0, y = 0;
		for(int i = 1; i <+ ITERATIONS; i++) {
			//pick a random point
			int pt = rand.nextInt(POINTS);
			
			x = (x + ptX[pt])/2;
			y = (y + ptY[pt])/2;
			
			pw.setColor((int)x, (int)y, Color.BLUE);
		}
	}
	
}
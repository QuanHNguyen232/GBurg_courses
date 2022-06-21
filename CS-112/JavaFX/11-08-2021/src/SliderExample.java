import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SliderExample extends Application{
	Rectangle rectangle;
	Color color;
	
	// add an opacitySlider
	Slider redSlider, greenSlider, blueSlider;
	Slider opacitySlider;
	ColorPicker picker;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		
		mainPane.setPadding(new Insets(10, 10, 10, 10));
		
		mainPane.setLeft(createSliderPane());
		
		color = new Color(.5, .5, .5, 1.0);
		rectangle = new Rectangle(0, 0, 100, 100);
		
		rectangle.setFill(color);
		
		Circle circle = new Circle(50, 50, 50);
		Pane shapePanes = new Pane();
		shapePanes.getChildren().addAll(circle, rectangle);
		
		mainPane.setCenter(shapePanes);
		
		mainPane.setBottom(createPickerPane());
		picker.setValue(color);
		
		
		Scene scene = new Scene(mainPane);
		
		primaryStage.setTitle("Radio Button Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private Pane createSliderPane() {
		//VBox pane = new VBox();
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		redSlider = createSlider();
		greenSlider = createSlider();
		blueSlider = createSlider();
		opacitySlider = createSlider();
		
		TextField redText = new TextField();
		TextField greenText = new TextField();
		TextField blueText = new TextField();
		TextField opacityText = new TextField();
		
		//layout all of the things!
		pane.add(new Label("Red"), 0, 0);
		pane.add(new Label("Green"), 0, 1);
		pane.add(new Label("Blue"), 0, 2);
		pane.add(new Label("Opacity"), 0, 3);
		
		pane.add(redText, 1, 0);
		pane.add(greenText, 1, 1);
		pane.add(blueText, 1, 2);
		pane.add(opacityText, 1, 3);
		
		pane.add(redSlider, 2, 0);
		pane.add(greenSlider, 2, 1);
		pane.add(blueSlider, 2, 2);
		pane.add(opacitySlider, 2, 3);
		
		//bind the sliders to the text fields
		redText.textProperty().bind(redSlider.valueProperty().asString());	// can we use String.valueOf()?
		greenText.textProperty().bind(greenSlider.valueProperty().asString());
		blueText.textProperty().bind(blueSlider.valueProperty().asString());
//		opacityText.textProperty().bind(opacitySlider.valueProperty().asString());
//		opacityText.textProperty().bindBidirectional(opacitySlider.valueProperty().toString());	// error
		opacitySlider.valueProperty().bindBidirectional(opacityText.opacityProperty());	// How can I bind with the text inside
		
		
		//all of the sliders will have the same listener
		InvalidationListener listener = e -> {
			//create a new color and update both rectangle and ColorPicker
			Color c = new Color(redSlider.getValue(), greenSlider.getValue(), 
					blueSlider.getValue(), opacitySlider.getValue());
			rectangle.setFill(c);
			picker.setValue(c);
		};
		
		redSlider.valueProperty().addListener(listener);
		greenSlider.valueProperty().addListener(listener);
		blueSlider.valueProperty().addListener(listener);
		opacitySlider.valueProperty().addListener(listener);
		
		return pane;
	}
	
	private Slider createSlider() {
		Slider slider = new Slider(0, 1, .5);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(.2);
		slider.setOrientation(Orientation.HORIZONTAL);
		return slider;
	}
	
	private Pane createPickerPane() {
		HBox pane = new HBox();
		
		picker = new ColorPicker();
		picker.setOnAction(e -> {
			Color c = picker.getValue();
			redSlider.setValue(c.getRed());
			greenSlider.setValue(c.getGreen());
			blueSlider.setValue(c.getBlue());
			opacitySlider.setValue(c.getOpacity());
		});
		
		
		pane.getChildren().add(picker);
		
		return pane;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
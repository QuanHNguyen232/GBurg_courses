import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class StoreShape {

	private String type;
	private ArrayList<Double> data, color;
	
	public StoreShape(Shape s) {
		data = new ArrayList<Double>();
		color = new ArrayList<Double>();
		
		if (s instanceof Circle) {
			type = "Circle";
			Circle c = (Circle) s;
			this.data.add(c.getCenterX());
			this.data.add(c.getCenterY());
			this.data.add(c.getRadius());
			String colorData = c.getFill().toString().substring(2);
			getColor(colorData);
			System.out.println("done init");
		}
		else if (s instanceof Rectangle) {
			type = "Rectangle";
			Rectangle r = (Rectangle) s;
			this.data.add(r.getX());
			this.data.add(r.getY());
			this.data.add(r.getWidth());
			this.data.add(r.getHeight());
			String colorData = r.getFill().toString().substring(2);
			getColor(colorData);
		}
		else if (s instanceof Line) {
			type = "Line";
			Line l = (Line) s;
			this.data.add(l.getStartX());
			this.data.add(l.getStartY());
			this.data.add(l.getEndX());
			this.data.add(l.getEndY());
			String colorData = l.getStroke().toString().substring(2);
			getColor(colorData);
		}
		else {
			throw new IllegalArgumentException("Shape is unidentified");
		}
	}
	
	private void getColor(String s) {
		
		String red = s.substring(0, 2);
		double redNum = Integer.parseInt(red,16)/255.0;
		this.color.add(redNum);
		
		String green = s.substring(2, 4);
		double greenNum = Integer.parseInt(green,16)/255.0;
		this.color.add(greenNum);
		
		String blue = s.substring(4, 6);
		double blueNum = Integer.parseInt(blue,16)/255.0;
		this.color.add(blueNum);
		
		String opacity = s.substring(s.length()-2, s.length());
		double opaNum = Integer.parseInt(opacity,16)/255.0;
		this.color.add(opaNum);
		System.out.println("done color");
	}
	
	public Shape getShape() {
		Color colorShape = new Color(this.color.get(0), this.color.get(1), this.color.get(2), this.color.get(3));
		
		if (type.equalsIgnoreCase("line")) {
			Line line = new Line(this.data.get(0), this.data.get(1), this.data.get(2), this.data.get(3));
			line.setStroke(colorShape);
			return line;
		}
		else if (type.equalsIgnoreCase("circle")) {
			Circle circle  = new Circle(this.data.get(0), this.data.get(1), this.data.get(2));
			circle.setFill(colorShape);
			return circle;
		}
		else {
			Rectangle rectangle = new Rectangle(this.data.get(0), this.data.get(1), this.data.get(2), this.data.get(3));
			rectangle.setFill(colorShape);
			return rectangle;
		}
	}

	
	
	@Override
	public String toString() {
		return "StoreShape [type= " + type + ", data= " + data + ", color= " + color + "]";
	}
	
	
	public static void main(String[] args) {
		Circle c = new Circle(20, 50, 60);
		c.setFill(Color.rgb(25 , 51, 76, .1));
		StoreShape storeCircle = new StoreShape(c);
		System.out.println(storeCircle.toString());
	}

}

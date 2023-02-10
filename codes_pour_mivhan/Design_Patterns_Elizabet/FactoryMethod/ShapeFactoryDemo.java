package DesignPatterns.FactoryMethod;

import java.util.ArrayList;

public class ShapeFactoryDemo {
	public static void main(String []args) {
		ArrayList<Shape> shapes = new ArrayList<>();
		String[] strArr = { "Circle", null, "Square","Rectangle", "Triangle", "Circle", "Circle", "Square"};
		ShapeFactory shapeFactory = new ShapeFactory();
		for (String value : strArr) {
			try {
				shapes.add(shapeFactory.getShape(value));
			} catch (ShapeFactoryException e) {
				e.printStackTrace();
			}
		}
		for (Shape s : shapes){
			s.draw();			
		}
		System.out.println();
		for (Shape s : shapes){
			if (s instanceof Circle) s.erase();			
		}
 	}
}
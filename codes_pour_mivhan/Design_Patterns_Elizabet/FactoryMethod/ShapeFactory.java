package DesignPatterns.FactoryMethod;

/** Factory pattern is one of the most used design patterns
 *  in Java. This type of design pattern comes under
 *  creational pattern as this pattern provides one of
 *  the best ways to create an object.

 In Factory pattern, we create object without exposing
 the creation logic to the client and refer to newly
 created object using a common interface.
 */
interface Shape {//Product
	void draw();
	void erase();
}

class Circle implements Shape {// Concrete Product
	Circle() {
	} // Package-access constructor
	@Override
	public void draw() {
		System.out.println("Circle.draw");
	}
	@Override
	public void erase() {
		System.out.println("Circle.erase");
	}
}

class Point implements Shape {// Concrete Product
	Point() {
	} // Package-access constructor
	@Override
	public void draw() {
		System.out.println("Point.draw");
	}
	@Override
	public void erase() {
		System.out.println("Point.erase");
	}
}
class Square implements Shape {// Concrete Product
	Square() {
	} // Package-access constructor
	@Override
	public void draw() {
		System.out.println("Square.draw");
	}
	@Override
	public void erase() {
		System.out.println("Square.erase");
	}
}

class Rectangle implements Shape {// Concrete Product
	Rectangle() {
	} // Package-access constructor
	@Override
	public void draw() {
		System.out.println("Rectangle.draw");
	}
	@Override
	public void erase() {
		System.out.println("Rectangle.erase");
	}
}

public class ShapeFactory {// Factory Method
	public Shape getShape(String type) throws ShapeFactoryException {
		if (type == null) throw new ShapeFactoryException("the shape type is null");
		if (type.equalsIgnoreCase("Circle"))
			return new Circle();
		if (type.equalsIgnoreCase("Point"))
			return new Point();
		if (type.equalsIgnoreCase("Square"))
			return new Square();
		if (type.equalsIgnoreCase("Rectangle"))
			return new Rectangle();
		throw new ShapeFactoryException("the shape type does not exist");
	}
}
package 对象和数据结构;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 数据、对象的反对称性
 */
public class Demo62 {
}
清单6-5
public class Square {
	public Point topLeft;
	public double side;
}

public class Rectangle {
	public Point topLeft;
	public double height;
	public double width;
}

public class Circle {
	public Point center;
	public double radius;
}

public class Geometry {

	public final double PI = 3.141592653589793;

	public double area(Object shape) throws NoSuchShapeException {
		if (shape instanceof Square) {
			Square s = (Square) shape;
			return s.side * s.side;

		} else if (shape instanceof Rectangle) {
			Rectangle r = (Rectangle) shape;
			return r.height * r.width;

		} else if (shape instanceof Circle) {
			Circle c = (Circle) shape;
			return PI * c.radius * c.radius;
		}
		throw new NoSuchShapeException();
	}
}
===============================================================

清单6-6
public class Square implements Shape {

	private Point topLeft;

	private double side;

	public double area() {
		return side * side;

	}

}

public class Rectangle implements Shape {

	private Point topLeft;

	private double height;

	private double width;

	public double area() {
		return height * width;

	}

}

public class Circle implements Shape {

	private Point center;

	private double radius;

	public final double PI = 3.141592653589793;

	public double area() {
		return PI * radius * radius;

	}

}
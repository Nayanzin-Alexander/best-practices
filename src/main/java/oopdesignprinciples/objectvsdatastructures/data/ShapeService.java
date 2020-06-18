package oopdesignprinciples.objectvsdatastructures.data;

public class ShapeService {

    public double area(Shape shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getHeight() * rectangle.getWidth();
        }
        throw new ShapeServiceException("Unknown shape: " + shape);
    }
}

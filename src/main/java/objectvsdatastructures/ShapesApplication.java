package objectvsdatastructures;

import objectvsdatastructures.data.ShapeService;
import objectvsdatastructures.object.Rectangle;
import objectvsdatastructures.object.Shape;

public class ShapesApplication {

    public static void main(String[] args) {
        // Working with objects example
        Shape rectangle1 = new Rectangle(10, 100);
        double rectangleArea1 = rectangle1.area();

        // Working with data example
        ShapeService shapeService = new ShapeService();
        objectvsdatastructures.data.Shape rectangle2 = new objectvsdatastructures.data.Rectangle(100, 10);
        double rectangleArea2 = shapeService.area(rectangle2);

        System.out.println("rectangleArea1: " + rectangleArea1);
        System.out.println("rectangleArea2: " + rectangleArea2);
    }
}

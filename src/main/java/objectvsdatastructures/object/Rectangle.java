package objectvsdatastructures.object;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle implements Shape {
    private double height;
    private double width;

    @Override
    public double area() {
        return height * width;
    }
}

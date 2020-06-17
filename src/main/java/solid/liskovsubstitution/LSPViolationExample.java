package solid.liskovsubstitution;

import lombok.Setter;

@Setter
class Rectangle {
    protected int width;
    protected int height;

    public int area() {
        return width * height;
    }
}

@Setter
class Square extends Rectangle {
    @Override
    public void setWidth(int length) {
        setSides(length);
    }

    @Override
    public void setHeight(int length) {
        setSides(length);
    }

    private void setSides(int length) {
        this.width = length;
        this.height = length;
    }
}

public class LSPViolationExample {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(3);

        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(3);

        if (rectangle.area() != square.area()) {
            System.err.println("Liskov Substitution Principle was violated: "
                + "Rectangle is not  replaceable by Square");
        }
    }
}
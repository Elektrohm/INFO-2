package test;

public class Test {
    public static void main(String[] args) {
        Square square = new Square(5.0);
        Circle circle = new Circle(2.0);

        System.out.println("Perimeter : " + square.getPerimeter(square.length));
        System.out.println("Area : " + square.getArea(square.length));

        System.out.println("Perimeter : " + circle.getPerimeter(circle.radius));
        System.out.println("Area : " + circle.getArea(circle.radius));

    }
}

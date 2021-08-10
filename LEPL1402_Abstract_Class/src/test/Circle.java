package test;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(double d) {
        return Math.PI * d * d;
    }

    @Override
    public double getPerimeter(double d) {
        return 2 * Math.PI * d;
    }
}

package test;

public class Square extends Shape {
    double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea(double d) {
        return d * d;
    }

    @Override
    public double getPerimeter(double d) {
        return 4 * d;
    }
}

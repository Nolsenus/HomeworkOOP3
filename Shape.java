public abstract class Shape {
    protected double area;
    protected double perimeter;

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    protected void updateAreaPerimeter() {
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract String getShapeName();
    public abstract void changeValue(String valueName, double value) throws ShapeParameterException;
    public String getInfo() {
        return String.format("Площадь: %f, Периметр: %f", area, perimeter);
    }
}

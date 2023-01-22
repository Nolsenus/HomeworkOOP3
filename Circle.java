public class Circle extends Shape {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) throws CircleParameterException {
        if (radius <= 0) {
            throw new CircleParameterException("Радиус меньше или равен нулю.");
        }
        this.radius = radius;
        updateAreaPerimeter();
    }

    public Circle() {
        this.radius = 1;
        updateAreaPerimeter();
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getShapeName() {
        return "Круг";
    }

    @Override
    public void changeValue(String valueName, double value) throws CircleParameterException {
        if (valueName.equalsIgnoreCase("radius")) {
            if (value > 0) {
                this.radius = value;
                updateAreaPerimeter();
            } else {
                throw new CircleParameterException("Радиус меньше или равен нулю.");
            }
        } else {
            throw new CircleParameterException(String.format("Неизветный параметр: %s.", valueName));
        }
    }

    @Override
    public String getInfo() {
        return String.format("Круг{Радиус: %f, %s}", radius, super.getInfo());
    }
}

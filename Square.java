public class Square extends Shape {

    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public Square(double sideLength) throws SquareParameterException {
        if (sideLength <= 0) {
            throw new SquareParameterException("Сторона меньше или равна нулю.");
        }
        this.sideLength = sideLength;
        updateAreaPerimeter();
    }

    public Square() {
        this.sideLength = 1;
        updateAreaPerimeter();
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String getShapeName() {
        return "Квадрат";
    }

    @Override
    public void changeValue(String valueName, double value) throws SquareParameterException {
        if (value <= 0) {
            throw new SquareParameterException("Сторона меньше или равна нулю.");
        }
        if (valueName.equalsIgnoreCase("sidelength")) {
            this.sideLength = value;
            updateAreaPerimeter();
        } else {
            throw new SquareParameterException(String.format("Неизвестный параметр: %s.", valueName));
        }
    }

    @Override
    public String getInfo() {
        return String.format("Квадрат{Сторона: %f, %s}", sideLength, super.getInfo());
    }
}

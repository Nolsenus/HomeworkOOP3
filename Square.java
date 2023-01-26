public class Square extends Rectangle {

    public double getSideLength() {
        return width;
    }

    public Square(double sideLength) throws SquareParameterException {
        if (sideLength <= 0) {
            throw new SquareParameterException("Сторона меньше или равна нулю.");
        }
        this.width = sideLength;
        this.height = sideLength;
        updateAreaPerimeter();
    }

    public Square() {
        super();
        updateAreaPerimeter();
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
            this.width = value;
            this.height = value;
            updateAreaPerimeter();
        } else {
            throw new SquareParameterException(String.format("Неизвестный параметр: %s.", valueName));
        }
    }

    @Override
    public String getInfo() {
        return String.format("Квадрат{Сторона: %f, %s}", width, super.getInfo());
    }
}

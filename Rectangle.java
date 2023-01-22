public class Rectangle extends Shape{

    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle(double width, double height) throws RectangleParameterException {
        if (width <=0 || height <= 0) {
            throw new RectangleParameterException("Одна из сторон меньше или равна нулю.");
        }
        this.width = width;
        this.height = height;
        updateAreaPerimeter();
    }

    public Rectangle() {
        this.width = 1;
        this.height = 1;
        updateAreaPerimeter();
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getShapeName() {
        return "Прямоугольник";
    }

    @Override
    public void changeValue(String valueName, double value) throws RectangleParameterException {
        if (value <= 0) {
            throw new RectangleParameterException("Сторона меньше или равна нулю.");
        }
        switch (valueName.toLowerCase()) {
            case "width" : {
                this.width = value;
                updateAreaPerimeter();
                break;
            }
            case "height" : {
                this.height = value;
                updateAreaPerimeter();
                break;
            }
            default: {
                throw new RectangleParameterException(String.format("Неизвестный параметр: %s.", valueName));
            }
        }
    }

    @Override
    public String getInfo() {
        return String.format("Прямоугольник{Высота: %f, Ширина: %f, %s}", height, width, super.getInfo());
    }
}

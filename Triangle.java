public class Triangle extends Shape{

    private double sideA;
    private double sideB;
    private double sideC;

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double[] getSides() {
        double[] result = new double[3];
        result[0] = sideA;
        result[1] = sideB;
        result[2] = sideC;
        return result;
    }

    public Triangle(double sideA, double sideB, double sideC) throws TriangleParameterException{
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new TriangleParameterException("Одна из сторон не меньше суммы двух других.");
        }
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new TriangleParameterException("Одна из сторон меньше или равна нулю.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        updateAreaPerimeter();
    }

    public Triangle() {
        this.sideA = 1;
        this.sideB = 1;
        this.sideC = 1;
        updateAreaPerimeter();
    }


    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getShapeName() {
        return "Треугольник";
    }

    @Override
    public void changeValue(String valueName, double value) throws TriangleParameterException {
        if (value <= 0) {
            throw new TriangleParameterException("Сторона меньше или равна нулю.");
        }
        switch (valueName.toLowerCase()) {
            case "sidea" : {
                if (value + sideB <= sideC || value + sideC <= sideB || sideB + sideC <= value) {
                    throw new TriangleParameterException("Сторона не меньше суммы двух других.");
                }
                this.sideA = value;
                updateAreaPerimeter();
                break;
            }
            case "sideb" : {
                if (sideA + value <= sideC || sideA + sideC <= value || value + sideC <= sideA) {
                    throw new TriangleParameterException("Сторона не меньше суммы двух других.");
                }
                this.sideB = value;
                updateAreaPerimeter();
                break;
            }
            case "sidec" : {
                if (sideA + sideB <= value || sideA + value <= sideB || sideB + value <= sideA) {
                    throw new TriangleParameterException("Сторона не меньше суммы двух других.");
                }
                this.sideC = value;
                updateAreaPerimeter();
                break;
            }
            default : {
                throw new TriangleParameterException(String.format("Неизветсный параметр: %s", valueName));
            }
        }
    }

    @Override
    public String getInfo() {
        return String.format("Треугольник{Стороны: %f, %f, %f, %s}", sideA, sideB, sideC, super.getInfo());
    }
}

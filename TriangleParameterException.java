public class TriangleParameterException extends ShapeParameterException {
    public TriangleParameterException() {}
    public TriangleParameterException(String message) {
        super(String.format("Неправильно задан треугольник: %s", message));
    }
}

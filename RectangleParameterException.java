public class RectangleParameterException extends ShapeParameterException {
    public RectangleParameterException() {}
    public RectangleParameterException(String message) {
        super(String.format("Ошибка в прямоугольнике: %s", message));
    }
}

public class SquareParameterException extends RectangleParameterException {
    public SquareParameterException() {}
    public SquareParameterException(String message) {
        super(String.format("Неправильно задан квадрат: %s", message));
    }
}

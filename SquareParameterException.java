public class SquareParameterException extends ShapeParameterException {
    public SquareParameterException() {}
    public SquareParameterException(String message) {
        super(String.format("Неправильно задан квадрат: %s", message));
    }
}

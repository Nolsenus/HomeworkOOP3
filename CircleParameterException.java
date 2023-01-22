public class CircleParameterException extends ShapeParameterException {
    public CircleParameterException() {}
    public CircleParameterException(String message) {
        super(String.format("Ошибка в круге: %s", message));
    }
}

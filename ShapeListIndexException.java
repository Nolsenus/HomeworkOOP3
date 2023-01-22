public class ShapeListIndexException extends Exception {
    public ShapeListIndexException() {}
    public ShapeListIndexException(String message) {
        super(String.format("Некорректный индекс в классе ShapeList: %s", message));
    }
}

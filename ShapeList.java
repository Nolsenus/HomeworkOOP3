import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ShapeList {

    private List<Shape> shapeList;

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void printAllInfo() {
        for (Shape s : shapeList) {
            System.out.println(s.getInfo());
        }
    }

    private void checkIndex(int index) throws ShapeListIndexException{
        if (index < 0) {
            throw new ShapeListIndexException("Отрицательный индекс.");
        }
        if (index >= shapeList.size()) {
            throw new ShapeListIndexException("Индекс больше максимально допутимого.");
        }
    }

    public void printInfo(int index) throws ShapeListIndexException {
        checkIndex(index);
        Shape s = shapeList.get(index);
        System.out.printf("%s - Периметр: %f, Площадь: %f%n",
                s.getShapeName(), s.calculatePerimeter(), s.calculateArea());
    }

    public void add(Shape shape) {
        shapeList.add(shape);
    }

    public void remove(int index) throws ShapeListIndexException {
        checkIndex(index);
        shapeList.remove(index);
    }

    public void change(int index, String valueName, double value)
            throws ShapeListIndexException, ShapeParameterException {
        checkIndex(index);
        shapeList.get(index).changeValue(valueName, value);
    }

    public void sortByArea() {
        shapeList.sort(Comparator.comparingDouble(Shape::getArea));
    }

    public ShapeList(List<Shape> shapeList) {
        this.shapeList = new LinkedList<>(shapeList);
    }

    public ShapeList(Shape[] shapeArray) {
        this.shapeList = new LinkedList<>(Arrays.asList(shapeArray));
    }

    public ShapeList() {
        this.shapeList = new LinkedList<>();
    }
}

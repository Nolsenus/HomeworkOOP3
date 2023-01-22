import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[8];
        try {
            shapeArray[0] = new Circle();
            shapeArray[1] = new Circle(4);
            shapeArray[2] = new Rectangle();
            shapeArray[3] = new Rectangle(4, 5);
            shapeArray[4] = new Square();
            shapeArray[5] = new Square(4);
            shapeArray[6] = new Triangle();
            shapeArray[7] = new Triangle(4,4,4);
        } catch (ShapeParameterException e) {
            System.out.println(e.getMessage());
        }
        for (Shape s : shapeArray) {
            System.out.printf("Периметр: %f, Площадь: %f.%n", s.calculatePerimeter(), s.calculateArea());
        }
        ShapeList sl = new ShapeList(shapeArray);
        System.out.println();
        sl.printAllInfo();
        try {
            sl.add(new Circle (7));
            sl.remove(0);
            sl.change(0, "radius", 2);
        } catch (ShapeParameterException | ShapeListIndexException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        sl.printAllInfo();
        sl.sortByArea();
        System.out.println();
        sl.printAllInfo();
        System.out.println();
        try {
            shapeArray[7] = new Circle(-10);
        } catch (ShapeParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            shapeArray[7] = new Rectangle(-10, 12);
        } catch (ShapeParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            shapeArray[7] = new Square(-10);
        } catch (ShapeParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            shapeArray[7] = new Triangle(1, 2, 3);
        } catch (ShapeParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}

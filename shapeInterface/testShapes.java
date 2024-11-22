package shapeInterface;

public class testShapes {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[4];
        shapeArray[0] = new Circle("Happy Circle", "Red", 10);
        shapeArray[1] = new Rectangle("Mad Rectangle", "Blue", 10, 5);
        shapeArray[2] = new Triangle("Sad Triangle", "Green", 10, 5);
        shapeArray[3] = new Circle("Evil Circle", "Purple", 20);

        for (Shape shape : shapeArray){
            shape.calcArea();
        }

        shapeArray[0].compareTo(shapeArray[1]);
        shapeArray[2].compareTo(shapeArray[3]);
    }
}
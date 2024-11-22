package shapeInterface;

public class Rectangle extends Shape{

    private double length;
    private double width;
    
    public Rectangle(String name, String color, double length, double width){
        super(name, color);
        this.length = length;
        this.width = width;
    }

    public void calcArea(){
        System.out.println("The area of " + getName() + " is " + length*width + ".");
        setArea(length*width);
    }


}

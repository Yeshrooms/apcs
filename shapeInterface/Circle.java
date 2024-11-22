package shapeInterface;

public class Circle extends Shape{

    private double radius;

    public Circle(String name, String color, double radius){
        super(name, color);
        this.radius = radius;
    }

    public void calcArea(){
        System.out.println("The area of " + getName() + " is " + Math.PI*Math.pow(radius, 2) + ".");
        setArea(Math.PI*Math.pow(radius, 2));
    }

}
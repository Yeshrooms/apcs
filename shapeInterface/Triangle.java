package shapeInterface;

public class Triangle extends Shape{
    private double base;
    private double height;
    
    public Triangle(String name, String color, double base, double height){
        super(name, color);
        this.base = base;
        this.height = height;
    }

    public void calcArea(){
        System.out.println("The area of " + getName() + " is " + base*height*0.5 + ".");
        setArea(base*height*0.5);
    }
}

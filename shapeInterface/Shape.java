package shapeInterface;

public abstract class Shape implements Comparable<Shape>{

    private String name;
    private String color;
    private double area;

    public Shape(String name, String color){
        this.name = name;
        this.color = color;
    }

    public int compareTo(Shape x){
        int compare = Double.compare(area, x.area);
        if (compare < 0){
            System.out.println(name + " is smaller than " + x.name);
            return -1;
        }
        else if (compare > 0){
            System.out.println(name + " is larger than "+ x.name);
            return 1;
        }
        System.out.println(name + " has the same area as " + x.name);
        return 0;
    }

    public abstract void calcArea();

    public double getArea(){
        return area;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public void setArea(double area){
        this.area = area;
    }

}

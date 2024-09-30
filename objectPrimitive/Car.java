package objectPrimitive;

public class Car {
    
    private int length;
    private int horsepower;
    private String color; 

    private String[] colors = {"blue", "red", "black", "white", "gray", "purple", "brown", "yellow", "orange"};


    public Car (int carLength, int carHorsepower, String carColor) {
        length = carLength;
        horsepower = carHorsepower;
        color = carColor;
    }

    public Car(){
        length = 15;
        horsepower = 180;
        color = colors[(int) (Math.random() * 9)];
    }

    public String getColor(){
        return color;
    }

    public int getHorsepower(){
        return horsepower;
    }

    public int getLength(){
        return length;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public void setHorsepower(int newHorsepower){
        horsepower = newHorsepower;
    }

    public void setLength(int newLength){
        length = newLength;
    }

    public String toString(){
        return ("The length is " + length + " feet, the horsepower is " + horsepower + ", and the color is " + color + ".");
    }
}
package sortClass;

public class Car implements Comparable<Car>{
    
    private int year;
    public Car(int y){
        year = y;
    }

    public int compareTo(Car c){
        if (year < c.year){
            return -1;
        }
        else if (year > c.year){
            return 1;
        }
        return 0;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int y){
        year = y;
    }
}

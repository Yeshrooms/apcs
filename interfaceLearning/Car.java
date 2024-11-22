package interfaceLearning;

public class Car implements Comparable<Car>{
    
    private int year;
    public Car(int y){
        year = y;
    }

    public int compareTo(Car c){
        if (year < c.year){
            System.out.println("Car 1 is older than car 2");
            return 1;
        }
        else if (year > c.year){
            System.out.println("Car 2 is younger than car 1");
            return -1;
        }
        System.out.println("Both cars are from the same year");
        return 0;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int y){
        year = y;
    }
}

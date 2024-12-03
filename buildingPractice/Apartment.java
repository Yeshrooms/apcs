package buildingPractice;

public class Apartment extends Building {

    private double costPerFloor;
    private double cost;

    public Apartment(String a, int n, double lv, double sq, double cost){
        super(a, n, lv, sq);
        costPerFloor = cost;
    }


    public double calcCost(double x){
        cost = costPerFloor*getFloors() + x;
        setTotalCost(cost);
        return cost;
    }

    public String toString(){
        return ("The total cost of this apartment is " + cost);
    }

}
package buildingPractice;

public class OfficeSpace extends Building {

    private double costPerFloor;
    private double cost;

    public OfficeSpace(String a, int n, double lv, double sq, double cost){
        super(a, n, lv, sq);
        costPerFloor = cost;
    }


    public double calcCost(double x){
        cost = costPerFloor*getFloors() + x + getSqFt()*2.75;
        setTotalCost(cost);
        return cost;
    }

    public String toString(){
        return ("The total cost of this office space is " + cost);
    }
}

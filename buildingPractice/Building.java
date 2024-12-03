package buildingPractice;

public abstract class Building implements Comparable<Building>
{
    private double locationValue, sqft;
    private String address;
    private int numOfFloors = 5; 
    private double marketValue;
    private double totalCost;

    public Building(String a, int n, double lv, double sq)
    {
        address = a;
        numOfFloors = n;
        locationValue = lv;
        sqft = sq;
    }

    public int compareTo(Building b){
        if (totalCost > b.totalCost){
            System.out.println(address + " is worth more than " + b.address);
            return 1;
        }
        else if (totalCost < b.totalCost){
            System.out.println(address + " is worth less than " + b.address);
            return -1;
        }
        System.out.println(address + " is worth the same as " + b.address);
        return 0;
    }

    public double calcMarketValue()
    {
        double mv = locationValue * sqft;
        return mv;
    }

    public abstract double calcCost(double x);

    public int getFloors(){
        return numOfFloors;
    }

    public void setNumFloors(int num){
        numOfFloors = num;
    }

    public double getSqFt(){
        return sqft;
    }

    public void setTotalCost(double cost){
        totalCost = cost;
    }

}



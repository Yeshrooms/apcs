package buildingPractice;

public class test {
    public static void main(String[] args) {
        Building b = new Apartment("5520 Malibu Drive", 5, 350000.0, 3500.0, 15.5);
		
		b.calcCost(12.5);
		
		System.out.println(b.toString());  //  the answer should be 77.5 

        Building o = new OfficeSpace("1 Fineran Way", 10, 350000.0, 1200.0, 20.0);
		
		o.calcCost(12.5);
		
		System.out.println(o.toString());

        b.compareTo(o);
    }
}

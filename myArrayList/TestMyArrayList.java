package myArrayList;

public class TestMyArrayList 
{
	public static void main(String args[]) 
	{
		MyArrayList mya = new MyArrayList(3);
		mya.addToEnd("Enaan");
		mya.addToEnd("Bergen");
		mya.addToEnd("Lorrie");
		mya.addToStart("Jack");
		mya.addToStart("Patricio");

		mya.printAll(); //should print Patricio, Jack, Enaan, Bergen, Lorrie

		System.out.println(mya.getNumElements()); //should print out 5
		
		System.out.println(mya.getSize()); //should print out 6

		System.out.println(mya.getIndexOf("Enaan")); //should return 2

		mya.remove("Enaan"); //should print Removed Succesfully
		mya.remove(1); //should print Element not found


		mya.printAll(); //should print Patricio, Jack, Bergen, Lorrie

		System.out.println(mya.getIndexOf("Enaan")); //should return -1
	}
}
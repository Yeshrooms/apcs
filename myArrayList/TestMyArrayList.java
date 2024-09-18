package myArrayList;

public class TestMyArrayList 
{

	public static void main(String args[]) 
	{
	
		
		System.out.println();
		
		MyArrayList mya = new MyArrayList(1);
		
		
		String s = "Sammy";
		String y = "Joe";
		String z = "Bob";
		
		
		mya.add(s);
		mya.add(y);
		mya.add(z);
		
		System.out.println(mya.get(0));
		System.out.println(mya.get(1));
		System.out.println(mya.get(2));
		System.out.println("The number of elements is " + mya.size());
		
		mya.set(0,"David");
		
		System.out.println(mya.get(0));
		System.out.println(mya.get(1));
		
		
		
		mya.remove(1);
		System.out.println(mya.get(0));
		System.out.println(mya.get(1));
		System.out.println("the number of elements is " + mya.size());	
		
		
		
		Integer i = new Integer(210);
		Double d = new Double(3.14159);
		mya.add(i);
		mya.add(d);

		System.out.println(mya.get(2));
		System.out.println(mya.get(3));
		
		int x = mya.size();
		for(int a = 0; a < x; a++)
		{
			Object t = mya.get(a);
			
			if (t instanceof String)
			{
				System.out.println("we have a String!");
			}
			else if (t instanceof Number)
			{
				System.out.println("we have a Number!");
			}
		}

	}
}
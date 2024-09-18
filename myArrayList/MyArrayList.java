package myArrayList;
// Simulates ARRAYLIST, have students implement this
// to better understand how the java api works

public class MyArrayList
{
    private Object [] list;
    private int numElements;       


    // Constructs the list, initially empty,
    // but can hold up to 100
    public MyArrayList (int size)
    {
    	list = new Object[size];
    	numElements = 0;
    }


    // Adds t to the end of the list
    public void add (Object t)
    {
        if (list[list.length-1] != null){
            Object[] tempList = new Object[list.length*2];
            for (int i = 0; i < list.length; i++){
                tempList[i] = list[i];
            }
            list = tempList;
        }
        list[numElements] = t;
        numElements++;
    }


    // Returns the number of active elements on the list
    public int size ()
    {
        return numElements;
    }


    // Returns the student in the i'th location (counting from 0)
    // Precondition: 0 <= i < size()
    public Object get (int i)
    {
        return list[i];
    }


    // Sets the i'th location in the list to t;
    // returns the previous i'th element.
    public Object set (int i, Object t)
    {
        Object x = list[i];
        list[i] = t; 
        return x;
    }


    // Removes the i'th element, sliding all items beyond i up by one spot.
    // Returns the element removed
    public Object remove (int i)
    {
        Object x = list[i];
        for (int j = i; j < numElements - 1; j++){
            list[j] = list[j+1];
        }
        list[numElements - 1] = null;
        numElements--;
        return x;
    }
}
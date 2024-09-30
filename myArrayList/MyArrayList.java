package myArrayList;


public class MyArrayList
{
    private static Object [] list;
    private static int numElements;
    
    public MyArrayList (){
        list = new Object[100];
        numElements = 0;
    }

    public MyArrayList (int size)
    {
    	list = new Object[size];
    	numElements = 0;
    }


    // Adds t to the end of the list
    public void addToEnd (Object t)
    {
        if (numElements == list.length){
            Object[] tempList = new Object[list.length*2];
            for (int i = 0; i < list.length; i++){
                tempList[i] = list[i];
            }
            list = tempList;
        }
        list[numElements] = t;
        numElements++;
    }

    // Adds t to the end of the list
    public void addToStart (Object t)
    {
        if (numElements == list.length) {
            Object[] tempList = new Object[list.length*2];
            for (int i = 0; i < list.length; i++){
                tempList[i] = list[i];
            }
            list = tempList;
        }
        for (int i = numElements; i > 0; i--){
            list[i] = list[i-1];
        }
        list[0] = t;
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


    public int getSize(){
        return list.length;
    }

    public int getNumElements(){
        return numElements;
    }

    public int getIndexOf(Object numToFind){
        for (int i = 0; i < numElements; i++){
            if (list[i].equals(numToFind)){
                return i;
            }
        }
        return -1;
    }

    public Object remove (Object remove)
    {
        int i = getIndexOf(remove);
        if (i == -1){
            System.out.println("Element not found.");
            return -1;
        }
        for (int j = i; j < numElements - 1; j++){
            list[j] = list[j+1];
        }
        list[numElements - 1] = null;
        numElements--;
        System.out.println("Removed Successfully.");
        return 1;
    }

    public void printAll(){
        System.out.print(list[0]);
        for (int i = 1; i < numElements; i++){
            System.out.print(", " + list[i]);
        }
        System.out.println("");
    }
}
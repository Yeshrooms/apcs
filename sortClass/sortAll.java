package sortClass;

public class sortAll {
    
    public static void bubbleSort(Comparable[] c){
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c.length-i-1; j++){
                if (c[j+1].compareTo(c[j]) < 0){
                    Comparable temp = c[j+1];
                    c[j+1] =  c[j];
                    c[j] = temp;
                }
            }
        }
    }
}
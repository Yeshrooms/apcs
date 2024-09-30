package objectPrimitive;

public class PrimitveArray {

    public static void functionY(int[] y){
        y = new int[5];
        for (int i = 0; i < 5; i++){
            y[i] = (int) (Math.random()*50)+1;
        }
    }

    public static void functionX(int[] x){
        int numberOfChanged = (int) Math.random()*50 + 1;
        for (int i = 0; i < numberOfChanged; i++){
             int index = (int) (Math.random()*x.length);
             x[index] = (int) (Math.random()*50)+1;
        }
     }
    public static void main(String[] args) {

        int length = (int) (Math.random()*50) + 1;
		int[] primitiveArray = new int[length];
        for (int i = 0; i < length; i++){
            primitiveArray[i] = (int) (Math.random()*50) + 1;
            System.out.println(primitiveArray[i]);
        }
        
        System.out.println("\n\nFunctionX Array: ");

        functionX(primitiveArray);

        for (int i = 0; i < length; i++){
            System.out.println(primitiveArray[i]);
        }


        // The elements WERE modified
        // primitiveArray is a pointer to array
        // then, x equals that pointer as well
        // so, when you change the values in the x array using functionX, 
        // even though the actual 'array' x dies in the method
        // , x still changed the values that primitiveArray pointed to

        // System.out.println("\n\nFunctionY Array: ");

        // functionY(primitiveArray);

        // for (int i = 0; i < length; i++){
        //     System.out.println(primitiveArray[i]);
        // }

        // The elements were NOT modified
        // Unlike functionX, int[] y now points to a different area than primitiveArray
        // so when it modifies elements, it modifies different elements than primitiveArray points to
    }
}


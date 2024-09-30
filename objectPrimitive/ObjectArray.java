package objectPrimitive;

public class ObjectArray {

    private static String[] colors = {"blue", "red", "black", "white", "gray", "purple", "brown", "yellow", "orange"};

    public static void functionX(Car[] x){
        for (int i = 0; i < 5; i++){
            if (Math.random() > 0.5){
                int length = (int) (Math.random() * 6) + 10;
                int horsepower = (int) (Math.random() * 60) + 140;
                String color = colors[(int) (Math.random() * 9)];
                x[i] = new Car(length, horsepower, color);
            }
            System.out.println(x[i]);
        }
     }


    public static void main(String[] args) {
		Car[] carArray = new Car[5];
        for (int i = 0; i < 5; i++){
            int length = (int) (Math.random() * 6) + 10;
            int horsepower = (int) (Math.random() * 60) + 140;
            String color = colors[(int) (Math.random() * 9)];
            carArray[i] = new Car(length, horsepower, color);

            System.out.println(carArray[i]);
        }

        System.out.println("\n\nFunctionX Array: ");

        functionX(carArray);

    }
}

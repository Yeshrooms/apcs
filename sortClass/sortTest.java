package sortClass;

public class sortTest {
    public static void main(String[] args) {
        Car[] carArray = new Car[5];
        carArray[0] = new Car(2000);
        carArray[1] = new Car(1995);
        carArray[2] = new Car(2017);
        carArray[3] = new Car(2015);
        carArray[4] = new Car(2014);

        String[] stringArray = new String[5];
        stringArray[0] = new String("happy");
        stringArray[1] = new String("sad");
        stringArray[2] = new String("angry");
        stringArray[3] = new String("mangry");
        stringArray[4] = new String("foo");

        System.out.println("\n Cars:");

        for (Car c : carArray){
            System.out.println(c.getYear());
        }

        System.out.println("\n Cars sorted:");

        sortAll.bubbleSort(carArray);
        for (Car c : carArray){
            System.out.println(c.getYear());
        }

        System.out.println("\n Strings:");

        for (String s : stringArray){
            System.out.println(s);
        }

        System.out.println("\n Strings sorted:");

        sortAll.bubbleSort(stringArray);

        for (String s : stringArray){
            System.out.println(s);
        }
    }
}
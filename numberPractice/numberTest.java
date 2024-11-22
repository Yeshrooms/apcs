package numberPractice;

import java.util.HashMap;

public class numberTest {
    public static void main(String[] args) {
        // Number test = new Number();
        // Errors - it is an abstract class
        
        int intCounter = 0;
        int doubleCounter = 0;

        HashMap<Integer, Integer> frequencies = new HashMap<>();

        // Create new array of Integers and Doubles
        Number[] numberArray = new Number[10000];

        for (int i = 0; i < 10000; i++){
            if (Math.random() > 0.5){
                double number = Math.random()*18 + 2;
                numberArray[i] = Double.valueOf(number);
                doubleCounter++;
                Integer newInt = (int)number;
                frequencies.put((newInt), frequencies.getOrDefault(newInt, 0) + 1);
            } else{
                double intNumber = Math.random()*19 + 2;
                numberArray[i] = Integer.valueOf((int)intNumber);
                intCounter++;
                frequencies.put((int)intNumber, frequencies.getOrDefault((int)intNumber, 0) + 1);
            }
            System.out.println(numberArray[i]);
        }

        // Sort sort sort
        for (int i = 0; i < 10000; i++){
            for (int j = 0; j < 10000-i-1; j++){
                if (numberArray[j+1].doubleValue() - (numberArray[j].doubleValue()) < 0){
                    Number temp = numberArray[j+1];
                    numberArray[j+1] =  numberArray[j];
                    numberArray[j] = temp;
                }
            }
        }

        for (int i = 0; i < 10000; i++){
            System.out.println(numberArray[i]);
        }

        System.out.println("Number of ints: " + intCounter);
        System.out.println("Number of doubles: " + doubleCounter);

        for (Integer frequent : frequencies.keySet()) {
            System.out.println(frequent + " appears " + frequencies.get(frequent) + " times.");
        }
    }
}
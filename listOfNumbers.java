import java.util.*;

public class listOfNumbers
{
	public static void main(String args[]) 
	{
	    Scanner numberOfNumbers = new Scanner(System.in);
        System.out.println("How many numbers would you like to generate? ");
        String numberString = numberOfNumbers.nextLine();
        numberOfNumbers.close();
        int number = Integer.parseInt(numberString);
        int largest = 21;
        int smallest = 0;
        int frequent = 0;
        Random randomizer = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> mostFrequent = new ArrayList<>();
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();
            
        for (int i = 0; i < number; i++) {
            int random = randomizer.nextInt(1, 21);
            if (i == 0) {
                smallest = random;
                largest = random;
                frequent = random;
                mostFrequent.add(random);
            }
            if (random < smallest) {
                smallest = random;
            }
            if (random > largest) {
                largest = random;
            }
            numbers.add(random);
            numberFrequency.put(random, numberFrequency.getOrDefault(random, 0)+1);
            if (numberFrequency.get(random) > numberFrequency.get(frequent)) {
                mostFrequent.clear();
                mostFrequent.add(random);
                frequent = random;
            }
            if (numberFrequency.get(random) == numberFrequency.get(frequent) && random!=frequent) {
                mostFrequent.add(random);
            }
            System.out.println(random);
        }
            
        System.out.println("The largest number is " + largest);
        System.out.println("The smallest number is " + smallest);
        System.out.println("The most frequent number/(s) is/are: ");

        for (int i = 0; i < mostFrequent.size(); i++) {
            System.out.println(mostFrequent.get(i));
        }
        System.out.println("with a frequency/frequencies of " + numberFrequency.get(frequent) + ".");
            
    }
}

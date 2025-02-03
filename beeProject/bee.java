package beeProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bee {
    public static void main(String[] args) throws FileNotFoundException {
        File testFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/beeProject/test2.txt");
        Scanner testScan = new Scanner(testFile);

        int length = Integer.parseInt(testScan.nextLine());

        int total = 0;

        beeAStar test = new beeAStar(length);

        Triple[] hive = new Triple[15];

        for (int i = 0; i < 15; i++){
            String input = testScan.nextLine();
            String[] numbers = input.split(",");
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            int num3 = Integer.parseInt(numbers[2].trim());
            hive[i] = new Triple(num1, num2, num3);
        }

        Triple[] bees = new Triple[15];

        for (int i = 0; i < 15; i++){
            String input = testScan.nextLine();
            String[] numbers = input.split(",");
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            int num3 = Integer.parseInt(numbers[2].trim());
            bees[i] = new Triple(num1, num2, num3);
        }

        testScan.nextLine();

        while(testScan.hasNextLine()){
            String input = testScan.nextLine();
            String[] numbers = input.split(",");
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            int num3 = Integer.parseInt(numbers[2].trim());
            test.addDebris(num1, num2, num3);
        }

        for (int i = 0; i < 15; i++){
            int distance = test.travel(bees[i].x,bees[i].y,bees[i].z,hive[i].x,hive[i].y,hive[i].z);
            total += distance;
        }

        System.out.println(total);
    }
}

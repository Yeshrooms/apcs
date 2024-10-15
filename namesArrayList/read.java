package namesArrayList;

import java.util.*;
import java.io.*;

public class read {

    public static boolean has(ArrayList<String> words, String string){
        for (int i = 0; i < words.size(); i++){
            if (words.get(i).equals(string)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {   

        //setting up the file I'm gonna read my words into
        String[] names = {"Daniel", "Patricio", "Enaan", "Jack", "Lorrie", "Bergen"};

        try{ //write each word from the hashmap into the txt file
            FileWriter poeWriter = new FileWriter("/Users/yeshrooms/Documents/GitHub/apcs/namesArrayList/readNames.txt");
            for (int i = 0; i < 1000; i++){
                poeWriter.write(names[(int) ((Math.random()) * 5)] + "\n");
            }
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }

        ArrayList<String> words = new ArrayList<String>();
        File poeFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/namesArrayList/readNames.txt");

        Scanner poeScan = new Scanner(poeFile);

        while (poeScan.hasNext()){
            String cur = poeScan.next();
            Scanner curScan = new Scanner(cur);
            String word = curScan.next();
            curScan.close();

            if (has(words, word) == false){ //if the arraylist already has the word, update the value
                words.add(word);
                System.out.println(word);
            }
        }

        poeScan.close();

        for (int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
}

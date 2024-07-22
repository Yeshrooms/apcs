package POE;

import java.util.*;
import java.io.*;

public class poe {
    public static void main(String[] args) throws FileNotFoundException {   
        File poeFile = new File("/Users/yeshrooms/apcs/POE/poe.txt");
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        Scanner poeScan = new Scanner(poeFile);
        File poeFixed = new File("/Users/yeshrooms/apcs/POE/poeNoPunctuation.txt");
        try{
            poeFixed.createNewFile();
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }
        while (poeScan.hasNext()){
            String temp = poeScan.next();
            temp = temp.replaceAll("\\p{Punct}", " ");
            temp = temp.toLowerCase();
            Scanner tempScan = new Scanner(temp);
            String word = tempScan.next();
            tempScan.close();

            if (wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word) + 1);
            }
            else{
                wordCount.put(word, 1);
            }
        }
        try{
            FileWriter poeWriter = new FileWriter("/Users/yeshrooms/apcs/POE/poeNoPunctuation.txt");
            for (HashMap.Entry<String, Integer> entry : wordCount.entrySet()){
                String wordKey = entry.getKey();
                Integer numTimes = entry.getValue();
                poeWriter.write(wordKey + " appears " + numTimes + " times. \n");
            }
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }
        poeScan.close();
        
    }
}
package POE;

import java.util.*;
import java.io.*;

public class poe {
    public static void main(String[] args) throws FileNotFoundException {   
        File poeFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poe.txt");
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        Scanner poeScan = new Scanner(poeFile);
        File poeFixed = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
        ArrayList<String> bubbleArrayList = new ArrayList<String>();
        String mostFrequentWord = "";
        int frequency = 0;
        int counter = 0;
        try{
            poeFixed.createNewFile();
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }
        while (poeScan.hasNext()){
            String cur = poeScan.next();
            cur = cur.replaceAll("\\p{Punct}", "");
            cur = cur.toLowerCase();
            Scanner curScan = new Scanner(cur);
            String word = curScan.next();
            curScan.close();

            if (wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word) + 1);
                if (wordCount.get(word) > frequency){
                    frequency = wordCount.get(word);
                    mostFrequentWord = word;
                }
                counter++;
            }
            else{
                wordCount.put(word, 1);
                bubbleArrayList.add(word);
                counter++;
            }
        }

        try{
            FileWriter poeWriter = new FileWriter("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
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
        
        System.out.println("Number of unique words: " + wordCount.size());
        System.out.println("Number of words: " + counter);
        System.out.println("The most frequent word is \"" + mostFrequentWord + "\" and it appears " + frequency + " number of times.");

        Scanner wordSearcher = new Scanner(System.in);
        System.out.println("Enter word to search ");
        String searchWord = wordSearcher.nextLine();
        double startTime = System.nanoTime();
        if (wordCount.containsKey(searchWord)){
            int wordFrequency = wordCount.get(searchWord);
            System.out.println("\"" + searchWord + "\" appears " + wordFrequency + " number of times.");
        }
        else{
            System.out.println("Word Not Found");
        }
        double endTime = System.nanoTime();
        System.out.println("Start time is " + startTime + " nanoseconds and end time is " + endTime + " nanoseconds");
        System.out.println("Elasped time is " + (endTime - startTime) + " nanoseconds");

        System.out.println("======================================================");
        System.out.println("BUBBLE SORT");

        for (int i = 0; i < bubbleArrayList.size(); i++){
            for (int j = 0; j < bubbleArrayList.size()-i; j++){

            }
        }
    }
}
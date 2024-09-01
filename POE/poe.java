package POE;

import java.util.*;
import java.io.*;

public class poe {

    //method for sequential search 
    public static int sequentialSearch(String word, wordOccurences[] wordList){
        for (int i = 0; i < wordList.length; i++){
            if (word.compareTo(wordList[i].getWord()) == 0){
                return wordList[i].getOccurences();
            }
        }
        return -1;
    }
    //method for binary search
    public static int binarySearch(String word, wordOccurences[] wordList, int start, int end) {
        if (start > end){ //base case to see if word isn't there
            return -1;
        }
        int mid = start + (end - start) / 2; // find middle
        String midWord = wordList[mid].getWord();
        int comparison = word.compareTo(midWord); // compare the word we're looking for with the middle word
        if (comparison == 0){ //if middle word is the word, return the number of times it appears
            return wordList[mid].getOccurences();
        } 
        else if (comparison < 0){ //if the word is sorted below, search again, but with end value as middle-1
            return binarySearch(word, wordList, start, mid - 1);
        } 
        else{ //if the word is sorted above, search again, but with start value as middle+1
            return binarySearch(word, wordList, mid + 1, end);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {   
        File poeFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poe.txt");
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        Scanner poeScan = new Scanner(poeFile);
        File poeFixed = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
        ArrayList<String> bubbleArrayList = new ArrayList<String>();
        String mostFrequentWord = "";
        int frequency = 0;
        int counter = 0;
        int unique = 0;
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
            bubbleArrayList.add(word);

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
                counter++;
                unique++;
            }
        }



        wordOccurences[] searchedList = new wordOccurences[unique];
        int x = 0;

        Object[] bubbleArray = bubbleArrayList.toArray();

        try{
            FileWriter poeWriter = new FileWriter("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
            for (HashMap.Entry<String, Integer> entry : wordCount.entrySet()){
                String wordKey = entry.getKey();
                Integer numTimes = entry.getValue();
                wordOccurences word = new wordOccurences(wordKey, numTimes);
                searchedList[x] = word;
                poeWriter.write(wordKey + " appears " + numTimes + " times. \n");
                x++;
            }
        }

        catch(IOException ex){
            System.out.println("IOexception");
        }
        poeScan.close();


        for (int i = 0; i < searchedList.length; i++){
            for (int j = 0; j < searchedList.length-i-1; j++){
                if (searchedList[j+1].getWord().compareTo(searchedList[j].getWord()) < 0){
                    String temp = searchedList[j+1].getWord();
                    int occurencesTemp = searchedList[j+1].getOccurences();
                    searchedList[j+1].setWord(searchedList[j].getWord());
                    searchedList[j+1].setOccurences(searchedList[j].getOccurences());
                    searchedList[j].setWord(temp);
                    searchedList[j].setOccurences(occurencesTemp);
                }
            }
        }
        
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

        long bubbleSortStartTime = System.nanoTime();

        for (int i = 0; i < bubbleArrayList.size(); i++){
            for (int j = 0; j < bubbleArrayList.size()-i-1; j++){
                if (bubbleArrayList.get(j+1).compareTo(bubbleArrayList.get(j)) < 0){
                    String temp = bubbleArrayList.get(j+1);
                    bubbleArrayList.set(j+1, bubbleArrayList.get(j));
                    bubbleArrayList.set(j, temp);
                }
            }
        }

        long bubbleSortEndTime = System.nanoTime();
        System.out.println("Start time for bubble sort is " + bubbleSortStartTime +
        " nanoseconds and end time is " + bubbleSortEndTime + " nanoseconds");
        System.out.println("Elasped time for bubble sort is " + (bubbleSortEndTime - bubbleSortStartTime) + " nanoseconds");

        System.out.println("======================================================");
        System.out.println("ARRAYS.SORT");
        long arraySortStartTime = System.nanoTime();
    
        Arrays.sort(bubbleArray);
        long arraySortEndTime = System.nanoTime();

        System.out.println("Start time for array sort is " + arraySortStartTime +
        " nanoseconds and end time is " + arraySortEndTime + " nanoseconds");
        System.out.println("Elasped time for array sort is " + (arraySortEndTime - arraySortStartTime) + " nanoseconds");


        //binary search
        Scanner binaryWordSearcher = new Scanner(System.in);
        System.out.println("Enter word to search ");
        String binarySearchWord = binaryWordSearcher.nextLine();
        int binaryOccurences = binarySearch(binarySearchWord, searchedList, 0, searchedList.length-1);
        if (binaryOccurences != -1){
            System.out.println(binarySearchWord + " appears " + binaryOccurences + " number of times.");
        }
        else{
            System.out.println("Word not found.");
        }

        int sequentialOccurences = sequentialSearch(binarySearchWord, searchedList);
        if (sequentialOccurences != -1){
            System.out.println(binarySearchWord + " appears " + sequentialOccurences + " number of times.");
        }
        else{
            System.out.println("Word not found.");
        }

    }
}
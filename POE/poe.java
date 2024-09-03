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


    //main 
    public static void main(String[] args) throws FileNotFoundException {   
        //setting up the file I'm gonaa read from
        File poeFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poe.txt");
        Scanner poeScan = new Scanner(poeFile);
        //setting up the file I'm gonna read my words into
        File poeFixed = new File("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
        //hashmap to store frequncy of words paired to each word (only for the first part)
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        //just making the arrayList that I'll be bubble sorting later on for the second part
        ArrayList<String> bubbleArrayList = new ArrayList<String>();
        String mostFrequentWord = ""; 
        int frequency = 0;
        int counter = 0; //keeps track of total words
        int unique = 0; //keeps track of unique words
        try{ // create the file to read into
            poeFixed.createNewFile();
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }

        while (poeScan.hasNext()){
            String cur = poeScan.next();
            cur = cur.replaceAll("\\p{Punct}", ""); // get rid of punctuation
            cur = cur.toLowerCase(); 
            Scanner curScan = new Scanner(cur);
            String word = curScan.next();
            curScan.close();
            bubbleArrayList.add(word); //adding the word to the arraylist that I'll bubble sort later

            if (wordCount.containsKey(word)){ //if the hashmap already has the word, update the value
                wordCount.put(word, wordCount.get(word) + 1);
                if (wordCount.get(word) > frequency){
                    frequency = wordCount.get(word);
                    mostFrequentWord = word;
                }
                counter++;
            }
            else{ //if the hashmap doesn't have the word, put it in
                wordCount.put(word, 1);
                counter++;
                unique++;
            }
        }
        //turned the bubble arrayList into an array because the assignemtn says to bubble sort an array
        //array list was only because I wanted to input the values at the same time I was reading them
        //so I didn't know how many words there would be
        Object[] bubbleArray = bubbleArrayList.toArray();

        //making the array of words that I'll binary sort 
        //array is of object wordOccurences (stores word and occurence associated)
        wordOccurences[] searchedList = new wordOccurences[unique];
        int x = 0;

        try{ //write each word from the hashmap into the txt file
            FileWriter poeWriter = new FileWriter("/Users/yeshrooms/Documents/GitHub/apcs/POE/poeWords.txt");
            for (HashMap.Entry<String, Integer> entry : wordCount.entrySet()){
                String wordKey = entry.getKey();
                Integer numTimes = entry.getValue();
                wordOccurences word = new wordOccurences(wordKey, numTimes);
                //setting up the array used for binary sorting
                searchedList[x] = word;
                x++;
                poeWriter.write(wordKey + " appears " + numTimes + " times. \n");
            }
        }
        catch(IOException ex){
            System.out.println("IOexception");
        }
        poeScan.close();

        //create a separate, unsorted array, to use for sequential searching later
        wordOccurences[] sequentialArray = searchedList;

        //because my array for binary sorting is of an object wordOccurences, I can't just use .sort() on it
        //so, I just bubble sort it in order to make sure its sorted
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

        //doing word search for the first part with the hashmap
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

        //Starting part 2 

        System.out.println("======================================================");
        System.out.println("BUBBLE SORT");

        long bubbleSortStartTime = System.nanoTime();

        //bubble sorts the array list
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
        long bubbleTotal = bubbleSortEndTime-bubbleSortStartTime;
        System.out.println("Start time for bubble sort is " + bubbleSortStartTime +
        " nanoseconds and end time is " + bubbleSortEndTime + " nanoseconds");
        System.out.println("Elasped time for bubble sort is " + (bubbleSortEndTime - bubbleSortStartTime) + " nanoseconds");

        System.out.println("======================================================");
        System.out.println("ARRAYS.SORT");
        long arraySortStartTime = System.nanoTime();
        //uses arrays.sort and compares the times
        Arrays.sort(bubbleArray);
        long arraySortEndTime = System.nanoTime();
        long arrayTotal = arraySortEndTime-arraySortStartTime;
        System.out.println("Start time for array sort is " + arraySortStartTime +
        " nanoseconds and end time is " + arraySortEndTime + " nanoseconds");
        System.out.println("Elasped time for array sort is " + (arraySortEndTime - arraySortStartTime) + " nanoseconds");

        if (bubbleTotal > arrayTotal){
            System.out.println("When sorting, bubble sorting was faster.");
        }
        if (bubbleTotal < arrayTotal){
            System.out.println("When sorting, arrays.sort() was faster.");
        }
        if (bubbleTotal == arrayTotal){
            System.out.println("When sorting, the methods tied.");
        }

        System.out.println("======================================================");
        System.out.println("BINARY SEARCH");

        //binary search
        Scanner binaryWordSearcher = new Scanner(System.in);
        System.out.println("Enter word to search "); //getting word to search for
        String binarySearchWord = binaryWordSearcher.nextLine();
        long binarySearchStart = System.nanoTime();
        int binaryOccurences = binarySearch(binarySearchWord, searchedList, 0, searchedList.length-1);
        long binarySearchEnd = System.nanoTime();
        long binaryTotal = binarySearchEnd-binarySearchStart;
        if (binaryOccurences != -1){ //-1 means the word wasn't found
            System.out.println(binarySearchWord + " appears " + binaryOccurences + " number of times.");
        }
        else{
            System.out.println("Word not found.");
        }
        System.out.println("Start time was " + binarySearchStart + " nanoseconds and end time was " + binarySearchEnd + " nanoseconds.");
        System.out.println("Total time elapsed was " + binaryTotal);

        System.out.println("======================================================");
        System.out.println("SEQUENTIAL SEARCH");

        long sequentialSearchStart = System.nanoTime();
        int sequentialOccurences = sequentialSearch(binarySearchWord, sequentialArray);
        long sequentialSearchEnd = System.nanoTime();
        long sequentialTotal = sequentialSearchEnd-sequentialSearchStart;
        if (sequentialOccurences != -1){ 
            System.out.println(binarySearchWord + " appears " + sequentialOccurences + " number of times.");
        }
        else{
            System.out.println("Word not found.");
        }
        System.out.println("Start time was " + sequentialSearchStart + " nanoseconds and end time was " + sequentialSearchEnd + " nanoseconds.");
        System.out.println("Total time elapsed was " + sequentialTotal);

        if (sequentialTotal > binaryTotal){
            System.out.println("When searching the word " + binarySearchWord + ", sequential search was more efficent.");
        }
        if (sequentialTotal < binaryTotal){
            System.out.println("When searching the word " + binarySearchWord + ", binary search was more efficent.");
        }
        if(sequentialTotal == binaryTotal){
            System.out.println("When searching the word " + binarySearchWord + ", both searches tied.");
        }
    }
}
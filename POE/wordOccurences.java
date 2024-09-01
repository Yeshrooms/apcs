package POE;

public class wordOccurences {

    public int occurences;
    public String word;

    public wordOccurences(String word1, int occurences1){
        word = word1;
        occurences = occurences1;
    }

    public void setOccurences(int newOccurences){
        occurences = newOccurences;
    }

    public int getOccurences(){
        return occurences;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String newWord){
        word = newWord;
    }

    public String toString(){
        return(word + " " + occurences);
    }
}
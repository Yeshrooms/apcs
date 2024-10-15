package parallelArrays;

public class Student {
    
    private int score;
    private String name; 

    public Student (int studentScore, String studentName) {
        score = studentScore;
        name = studentName;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return (name + " has a score of " + score);
    }
}
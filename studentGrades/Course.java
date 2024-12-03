package studentGrades;

public class Course {

    private String courseName;
    private double courseGrade; 
    private String letterGrade;



    public Course(String name, double grade){
        courseName = name;
        courseGrade = grade;

        if (grade > 90){
            letterGrade = "A";
        }
        else if (grade > 80){
            letterGrade = "B";
        }
        else if (grade > 70){
            letterGrade = "C";
        }
        else if (grade > 60){
            letterGrade = "D";
        }
        else{
            letterGrade = "F";
        }
    }

    public String getCourseName(){
        return courseName;
    }

    public double getGrade(){
        return courseGrade;
    }

    public String getLetter(){
        return letterGrade;
    }

}

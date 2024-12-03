package studentGrades;

import java.util.ArrayList;

public class Student {

    private String lastName;
    private String firstName;
    private String SSN;
    private int year;
    private double averageGrade = 0.0;
    private double totalGrade = 0.0;
    ArrayList<Course> studentCourses = new ArrayList<Course>();

    public Student(String lastNamex, String firstNamex, String SSNx, int yearx, String coursex, double gradex){
        lastName = lastNamex;
        firstName = firstNamex;
        SSN = SSNx;
        year = yearx;
        studentCourses.add(new Course(coursex, gradex));
        totalGrade+=gradex;
        averageGrade = totalGrade/studentCourses.size();
    }

    public void addCourse(String coursex, double gradex){
        studentCourses.add(new Course(coursex, gradex));
        totalGrade+=gradex;
        averageGrade = totalGrade/studentCourses.size();
    }

    public double averageGrade(){
        return averageGrade;
    }

    public String getLetter(){
        if (averageGrade > 90){
            return "A";
        }
        else if (averageGrade > 80){
            return "B";
        }
        else if (averageGrade > 70){
            return "C";
        }
        else if (averageGrade > 60){
            return "D";
        }
        else{
            return "F";
        }
    }

    public String getLastName(){
        return lastName;
    }

    public String getSSN(){
        return SSN;
    }

    public String toString(){
        return (firstName + " " + lastName + " is in " + year + "th grade, and has " + studentCourses.size() + " courses, with an average letter grade of " + getLetter());
    }
}
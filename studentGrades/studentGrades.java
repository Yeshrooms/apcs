package studentGrades;
import java.util.*;
import java.io.*;

public class studentGrades {
    public static void main(String[] args) throws FileNotFoundException{
        File gradesFile = new File("/Users/yeshrooms/Documents/GitHub/apcs/studentGrades/studentGrades.txt");
        Scanner gradeScan = new Scanner(gradesFile);

        ArrayList<Student> studentList = new ArrayList<Student>();

        String numOfStudents = gradeScan.next();
        String numOfClasses = gradeScan.next();
        int numStudents = Integer.parseInt(numOfStudents);
        int numClasses = Integer.parseInt(numOfClasses);

        for (int i = 0; i < numStudents; i++){
            String lastName = gradeScan.next();
            String firstName = gradeScan.next();
            String SSNstring = gradeScan.next();
            String yearString = gradeScan.next();
            int year = Integer.parseInt(yearString);
            String course = gradeScan.next();
            String gradeString = gradeScan.next();
            int gradeInt = Integer.parseInt(gradeString);
            double grade = (double)gradeInt;
            Student newStudent = new Student(lastName, firstName, SSNstring, year, course, grade);
            for (int j = 0; j < numClasses-1; j++){
                gradeScan.next();
                gradeScan.next();
                gradeScan.next();
                gradeScan.next();
                String coursex = gradeScan.next();
                String gradeStringx = gradeScan.next();
                int gradeIntx = Integer.parseInt(gradeStringx);
                double gradex = (double)gradeIntx;
                newStudent.addCourse(coursex, gradex);
            }
            studentList.add(newStudent);
        }

        for (int i = 0; i < 3; i++){
            System.out.println(studentList.get(i));
        }

        gradeScan.close();
    }
}
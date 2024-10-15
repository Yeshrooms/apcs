package parallelArrays;

import java.util.ArrayList;

public class parallelArrayMain {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>(10);
        students.add(new Student(100, "Sally"));
        students.add(new Student(95, "Joe"));
        students.add(new Student(97, "Bob"));
        students.add(new Student(98, "Becky"));
        students.add(new Student(89, "Ezikiel"));
        students.add(new Student(98, "Harry"));
        students.add(new Student(100, "Kumar"));
        for (int i = 0; i < 7; i++){
            System.out.println(students.get(i));
        }
        //alphabetcially sort
        for (int i = 0; i < students.size(); i++){
            for (int j = 0; j < students.size()-i-1; j++){
                if (students.get(j+1).getName().compareTo(students.get(j).getName()) < 0){
                    Student temp = students.get(j+1);
                    students.set(j+1, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        System.out.println("\n");
        for (int i = 0; i < 7; i++){
            System.out.println(students.get(i));
        }

    }
}
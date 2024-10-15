package classBasics;

public class Employee {

    private String name;
    private int age;
    private int wage;
    
    public Employee(String employeeName, int employeeAge, int employeeWage){
        name = employeeName;
        age = employeeAge;
        wage = employeeWage;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getWage(){
        return wage;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public void setWage(int newWage){
        wage = newWage;
    }

    public String toString(){
        return ("Employee " + name + " is " + age + " years old and has a wage of " + wage + " dollars per hour.");
    }
}

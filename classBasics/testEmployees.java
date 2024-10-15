package classBasics;

public class testEmployees {
    public static void main(String[] args) {
        String[] names = {"Patricio", "Enaan", "Lorrie"};
    
        Employee[] company = new Employee[3];

        for (int i = 0; i < 3; i++){
            company[i] = new Employee(names[i], (int) (Math.random() * 15 + 15), (int) (Math.random() * 13 + 16));
            System.out.println(company[i]);
        }
    }


}
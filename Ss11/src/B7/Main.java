package B7;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new PartTimeEmployee("Alice", 100, 5);
        Employee emp2 = new FullTimeEmployee("Bob", 150);

        System.out.println(emp1.getName() + " - Salary: " + emp1.calculateSalary());
        System.out.println(emp2.getName() + " - Salary: " + emp2.calculateSalary());
    }
}

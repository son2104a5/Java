package B10;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Employee manager = new Manager("Alice", 8000);
        Employee developer = new Developer("Bob", 5000);

        company.addEmployee(manager);
        company.addEmployee(developer);

        company.organizeWork();
        company.organizeVacation();
        company.organizeMeeting();
    }
}

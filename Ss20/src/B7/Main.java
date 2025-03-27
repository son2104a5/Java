package B7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Quý", 26, "IT", 2500),
            new Employee("Lan", 24, "IT", 2100),
            new Employee("Minh", 30, "HR", 3000),
            new Employee("Huyền", 28, "IT", 2000),
            new Employee("Long", 32, "IT", 3100),
            new Employee("Trang", 25, "Marketing", 2200),
            new Employee("Việt", 27, "IT", 2500)
        );

        List<Employee> filteredEmployee = new ArrayList<>();
        for (Employee e: employees) {
            if (e.getSalary() > 2000 && e.getAge() > 25 && "IT".equals(e.getDepartment())) {
                filteredEmployee.add(e);
            }
        }
        filteredEmployee.sort(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Comparator.comparing(Employee::getName)));

        filteredEmployee.forEach(System.out::println);
    }
}

package B10;

public class Company {
    private Employee[] employees;
    private int count;

    public Company() {
        employees = new Employee[10];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Đã thêm nhân viên: " + emp.name);
        } else {
            System.out.println("Công ty đã đủ số lượng nhân viên.");
        }
    }

    public void organizeWork() {
        System.out.println("\n--- Hoạt động làm việc ---");
        for (int i = 0; i < count; i++) {
            employees[i].work();
        }
    }

    public void organizeVacation() {
        System.out.println("\n--- Kỳ nghỉ của nhân viên ---");
        for (int i = 0; i < count; i++) {
            employees[i].takeVacation();
        }
    }

    public void organizeMeeting() {
        System.out.println("\n--- Cuộc họp công ty ---");
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof AttendMeeting) {
                ((AttendMeeting) employees[i]).attendMeeting();
            } else {
                System.out.println(employees[i].name + " không tham gia cuộc họp.");
            }
        }
    }
}

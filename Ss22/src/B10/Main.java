package B10;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student(101, "Nguyễn Văn A", "CNTT", 3.8));
        manager.addStudent(new Student(102, "Trần Thị B", "Kế toán", 3.6));
        manager.addStudent(new Student(103, "Lê Văn C", "CNTT", 3.9));
        manager.addStudent(new Student(104, "Phạm Minh D", "Quản trị", 3.2));

        manager.displayAllStudents();

        Student topStudent = manager.findTopStudent();
        if (topStudent != null) {
            System.out.println("\nSinh viên có GPA cao nhất:");
            System.out.println(topStudent);
        }

        System.out.println("\nDanh sách sinh viên thuộc chuyên ngành CNTT:");
        for (Student student : manager.searchByMajor("CNTT")) {
            System.out.println(student);
        }

        System.out.printf("\nĐiểm GPA trung bình của tất cả sinh viên: %.2f\n", manager.calculateAverageGpa());

        manager.saveToFile();
    }
}

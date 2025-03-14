package B7;

public class TestStudentManagement {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Nguyễn Văn A", "SV001", 3.5);
        students[1] = new GraduateStudent("Trần Thị B", "SV002", 3.8, "Machine Learning", "GS. Lê Văn C");
        students[2] = new GraduateStudent("Lê Văn D", "SV003", 3.9, "Data Science", "GS. Nguyễn Thị E");

        for (Student s : students) {
            System.out.println(s.getDetails());
        }
    }
}


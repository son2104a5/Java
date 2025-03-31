package B4;

public class Main {
    public static void main(String[] args) {
        String fileName = "B4/student.dat";

        Student student = new Student("Nguyễn Văn A", 20, 8.5);

        StudentFileHandler.writeStudentToFile(student, fileName);

        Student readStudent = StudentFileHandler.readStudentFromFile(fileName);

        if (readStudent != null) {
            readStudent.displayInfo();
        }
    }
}

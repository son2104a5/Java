package B10;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;
    private final String fileName = "students.dat";

    public StudentManager() {
        studentList = FileHandler.readStudentsFromFile(fileName);
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
    }

    public void addStudent(Student student) {
        studentList.add(student);
        FileHandler.writeStudentsToFile(fileName, studentList);
    }

    public void saveToFile() {
        FileHandler.writeStudentsToFile(fileName, studentList);
    }

    public void loadFromFile() {
        studentList = FileHandler.readStudentsFromFile(fileName);
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) return null;
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public List<Student> searchByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }

    public double calculateAverageGpa() {
        if (studentList.isEmpty()) return 0;
        double sum = 0;
        for (Student student : studentList) {
            sum += student.getGpa();
        }
        return sum / studentList.size();
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\nKhông có sinh viên nào trong danh sách.");
        } else {
            System.out.println("\nDanh sách sinh viên:");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}

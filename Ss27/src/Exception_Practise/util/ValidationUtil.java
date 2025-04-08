package Exception_Practise.util;

import Exception_Practise.entity.ClassRoom;
import Exception_Practise.entity.Course;
import Exception_Practise.entity.Person;
import Exception_Practise.entity.Student;

import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static boolean isValidCourseId(String courseId, List<Course> courses) {
        if (courseId == null || !courseId.matches("^C\\w{4}$")) {
            return false;
        }
        return courses.stream().noneMatch(course -> course.getCourseId().equals(courseId));
    }

    public static boolean isValidCourseName(String courseName, List<Course> courses) {
        if (courseName == null || courseName.length() < 20 || courseName.length() > 100) {
            return false;
        }
        return courses.stream().noneMatch(course -> course.getCourseName().equals(courseName));
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() <= 150 && !name.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        return age >= 18;
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone, List<Person> persons) {
        if (phone == null || !phone.matches("^(03|05|07|08|09)\\d{8}$")) {
            return false;
        }
        return persons.stream().noneMatch(person -> person.getPhone().equals(phone));
    }

    public static boolean isValidEmail(String email, List<Person> persons) {
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            return false;
        }
        return persons.stream().noneMatch(person -> person.getEmail().equals(email));
    }

    public static boolean isValidStudentId(String studentId, List<Student> students) {
        if (studentId == null || !studentId.matches("^SV\\w{3}$")) {
            return false;
        }
        return students.stream().noneMatch(student -> student.getStudentId().equals(studentId));
    }

    public static boolean isValidClassRoomName(String classRoomName, List<ClassRoom> classRooms) {
        if (classRoomName == null || classRoomName.length() < 15 || classRoomName.length() > 50) {
            return false;
        }
        return classRooms.stream().noneMatch(classRoom -> classRoom.getClassRoomName().equals(classRoomName));
    }
}
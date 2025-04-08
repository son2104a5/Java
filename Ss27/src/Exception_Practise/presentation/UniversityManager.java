package Exception_Practise.presentation;

import Exception_Practise.business.*;
import java.util.Scanner;

public class UniversityManager {
    private CourseManager courseManager;
    private TeacherManager teacherManager;
    private StudentManager studentManager;
    private CourseRegistrationManager registrationManager;
    private ClassRoomManager classRoomManager;

    public UniversityManager() {
        this.courseManager = new CourseManager();
        this.teacherManager = new TeacherManager();
        this.studentManager = new StudentManager();
        this.registrationManager = new CourseRegistrationManager();
        this.classRoomManager = new ClassRoomManager();
    }

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("************************* MENU QUẢN LÝ ĐẠI HỌC **********************");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    displayCourseMenu(scanner);
                    break;
                case 2:
                    displayTeacherMenu(scanner);
                    break;
                case 3:
                    displayStudentMenu(scanner);
                    break;
                case 4:
                    displayCourseRegistrationMenu(scanner);
                    break;
                case 5:
                    classRoomManager.addClassRoom(scanner, courseManager.getCourses(), teacherManager.getTeachers());
                    break;
                case 6:
                    System.out.println("Chức năng thống kê chưa được triển khai.");
                    break;
                case 7:
                    System.out.println("Đang thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 7);
    }

    private void displayCourseMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("************************* MENU QUẢN LÝ KHÓA HỌC *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo mã");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    courseManager.displayCourses();
                    break;
                case 2:
                    courseManager.addCourse(scanner);
                    break;
                case 3:
                    courseManager.updateCourse(scanner);
                    break;
                case 4:
                    courseManager.deleteCourse(scanner, classRoomManager.getClassRooms());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    private void displayTeacherMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("************************* MENU QUẢN LÝ GIẢNG VIÊN *************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    teacherManager.displayTeachers();
                    break;
                case 2:
                    teacherManager.addTeacher(scanner);
                    break;
                case 3:
                    teacherManager.updateTeacher(scanner);
                    break;
                case 4:
                    teacherManager.deleteTeacher(scanner, classRoomManager.getClassRooms());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    private void displayStudentMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("************************* MENU QUẢN LÝ SINH VIÊN *************************");
            System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    studentManager.displayStudents();
                    break;
                case 2:
                    studentManager.addStudent(scanner);
                    break;
                case 3:
                    studentManager.updateStudent(scanner);
                    break;
                case 4:
                    studentManager.deleteStudent(scanner, registrationManager.getRegistrations());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    private void displayCourseRegistrationMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("******************* MENU ĐĂNG KÝ KHÓA HỌC *****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    registrationManager.registerCourse(scanner, studentManager.getStudents(), courseManager.getCourses());
                    break;
                case 2:
                    registrationManager.cancelRegistration(scanner);
                    break;
                case 3:
                    registrationManager.approveRegistration(scanner);
                    break;
                case 4:
                    registrationManager.displayRegistrationsByCourse(studentManager.getStudents());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        UniversityManager manager = new UniversityManager();
        manager.displayMainMenu();
    }
}

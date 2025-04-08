package JDBC.business.service.student;

import JDBC.business.model.Student;
import JDBC.business.service.AppService;

public interface StudentService extends AppService<Student> {
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}

package JDBC.business.dao.student;

import JDBC.business.dao.AppDAO;
import JDBC.business.model.Student;

public interface StudentDAO extends AppDAO<Student> {
    int getCountStudentByStatus(boolean status);

    Student findById(int t);
}

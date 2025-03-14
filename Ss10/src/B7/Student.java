package B7;

public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên sinh viên không được để trống.");
        }
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Lỗi: Mã sinh viên không được để trống.");
        }
        if (gpa < 0) {
            System.out.println("Lỗi: GPA không hợp lệ.");
        }
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên sinh viên không hợp lệ.");
        } else {
            this.name = name;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Lỗi: Mã sinh viên không hợp lệ.");
        } else {
            this.id = id;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0) {
            System.out.println("Lỗi: GPA không hợp lệ.");
        } else {
            this.gpa = gpa;
        }
    }

    public String getDetails() {
        return "Tên: " + name + ", Mã: " + id + ", GPA: " + gpa;
    }
}


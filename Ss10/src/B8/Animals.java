package B8;

public class Animals {
    protected String name;
    protected int age;

    public Animals(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên động vật không được để trống.");
        }
        if (age < 0) {
            System.out.println("Lỗi: Tuổi động vật không hợp lệ.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên động vật không hợp lệ.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Lỗi: Tuổi động vật không hợp lệ.");
        } else {
            this.age = age;
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age);
    }

    public String makeSound() {
        return "Some generic sound";
    }
}


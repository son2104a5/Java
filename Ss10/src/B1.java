public class B1 {
    /*
    * 1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
    Tính đóng gói (Encapsulation) là một trong bốn đặc trưng quan trọng của lập trình hướng đối tượng (OOP), giúp gói gọn dữ liệu (thuộc tính) và hành vi (phương thức) vào bên trong một lớp và ẩn giấu các chi tiết bên trong khỏi bên ngoài.

    * Các thuộc tính thường được khai báo private, còn các phương thức truy cập sẽ là public getter và setter.
    * Lý do quan trọng:
    - Giúp bảo vệ dữ liệu nội bộ của đối tượng khỏi việc truy cập hoặc thay đổi không hợp lệ từ bên ngoài.
    - Tăng tính bảo mật, tính toàn vẹn dữ liệu.
    - Giúp dễ bảo trì, dễ mở rộng và tái sử dụng mã nguồn.
    *
    * 2. Làm thế nào để áp dụng tính đóng gói trong Java?
        Để áp dụng:

        - Khai báo các thuộc tính của lớp là private (chỉ dùng được bên trong lớp).
        - Cung cấp các phương thức public để truy cập hoặc thay đổi giá trị (getter và setter).
        Getter: Dùng để lấy giá trị thuộc tính.
        Setter: Dùng để gán/đổi giá trị thuộc tính.
    * */

//    3. Ví dụ minh họa
public class Person {
    // Thuộc tính private
    private String name;
    private int age;

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter cho name
    public void setName(String name) {
        this.name = name;
    }

    // Getter cho age
    public int getAge() {
        return age;
    }

    // Setter cho age
    public void setAge(int age) {
        if (age >= 0) { // kiểm tra dữ liệu hợp lệ
            this.age = age;
        }
    }
}
//  Main
public class Main {
    public void main (String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(25);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}

/*
* 4. Lợi ích của tính đóng gói trong bảo vệ dữ liệu và kiểm soát truy cập:
- Bảo vệ dữ liệu (Data Protection): Dữ liệu bên trong đối tượng không bị thay đổi trực tiếp từ bên ngoài.
Có thể kiểm soát dữ liệu nhập vào bằng cách kiểm tra hợp lệ trong setter.
*
- Kiểm soát quyền truy cập (Access Control): Chỉ cho phép người dùng truy cập hoặc chỉnh sửa dữ liệu qua getter/setter.
Dễ dàng ẩn thông tin không cần thiết và chỉ cung cấp các phương thức cần thiết để sử dụng.
*
- Tăng khả năng bảo trì và mở rộng hệ thống: Khi cần thay đổi logic nội bộ, chỉ cần thay đổi bên trong lớp mà không ảnh hưởng phần khác của chương trình.
* */
}

public class B2 {
    /*
    * 1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
        + Kế thừa (Inheritance) là một trong những đặc điểm quan trọng của lập trình hướng đối tượng (OOP), cho phép lớp con (subclass) kế thừa các thuộc tính (fields) và phương thức (methods) của lớp cha (superclass).
        + Kế thừa giúp tái sử dụng mã nguồn, tăng khả năng mở rộng, và giảm dư thừa trong chương trình.
        - Lớp con có thể:
        + Sử dụng lại các thuộc tính/phương thức của lớp cha.
        + Ghi đè (override) phương thức để thay đổi hành vi.
        + Mở rộng thêm các chức năng mới.
        *
    * 2. Sự khác biệt giữa kế thừa và bao đóng (encapsulation):
    * - Kế thừa (Inheritance):
    * + Mục đích: Tái sử dụng mã nguồn và mở rộng chức năng
    * + Cách sử dụng: Dùng từ khóa extends
    * + Quan hệ giữa các lớp: Tạo mối quan hệ cha – con
    * + Đối tượng: Tăng khả năng mở rộng cho chương trình
    *
    * - Bao đóng (Encapsulation):
    * + Mục đích: Bảo vệ và kiểm soát quyền truy cập dữ liệu
    * + Cách sử dụng: Dùng private cho thuộc tính và getter/setter
    * + Quan hệ giữa các lớp: Không liên quan đến mối quan hệ giữa các lớp
    * + Đối tượng: Bảo vệ dữ liệu nội tại của lớp
    * */

//    3. Ví dụ minh họa:
// Lớp cha
public class Animal {
    protected String name;

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

    // Lớp con kế thừa từ Animal
    public class Dog extends Animal {
        public void bark() {
            System.out.println(name + " is barking.");
        }
    }

    // Chương trình chính
    public class Main {
        public void main(String[] args) {
            Dog dog = new Dog();
            dog.name = "Buddy";
            dog.eat();   // kế thừa từ Animal
            dog.bark();  // riêng của Dog
        }
    }

    /*
    * 4. Lợi ích và hạn chế của kế thừa trong Java
    - Lợi ích:
    + Tái sử dụng mã nguồn (code reuse).
    + Dễ mở rộng chương trình khi phát triển hệ thống lớn.
    + Tăng tính tổ chức và cấu trúc hệ thống.
    + Cho phép sử dụng tính đa hình (polymorphism).
    *
    - Hạn chế:
    + Gắn kết chặt chẽ giữa các lớp, nếu lớp cha thay đổi sẽ ảnh hưởng đến lớp con.
    + Khó kiểm soát nếu lạm dụng kế thừa, dẫn đến hệ thống rối rắm.
    + Java không hỗ trợ đa kế thừa nhiều lớp cha trực tiếp, chỉ có thể kế thừa từ một lớp cha duy nhất (có thể dùng interface để khắc phục).
    * */
}

public class B1 {
    /* So sánh chi tiết giữa Class và Object trong Java
    * - Class:
    * + Định nghĩa: Là bản thiết kế (blueprint) để tạo ra các đối tượng
    * + Vai trò: Xác định thuộc tính (fields/variables) và hành vi (methods) chung cho các đối tượng.
    * + Ví dụ thực tế: Class Car định nghĩa các đặc điểm như màu sắc, tốc độ, hãng xe.
    * + Từ khóa liên quan: class, extends, implements, abstract
    * - Object:
     * + Định nghĩa: Là thể hiện cụ thể (instance) của một class.
     * + Vai trò: Là thực thể thực tế sử dụng các thuộc tính và hành vi do class định nghĩa.
     * + Ví dụ thực tế: Car car1 = new Car(); là một đối tượng cụ thể có màu đỏ, tốc độ 120km/h.
     * + Từ khóa liên quan: new, this, instanceof
    * */
    // Class định nghĩa
     public static class Car {
        String color;
        int speed;

        void drive() {
            System.out.println("Car is driving at " + speed + " km/h");
        }
    }

    // Object được tạo từ Class
    public class Main {
        public static void main(String[] args) {
            Car myCar = new Car();
            myCar.color = "Red";
            myCar.speed = 120;
            myCar.drive();
        }
    }
}

public class B2 {
    /*
    * 1. Định nghĩa tính trừu tượng và vai trò của nó
    * Tính trừu tượng (Abstraction) trong lập trình hướng đối
    * tượng là kỹ thuật che giấu các chi tiết triển khai phức tạp
    * và chỉ hiển thị những đặc điểm quan trọng, cần thiết cho người dùng. Mục tiêu của
    * tính trừu tượng là đơn giản hóa quá trình phát triển phần mềm, giúp lập trình viên
    * tập trung vào chức năng chính thay vì loay hoay với chi tiết kỹ thuật. Trong Java,
    * tính trừu tượng đóng vai trò quan trọng trong việc thiết kế hệ thống phần mềm rõ ràng, dễ
    * bảo trì và mở rộng.
    *
    * 2. Phân tích vai trò của tính trừu tượng trong Java
    *   a. Tại sao cần tính trừu tượng trong phần mềm phức tạp?
    *   Trong các hệ thống phần mềm lớn, có rất nhiều thành phần hoạt động cùng nhau. Tính
    * trừu tượng giúp giảm bớt sự phức tạp bằng cách ẩn đi các chi tiết nội bộ của từng
    * thành phần, chỉ giữ lại phần giao tiếp với các thành phần khác. Nhờ vậy, các nhà phát
    * triển có thể làm việc độc lập ở từng phần hệ thống mà không ảnh hưởng đến nhau, giúp cải
    * thiện hiệu suất làm việc và giảm lỗi.
    *   b. Sự khác biệt giữa lớp trừu tượng và giao diện trong Java:
    * Tính kế thừa:
    * - Lớp trừu tượng (abstract class): Cho phép kế thừa một lớp trừu tượng
    * - Giao diện (interface): Cho phép triển khai nhiều interface
    * Thành phần:
    * - Lớp trừu tượng (abstract class): Có thể chứa cả phương thức trừu tượng và cụ thể
    * - Giao diện (interface): Chỉ chứa phương thức trừu tượng (trước Java 8) và
    * các phương thức mặc định (từ Java 8 trở đi)
    * Biến:
    * - Lớp trừu tượng (abstract class): Có thể có biến instance (thuộc tính)
    * - Giao diện (interface): Chỉ chứa hằng số (public static final)
    *
    * c. Liên hệ thực tế – Ví dụ minh họa: Một ví dụ điển hình của tính trừu tượng là
    * máy ATM. Người dùng chỉ cần biết cách rút tiền, chuyển khoản, kiểm tra số dư thông
    * qua giao diện màn hình cảm ứng. Họ không cần biết bên trong máy hoạt động như thế
    * nào – xử lý lệnh ra sao, kết nối ngân hàng thế nào. Tất cả chi tiết bên trong đã được ẩn
    * đi và chỉ những chức năng cần thiết được cung cấp cho người sử dụng.
    *
    * 3. Ưu điểm và hạn chế của tính trừu tượng
        Ưu điểm:
        - Giảm sự phụ thuộc giữa các phần trong chương trình.
        - Tăng khả năng mở rộng và bảo trì mã nguồn.
        - Hỗ trợ thiết kế hệ thống hướng module rõ ràng.
        Hạn chế:
        - Có thể làm tăng độ phức tạp nếu lạm dụng hoặc thiết kế không hợp lý.
        - Đòi hỏi người lập trình phải có tư duy trừu tượng tốt và hiểu rõ cấu trúc hệ thống.
    * */
}

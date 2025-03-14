package B6;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point point = new Point(2.5, 4.0);
        System.out.println("Tọa độ điểm tĩnh: " + point.toString());

        MoveablePoint movePoint = new MoveablePoint(2.5, 4.0, 1.0, 1.5);
        System.out.println("Trước khi di chuyển: " + movePoint.toString());

        movePoint.move();
        System.out.println("Sau khi di chuyển: " + movePoint.toString());

        movePoint.setXSpeed(2.0);
        movePoint.setYSpeed(2.5);
        movePoint.move();
        System.out.println("Sau khi thay đổi tốc độ và di chuyển tiếp: " + movePoint.toString());
    }
}



package B6;

public class Main {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(3, 4);
        Point2D p2 = new Point2D(7, 1);

        System.out.println("Tọa độ điểm p1:");
        p1.displayPoint();

        System.out.println("Tọa độ điểm p2:");
        p2.displayPoint();

        double distance = p1.distanceTo(p2);
        System.out.println("Khoảng cách giữa p1 và p2: " + distance);

        p1.setX(5);
        p1.setY(6);
        System.out.println("Tọa độ p1 sau khi cập nhật:");
        p1.displayPoint();
    }
}


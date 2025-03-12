package B5;

public class Main {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3, 4);
        Vector2D v2 = new Vector2D(1, 2);

        System.out.println("Vector 1: ");
        v1.displayVector();

        System.out.println("Vector 2: ");
        v2.displayVector();

        System.out.println("Độ dài vector 1: " + v1.calculateMagnitude());
        System.out.println("Độ dài vector 2: " + v2.calculateMagnitude());

        Vector2D sum = v1.add(v2);
        System.out.print("Tổng vector: ");
        sum.displayVector();

        Vector2D diff = v1.subtract(v2);
        System.out.print("Hiệu vector: ");
        diff.displayVector();

        System.out.println("Tích vô hướng: " + v1.dotProduct(v2));
    }
}

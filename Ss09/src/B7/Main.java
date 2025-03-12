package B7;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation eq = new QuadraticEquation(1, -3, 2);

        System.out.println("Giải phương trình bậc hai: 1x^2 - 3x + 2 = 0");
        eq.display();

        System.out.println("\nTrường hợp nghiệm kép:");
        QuadraticEquation eq2 = new QuadraticEquation(1, -2, 1);
        eq2.display();

        System.out.println("\nTrường hợp không có nghiệm thực:");
        QuadraticEquation eq3 = new QuadraticEquation(2, 1, 5);
        eq3.display();
    }
}


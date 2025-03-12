package B7;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(delta)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    public void display() {
        if (hasRealRoots()) {
            double root1 = getRoot1();
            double root2 = getRoot2();
            if (root1 == root2) {
                System.out.println("Phương trình có nghiệm kép: x = " + root1);
            } else {
                System.out.println("Phương trình có hai nghiệm phân biệt:");
                System.out.println("x1 = " + root1);
                System.out.println("x2 = " + root2);
            }
        } else {
            System.out.println("Phương trình không có nghiệm thực.");
        }
    }
}


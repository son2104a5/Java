package B9;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(4, 5);

        Fraction sum = f1.add(f2);
        Fraction diff = f1.subtract(f2);
        Fraction product = f1.multiply(f2);
        Fraction quotient = f1.divide(f2);

        System.out.println("Phân số 1: " + f1);
        System.out.println("Phân số 2: " + f2);

        System.out.println("Cộng: " + sum);
        System.out.println("Trừ: " + diff);
        System.out.println("Nhân: " + product);
        System.out.println("Chia: " + quotient);
    }
}


package B2;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sumTwo = calc.add(10, 20);
        int sumThree = calc.add(5, 15, 25);

        System.out.println("Tổng hai số: " + sumTwo);
        System.out.println("Tổng ba số: " + sumThree);
    }
}

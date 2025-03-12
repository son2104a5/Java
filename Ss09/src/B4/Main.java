package B4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle(1);
        circle.display();
        circle.setRadius(sc);
        circle.display();
    }
}

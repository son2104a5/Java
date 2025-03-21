import java.util.ArrayList;
import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();

        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            inputList.add(sc.nextInt());
        }

        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        for (int num : inputList) {
            if (isPrime(num)) {
                primes.add(num);
            } else if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        System.out.println("Số chẵn: " + evens);
        System.out.println("Số lẻ: " + odds);
        System.out.println("Số nguyên tố: " + primes);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

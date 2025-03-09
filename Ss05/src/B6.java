import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        int[] markingArray = new int[1001];
        int[] originalArray = {10, 20, 30, 40, 50, 10, 60, 70, 80, 20, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90};

        for (int num : originalArray) {
            markingArray[num]++;
        }

        int maxCount = 0;
        for (int num : originalArray) {
            if (markingArray[num] > maxCount) {
                maxCount = markingArray[num];
            }
        }
        System.out.println("\n\nPhần tử xuất hiện nhiều nhất trong mảng original:");

        for (int num : originalArray) {
            if (markingArray[num] == maxCount) {
                System.out.println("Phần tử: " + num + ", Số lần xuất hiện: " + maxCount);
                markingArray[num] = 0;
            }
        }
    }
}

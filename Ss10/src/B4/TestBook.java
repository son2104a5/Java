package B4;

import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book = new Book("Harry Potter", "J. K. Rowling", 200.34);

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());

        book.setPrice(sc.nextDouble());
    }
}

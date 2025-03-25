package B4;

public interface IShape {
    default double area() {
        return 0;
    }

    static void description() {
        System.out.println("This is a shape");
    }
}

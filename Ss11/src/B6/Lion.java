package B6;

public class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(name + " (Lion): Roar!");
    }

    @Override
    public void move() {
        System.out.println(name + " (Lion): The lion is running.");
    }
}

package B6;

public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(name + " (Elephant): Trumpet!");
    }

    @Override
    public void move() {
        System.out.println(name + " (Elephant): The elephant is walking.");
    }
}


package B2;

public class Main {
    public static void main(String[] args) {
        IAnimal dog = AnimalFactory.createAnimal("dog");
        dog.speak();

        IAnimal cat = AnimalFactory.createAnimal("cat");
        cat.speak();
    }
}

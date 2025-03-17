package B6;

public class Main {
    public static void main(String[] args) {
        Lion lion1 = new Lion("Simba", 5);
        Elephant elephant1 = new Elephant("Dumbo", 10);

        Zoo zoo = new Zoo();
        zoo.addAnimal(lion1);
        zoo.addAnimal(elephant1);

        System.out.println("=== Zoo Animals Actions ===");
        zoo.showAnimals();
    }
}

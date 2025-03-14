package B8;

public class TestAnimals {
    public static void main(String[] args) {
        Animals[] animals = new Animals[4];
        animals[0] = new Dog("Chó Vàng", 3, "Labrador");
        animals[1] = new Cat("Mèo Mun", 2, "Đen");
        animals[2] = new Dog("Chó Mập", 5, "Poodle");
        animals[3] = new Cat("Mèo Trắng", 1, "Trắng");

        for (Animals animal : animals) {
            animal.displayInfo();
            System.out.println("Âm thanh: " + animal.makeSound());
            System.out.println("-------------------------");
        }
    }
}


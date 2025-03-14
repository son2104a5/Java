package B8;

public class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        if (breed == null || breed.trim().isEmpty()) {
            System.out.println("Lỗi: Giống chó không được để trống.");
        }
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            System.out.println("Lỗi: Giống chó không hợp lệ.");
        } else {
            this.breed = breed;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + breed);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}


package B8;

public class Cat extends Animals {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);
        if (furColor == null || furColor.trim().isEmpty()) {
            System.out.println("Lỗi: Màu lông không được để trống.");
        }
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if (furColor == null || furColor.trim().isEmpty()) {
            System.out.println("Lỗi: Màu lông không hợp lệ.");
        } else {
            this.furColor = furColor;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Màu lông: " + furColor);
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}


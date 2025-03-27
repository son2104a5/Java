package B4;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;

    LocalDate now = LocalDate.now();

    public Person() {
    }

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return now.getYear() - birthDate.getYear();
    }

    public void printInfo() {
        System.out.println("Tên: " + name + ", Ngày sinh: " + birthDate + ", Tuổi: " + getAge());
    }
}

package B10;

import java.util.Optional;

public class User {
    private int id;
    private String name;
    private Optional<String> email;

    public User() {
    }

    public User(int id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email.orElse("Không có Email");
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }
}

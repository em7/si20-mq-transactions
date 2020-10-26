package si20.demotransactions.proj1.model;

public class User {

    private String name;

    public User() {
    }

    public static User createWithName(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

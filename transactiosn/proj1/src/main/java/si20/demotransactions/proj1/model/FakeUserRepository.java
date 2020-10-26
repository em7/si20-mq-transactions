package si20.demotransactions.proj1.model;

import org.springframework.stereotype.Repository;

@Repository
public class FakeUserRepository {
    public User retrieveUser(String name) {

        if (name == null || name.isBlank() || name.toLowerCase().equals("empty")) {
            throw new RuntimeException("Name is null or empty.");
        }

        return User.createWithName(name);
    }
}

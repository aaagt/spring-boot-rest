package aaagt.springboot.rest.app.repository;

import aaagt.springboot.rest.app.model.Authorities;
import aaagt.springboot.rest.app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> storage = Map.ofEntries(
            Map.entry(new User("user1", "123"), List.of(Authorities.READ, Authorities.WRITE)),
            Map.entry(new User("user2", "123"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
            Map.entry(new User("user3", "123"), List.of(Authorities.READ))
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        return storage.getOrDefault(new User(user, password), List.of());
    }
}

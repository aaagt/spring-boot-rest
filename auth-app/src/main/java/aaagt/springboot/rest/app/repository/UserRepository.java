package aaagt.springboot.rest.app.repository;

import aaagt.springboot.rest.app.model.Authorities;
import aaagt.springboot.rest.app.model.UserCredentials;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<UserCredentials, List<Authorities>> storage = Map.ofEntries(
            Map.entry(new UserCredentials("user1", "123"), List.of(Authorities.READ, Authorities.WRITE)),
            Map.entry(new UserCredentials("user2", "123"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
            Map.entry(new UserCredentials("user3", "123"), List.of(Authorities.READ))
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        return storage.getOrDefault(new UserCredentials(user, password), List.of());
    }
}

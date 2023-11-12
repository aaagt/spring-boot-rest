package aaagt.springboot.rest.app.service;

import aaagt.springboot.rest.app.exception.UnauthorizedUser;
import aaagt.springboot.rest.app.model.Authorities;
import aaagt.springboot.rest.app.model.User;
import aaagt.springboot.rest.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

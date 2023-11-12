package aaagt.springboot.rest.app.controller;

import aaagt.springboot.rest.app.model.Authorities;
import aaagt.springboot.rest.app.model.User;
import aaagt.springboot.rest.app.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}

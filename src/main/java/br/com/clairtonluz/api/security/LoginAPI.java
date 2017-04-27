package br.com.clairtonluz.api.security;

import br.com.clairtonluz.model.entity.security.User;
import br.com.clairtonluz.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
public class LoginAPI {

    @Autowired
    private UserService userService;

    @RequestMapping("/api/login")
    public User user(Principal principal) {
        return userService.findByUsername(principal.getName());
    }
}

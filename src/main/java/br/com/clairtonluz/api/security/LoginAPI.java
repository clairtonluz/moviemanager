package br.com.clairtonluz.api.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
public class LoginAPI {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}

package br.com.clairtonluz.service.security;

import br.com.clairtonluz.model.entity.security.User;
import br.com.clairtonluz.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Integer id) {
        User user = userRepository.findOne(id);
        removePassword(user);
        return user;
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        removePassword(user);
        return user;
    }

    private void removePassword(User user) {
        if (user != null) {
            user.setPassword(null);
        }
    }
}

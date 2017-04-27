package br.com.clairtonluz.repository.security;

import br.com.clairtonluz.model.entity.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

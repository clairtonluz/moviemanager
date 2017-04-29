package br.com.clairtonluz.repository;

import br.com.clairtonluz.model.entity.Favorite;
import br.com.clairtonluz.model.entity.security.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

    List<Favorite> findByUserIdOrderByUpdatedAtDesc(Integer userId);
}

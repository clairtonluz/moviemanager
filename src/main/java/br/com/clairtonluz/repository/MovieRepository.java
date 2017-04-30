package br.com.clairtonluz.repository;

import br.com.clairtonluz.model.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByNameIgnoreCaseContaining(String name);
}

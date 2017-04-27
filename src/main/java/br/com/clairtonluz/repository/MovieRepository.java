package br.com.clairtonluz.repository;

import br.com.clairtonluz.model.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Movie findByName(String name);
}

package br.com.clairtonluz.service;

import br.com.clairtonluz.model.entity.Movie;
import br.com.clairtonluz.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Integer id) {
        return movieRepository.findOne(id);
    }

    @Transactional
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    public void delete(Integer id) {
        Movie movie = movieRepository.findOne(id);
        movieRepository.delete(movie);
    }

    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }
}

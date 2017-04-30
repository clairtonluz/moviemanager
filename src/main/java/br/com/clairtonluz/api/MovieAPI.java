package br.com.clairtonluz.api;

import br.com.clairtonluz.model.entity.Movie;
import br.com.clairtonluz.service.FavoriteService;
import br.com.clairtonluz.service.MovieService;
import br.com.clairtonluz.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController()
@RequestMapping("api/movies")
public class MovieAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Movie> query(@RequestParam(name = "name", required = false) String name) {
        if (name != null && !name.trim().isEmpty()) {
            return movieService.findByNameLike(name);
        } else {
            return movieService.findAll();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getPorId(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Movie save(@Valid @RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Movie update(@Valid @RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable @NotNull Integer id) {
        movieService.delete(id);
    }

}

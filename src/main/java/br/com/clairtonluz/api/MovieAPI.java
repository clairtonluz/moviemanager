package br.com.clairtonluz.api;

import br.com.clairtonluz.model.entity.Favorite;
import br.com.clairtonluz.model.entity.Movie;
import br.com.clairtonluz.service.FavoriteService;
import br.com.clairtonluz.service.MovieService;
import br.com.clairtonluz.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    public Iterable<Movie> query() {
        return movieService.findAll();
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

    @RequestMapping(value = "/{id}/favorites", method = RequestMethod.GET)
    public List<Favorite> getFavoriteById(@PathVariable Integer id) {
        return favoriteService.findByUser(id);
    }

    @RequestMapping(value = "/{id}/favorites/{favoriteId}", method = RequestMethod.GET)
    public Favorite getFavoriteById(@PathVariable Integer id, @PathVariable Integer favoriteId) {
        Favorite favorite = favoriteService.findById(favoriteId);
        if (favorite != null && favorite.getUserId().equals(id)) {
            return favorite;
        }
        return null;
    }

}

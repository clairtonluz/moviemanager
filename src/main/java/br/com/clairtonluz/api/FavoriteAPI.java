package br.com.clairtonluz.api;

import br.com.clairtonluz.exception.BadRequestException;
import br.com.clairtonluz.exception.ForbiddenException;
import br.com.clairtonluz.exception.NotFoundException;
import br.com.clairtonluz.model.entity.Favorite;
import br.com.clairtonluz.model.entity.security.User;
import br.com.clairtonluz.service.FavoriteService;
import br.com.clairtonluz.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController()
@RequestMapping("api/favorites")
public class FavoriteAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private FavoriteService favoriteService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Favorite> getFavoriteById(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return favoriteService.findByUser(user.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Favorite getFavoriteById(Principal principal, @PathVariable Integer id) {
        User user = userService.findByUsername(principal.getName());
        Favorite favorite = favoriteService.findById(id);
        if (favorite != null && favorite.getUserId().equals(user.getId())) {
            return favorite;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Favorite save(Principal principal, @Valid @RequestBody Favorite favorite) {
        if (favorite.getId() != null) {
            throw new BadRequestException("Operação inválida");
        }
        User user = userService.findByUsername(principal.getName());
        favorite.setUserId(user.getId());
        return favoriteService.save(favorite);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Favorite update(Principal principal, @PathVariable @NotNull Integer id, @Valid @RequestBody Favorite favorite) {
        if (hasPermission(id, principal)) {
            User user = userService.findByUsername(principal.getName());
            favorite.setUserId(user.getId());
            return favoriteService.save(favorite);
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(Principal principal, @PathVariable @NotNull Integer id) {
        if (hasPermission(id, principal)) {
            favoriteService.delete(id);
        }
    }

    private boolean hasPermission(Integer favoriteId, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Favorite favorite = favoriteService.findById(favoriteId);
        if (favorite == null) {
            throw new NotFoundException();
        }

        if (!favorite.getUserId().equals(user.getId())) {
            throw new ForbiddenException("Você não tem permissão para alterar esse recurso");
        }

        return true;
    }
}

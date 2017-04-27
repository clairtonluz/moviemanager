package br.com.clairtonluz.api;

import br.com.clairtonluz.model.entity.Type;
import br.com.clairtonluz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController()
@RequestMapping("api/types")
public class TypeAPI {

    @Autowired
    private TypeService typeService;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Type> getTypeById() {
        return typeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Type getTypeById(@PathVariable Integer id) {
        return typeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Type save(@Valid @RequestBody Type type) {
        return typeService.save(type);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Type update(@PathVariable @NotNull Integer id, @Valid @RequestBody Type type) {
        return typeService.save(type);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable @NotNull Integer id) {
        typeService.delete(id);
    }

}

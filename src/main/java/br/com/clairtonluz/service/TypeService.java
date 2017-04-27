package br.com.clairtonluz.service;

import br.com.clairtonluz.model.entity.Type;
import br.com.clairtonluz.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Type findById(Integer id) {
        return typeRepository.findOne(id);
    }

    @Transactional
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    public void delete(Integer id) {
        Type type = typeRepository.findOne(id);
        typeRepository.delete(type);
    }

    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }
}

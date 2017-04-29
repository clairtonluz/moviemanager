package br.com.clairtonluz.service;

import br.com.clairtonluz.model.entity.Favorite;
import br.com.clairtonluz.repository.FavoriteRepository;
import br.com.clairtonluz.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;

    public Favorite findById(Integer id) {
        return favoriteRepository.findOne(id);
    }

    @Transactional
    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Transactional
    public void delete(Integer id) {
        Favorite favorite = favoriteRepository.findOne(id);
        if (favorite != null)
            favoriteRepository.delete(favorite);
    }

    public List<Favorite> findByUser(Integer userId) {
        return favoriteRepository.findByUserIdOrderByUpdatedAtDesc(userId);
    }
}

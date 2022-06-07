package com.movieStore.service.impl;

import com.movieStore.model.UserMovie;
import com.movieStore.repository.UserMovieRepository;
import com.movieStore.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("UserMovieService")
public class UserMovieServiceImpl implements UserMovieService {

    private final UserMovieRepository userMovieRepository;

    @Autowired
    public UserMovieServiceImpl(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }

    @Override
    public List<UserMovie> getAll(Long id) {
        return userMovieRepository.findAllByUserId(id);
    }

    @Override
    public Optional<UserMovie> findById(Long id) {
        return userMovieRepository.findById(id);
    }

    @Override
    public void save(UserMovie userMovie) {
        userMovieRepository.save(userMovie);
    }

    @Override
    public UserMovie update(UserMovie userMovie) {
        return userMovieRepository.save(userMovie);
    }

    @Override
    public void delete(Long id) {
        userMovieRepository.deleteById(id);
    }
}

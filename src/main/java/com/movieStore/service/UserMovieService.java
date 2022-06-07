package com.movieStore.service;

import com.movieStore.model.UserMovie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserMovieService {

    List<UserMovie> getAll(Long id);

    Optional<UserMovie> findById(Long id);

    void save(UserMovie userMovie);

    UserMovie update(UserMovie userMovie);

    void delete(Long id);

}

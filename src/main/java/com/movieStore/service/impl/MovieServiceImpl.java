package com.movieStore.service.impl;

import com.movieStore.model.Movie;
import com.movieStore.repository.MovieRepository;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("MovieService")
public class MovieServiceImpl implements AbstractService<Movie, Long, String> {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie find(String string) {
        return movieRepository.findByTitle(string);
    }

    @Override
    public void save(Movie model) {
        movieRepository.save(model);
    }

    @Override
    public Movie update(Movie model) {
        return movieRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        movieRepository.deleteById(value);
    }
}

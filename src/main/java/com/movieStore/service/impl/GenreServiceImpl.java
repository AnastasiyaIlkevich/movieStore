package com.movieStore.service.impl;

import com.movieStore.model.Genre;
import com.movieStore.repository.GenreRepository;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("GenreService")
public class GenreServiceImpl implements AbstractService<Genre, Long, String> {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre find(String string) {
        return genreRepository.findByName(string);
    }

    @Override
    public void save(Genre model) {
        genreRepository.save(model);
    }

    @Override
    public Genre update(Genre model) {
        return genreRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        genreRepository.deleteById(value);
    }
}

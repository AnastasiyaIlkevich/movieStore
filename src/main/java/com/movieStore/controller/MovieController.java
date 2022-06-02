package com.movieStore.controller;

import com.movieStore.model.Movie;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity Movie
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final AbstractService abstractService;

    @Autowired
    public MovieController(@Qualifier("MovieService") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return abstractService.getAll();
    }

    @GetMapping("/{name}")
    public Movie getMovieByName(@PathVariable("name") String name) {
        return (Movie) abstractService.find(name);
    }

    @PostMapping
    public void saveMovie(@RequestBody Movie movie) {
        abstractService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable("id") Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return (Movie) abstractService.update(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        abstractService.delete(id);
    }
}

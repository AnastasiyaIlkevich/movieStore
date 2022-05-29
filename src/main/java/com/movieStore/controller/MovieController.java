package com.movieStore.controller;

import com.movieStore.model.Movie;
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

    //need to create GenreService

    @GetMapping
    public List<Movie> getAll(){
        return null;
    }

    @GetMapping("/id")
    public Movie getMovieById(){
        Movie movie = new Movie();
        return movie;
    }

    @PostMapping
    public void saveMovie(@RequestBody Movie movie){
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable("id")Long id, @RequestBody Movie movie){
        return movie;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id")Long id){
    }
}

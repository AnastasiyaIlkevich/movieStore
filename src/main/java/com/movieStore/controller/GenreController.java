package com.movieStore.controller;

import com.movieStore.model.Genre;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity Genre
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/genre")
public class GenreController {

    //need to create GenreService

    @GetMapping
    public List<Genre> getAll() {
        return null;
    }

    @GetMapping("/{name}")
    public Genre getGenreByName(@PathVariable("name") String name) {
        Genre genre = new Genre();
        return genre;
    }

    @PostMapping()
    public void saveGenre(@RequestBody Genre genre){
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre){
        return genre;
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id){
    }
}

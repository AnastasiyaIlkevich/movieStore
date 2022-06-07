package com.movieStore.controller;

import com.movieStore.dto.GenreDtoUpdate;
import com.movieStore.model.Genre;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final AbstractService abstractService;

    @Autowired
    public GenreController(@Qualifier("GenreService") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    public List<Genre> getAll() {
        return abstractService.getAll();
    }

    @GetMapping("/{name}")
    public Genre getGenreByName(@PathVariable("name") String name) {
        return (Genre)abstractService.find(name);
    }

    @PostMapping()
    public void saveGenre(@RequestBody Genre genre){
        abstractService.save(genre);
    }

    @PutMapping("/{id}")
    public GenreDtoUpdate updateGenre(@PathVariable("id") Long id, @RequestBody GenreDtoUpdate genreDto){
        Genre genre = genreDto.toGenre();
        return genreDto.fromGenre((Genre)abstractService.update(genre));
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id){
        abstractService.delete(id);
    }
}

package com.movieStore.controller;

import com.movieStore.model.UserMovie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity UserMovie
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@RestController
@RequestMapping("/userMovie")
public class UserMovieController {

    //need to create UserMovieService

    @GetMapping
    public List<UserMovie> getAllUserMovie() {
        return null;
    }

    @GetMapping("/{name}")
    public UserMovie getUserMovieByName(@PathVariable("name") String name) {
        return new UserMovie();
    }

    @PostMapping
    public void saveUserMovie(@RequestBody UserMovie userMovie) {
    }

    @PutMapping("/{id}")
    public UserMovie updateUserMovie(@PathVariable("id") Long id, @RequestBody UserMovie userMovie) {
        return userMovie;
    }

    @DeleteMapping("/{id}")
    public void deleteUserMovie(@PathVariable("id") Long id) {
    }

}

package com.movieStore.controller;

import com.movieStore.dto.UserMovieDtoUpdate;
import com.movieStore.model.UserMovie;
import com.movieStore.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for entity UserMovie
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@RestController
@RequestMapping("/userMovie")
public class UserMovieController {

    private final UserMovieService userMovieService;

    @Autowired
    public UserMovieController(@Qualifier("UserMovieService") UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @GetMapping("/all/{id}")
    public List<UserMovie> getAllUserMovie(@PathVariable("id") Long id) {
        return userMovieService.getAll(id);
    }

    @GetMapping("/{id}")
    public Optional<UserMovie> getUserMovieById(@PathVariable("id") Long id) {
        return userMovieService.findById(id);
    }

    @PostMapping
    public void saveUserMovie(@RequestBody UserMovie userMovie) {
        userMovieService.save(userMovie);
    }

    @PutMapping("/{id}")
    public UserMovieDtoUpdate updateUserMovie(@PathVariable("id") Long id, @RequestBody UserMovieDtoUpdate userMovieDto) {
        userMovieDto.setId(id);
        UserMovie userMovie = userMovieDto.toUserMovie();
        return userMovieDto.fromUserMovieDto(userMovieService.update(userMovie));
    }

    @DeleteMapping("/{id}")
    public void deleteUserMovie(@PathVariable("id") Long id) {
        userMovieService.delete(id);
    }
}

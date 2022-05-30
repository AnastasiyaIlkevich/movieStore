package com.movieStore.controller;

import com.movieStore.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity user
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    //need to create UserService

    @GetMapping
    private List<User> getAll() {
        return null;
    }

    @GetMapping("/{Username}")
    public User getUserByName(@PathVariable("username") String username) {
        User user = new User();
        return user;
    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
    }
}

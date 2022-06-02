package com.movieStore.controller;

import com.movieStore.model.User;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final AbstractService abstractService;
    @Autowired
    public UserController(AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    private List<User> getAll() {
       return abstractService.getAll();
    }

    @GetMapping("/{username}")
    public User getUserByName(@PathVariable("username") String username) {
        return (User) abstractService.find(username);
    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {
        abstractService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return (User) abstractService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        abstractService.delete(id);
    }
}

package com.movieStore.controller;

import com.movieStore.model.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity Role
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    //need to create RoleService

    @GetMapping
    public List<Role> getAllRoles() {
        return null;
    }

    @GetMapping("/{name}")
    public Role getRoleByName(@PathVariable("name") String name) {
        return new Role();
    }

    @PostMapping
    public void saveRole(@RequestBody Role role) {
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
        return role;
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
    }

}

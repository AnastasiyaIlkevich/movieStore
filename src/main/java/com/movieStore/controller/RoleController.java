package com.movieStore.controller;

import com.movieStore.dto.RoleDtoUpdate;
import com.movieStore.model.Role;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final AbstractService abstractService;

    @Autowired
    public RoleController(@Qualifier("RoleService") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return abstractService.getAll();
    }

    @GetMapping("/{name}")
    public Role getRoleByName(@PathVariable("name") String name) {
        return (Role) abstractService.find(name);
    }

    @PostMapping
    public void saveRole(@RequestBody Role role) {
        abstractService.save(role);
    }

    @PutMapping("/{id}")
    public RoleDtoUpdate updateRole(@PathVariable("id") Long id, @RequestBody RoleDtoUpdate roleDto) {
        roleDto.setId(id);
        Role role = roleDto.toRole();
        return roleDto.fromRole((Role) abstractService.update(role));
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        abstractService.delete(id);
    }

}

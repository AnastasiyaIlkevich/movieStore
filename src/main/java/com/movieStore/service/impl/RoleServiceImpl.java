package com.movieStore.service.impl;

import com.movieStore.model.Role;
import com.movieStore.repository.RoleRepository;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RoleService")
public class RoleServiceImpl implements AbstractService<Role, Long, String> {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role find(String string) {
        return roleRepository.findByName(string);
    }

    @Override
    public void save(Role model) {
        roleRepository.save(model);
    }

    @Override
    public Role update(Role model) {
        return roleRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        roleRepository.deleteById(value);
    }
}

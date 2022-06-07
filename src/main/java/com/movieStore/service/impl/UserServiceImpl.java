package com.movieStore.service.impl;

import com.movieStore.model.Role;
import com.movieStore.model.User;
import com.movieStore.repository.RoleRepository;
import com.movieStore.repository.UserRepository;
import com.movieStore.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Transactional
@Component("UserService")
public class UserServiceImpl implements AbstractService<User, Long, String> {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User find(String string) {
        return userRepository.findByUsername(string);
    }

    @Override
    public void save(User model) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        model.setRoles(roles);
        userRepository.save(model);
    }

    @Override
    public User update(User model) {
        model.setRoles(userRepository.getById(model.getId()).getRoles());
        return userRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        userRepository.deleteById(value);
    }
}

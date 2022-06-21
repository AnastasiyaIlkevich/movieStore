package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movieStore.model.Role;
import com.movieStore.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Implementation of a data transfer object designed
 * to convert json and further save it to the database.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class UserDtoUpdate {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;

    public User toUser() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setRoles(getRoles());
        return user;
    }

    public UserDtoUpdate fromUser(User user) {
        UserDtoUpdate userDto = new UserDtoUpdate();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}

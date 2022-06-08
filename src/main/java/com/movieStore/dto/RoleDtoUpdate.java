package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movieStore.model.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of a data transfer object designed
 * to convert json and further save it to the database.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDtoUpdate {

    private long id;
    private String name;

    public Role toRole() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }

    public RoleDtoUpdate fromRole(Role role) {
        RoleDtoUpdate roleDto = new RoleDtoUpdate();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

}

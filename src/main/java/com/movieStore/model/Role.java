package com.movieStore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * An object representing the role
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}

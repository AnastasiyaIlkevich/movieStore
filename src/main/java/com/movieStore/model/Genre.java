package com.movieStore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * An object representing the Genre
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */

@Entity
@Table(name = "genres")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "external_id")
    private Long externalId;
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

}

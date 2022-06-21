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
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@Entity
@Table(name = "genres")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "external_id")
    private Long externalId;
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

}

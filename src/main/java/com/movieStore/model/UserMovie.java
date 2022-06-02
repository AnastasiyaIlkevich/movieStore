package com.movieStore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * An object representing the userMovie
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */

@Entity
@Table(name = "user_movie")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated
    private Status status;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private double rating;
    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;
    @Column(name = "updated_timestamp")
    private Timestamp modifiedTimestamp;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @PreUpdate
    public void preUpdate() {
        modifiedTimestamp = new Timestamp(Instant.now().toEpochMilli());
    }
}

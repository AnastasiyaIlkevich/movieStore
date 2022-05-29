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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @PreUpdate
    public void preUpdate() {
        modifiedTimestamp = new Timestamp(Instant.now().toEpochMilli());
    }
}

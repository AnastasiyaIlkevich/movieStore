package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movieStore.model.Status;
import com.movieStore.model.UserMovie;
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
public class UserMovieDtoUpdate {

    private Long id;
    private Status status;
    private String description;
    private double rating;

    public UserMovie toUserMovie() {
        UserMovie userMovie = new UserMovie();
        userMovie.setId(id);
        userMovie.setStatus(status);
        userMovie.setRating(rating);
        userMovie.setDescription(description);
        return userMovie;
    }

    public UserMovieDtoUpdate fromUserMovieDto(UserMovie userMovie) {
        UserMovieDtoUpdate userMovieDto = new UserMovieDtoUpdate();
        userMovieDto.setId(userMovie.getId());
        userMovieDto.setStatus(userMovie.getStatus());
        userMovieDto.setRating(userMovie.getRating());
        userMovieDto.setDescription(userMovie.getDescription());
        return userMovieDto;
    }
}

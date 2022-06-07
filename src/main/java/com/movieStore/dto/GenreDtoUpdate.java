package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movieStore.model.Genre;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of a data transfer object designed
 * to convert json and further save it to the database.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class GenreDtoUpdate {

    private String name;
    @JsonProperty("id")
    private Long externalId;

    public Genre toGenre() {
        Genre genre = new Genre();
        genre.setExternalId(getExternalId());
        genre.setName(getName());
        return genre;
    }

    public GenreDtoUpdate fromGenre(Genre genre) {
        GenreDtoUpdate genreDto = new GenreDtoUpdate();
        genreDto.setExternalId(genre.getExternalId());
        genreDto.setName(genre.getName());
        return genreDto;
    }

}
